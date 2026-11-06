import { Component, OnInit } from '@angular/core';
import { FileService } from '../../../services/file.service/file.service';
import { FileModel } from '../../../models/file.model';
import { FormsModule, FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-file.component',
  imports: [FormsModule,CommonModule,ReactiveFormsModule],
  templateUrl: './file.component.html',
  styleUrl: './file.component.css',
})
export class FileComponent implements OnInit{
  files:FileModel[]=[];
  newFile:FileModel=new FileModel();
  carpetas:any[]=[];
  /* titulo:string="";
  carpeta:string="";
  categorias:string[]=[]; */
  id:number=0;
  titulo:string='';
  categorias:string[]=[];
  carpeta:string='';

  addMovie:FormGroup;
  
  constructor(private fileService:FileService,private cDRef:ChangeDetectorRef){
    this.addMovie=new FormGroup({
      titulo:new FormControl(''),
      categorias:new FormControl([]),
      carpeta:new FormControl('')
    });
  }

  ngOnInit(): void {
    this.loadFiles();
  }

  loadFiles(){
    this.fileService.getFiles().subscribe(data=>{
      this.files=data;
      this.folders();
      this.cDRef.detectChanges();
    });
   
  }

  folders(){
    for(let i=0;i<this.files.length;i++){
      if(!this.carpetas.includes(this.files[i].folder.foldername)){
        this.carpetas.push(this.files[i].folder.foldername)
      }
    }
  }

  /* addFile(){
    let file=new FileModel();
    file.id=this.id;
    file.filename=this.titulo;
    file.folder.foldername=this.carpeta;
    file.tag=this.categorias;
    console.log(file);
  } */

  saveFile(){
    //const{titulo,categorias,carpeta}=this.addMovie.value;
    this.newFile.id=0;
    this.newFile.tag=this.addMovie.value.categorias;
    this.newFile.filename=this.addMovie.value.titulo;
    this.newFile.folder=this.addMovie.value.carpeta; 
    
    console.log(this.newFile);

    this.fileService.createFile(this.newFile).subscribe(
      res => console.log(res)
    );
    //this.newFile=this.addMovie.value;
    //this.fileService.createFile(this.newFile).subscribe(data=>{
      //this.loadFiles();
/*       this.newFile.filename=titulo;
      this.newFile.folder.foldername=carpeta;
      this.newFile.tag=categorias;
      this.newFile= new FileModel(); */
   // });
  }


  

}
