import { Component, OnInit } from '@angular/core';
import { FileService } from '../../../services/file.service/file.service';
import { FileModel } from '../../../models/file.model';
import { FormsModule, FormGroup, FormControl } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-file.component',
  imports: [FormsModule,CommonModule],
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
   // this.folders();
  }

  loadFiles(){
    this.fileService.getFiles().subscribe(data=>{
      //console.log('files',data);
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

  saveFile(){
    const{titulo,categorias,carpeta}=this.addMovie.value;
    this.fileService.createFile(this.newFile).subscribe(data=>{
      //this.loadFiles();
      this.newFile.filename=titulo;
      this.newFile.folder.foldername=carpeta;
      this.newFile.tag=categorias;
      this.newFile= new FileModel();
    });
  }
}
