import { Component, OnInit } from '@angular/core';
import { FileService } from '../../../services/file.service/file.service';
import { FileModel } from '../../../models/file.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-file.component',
  imports: [FormsModule],
  templateUrl: './file.component.html',
  styleUrl: './file.component.css',
})
export class FileComponent implements OnInit{
  files:FileModel[]=[];
  newFile:FileModel=new FileModel();
  
  titulo:string="";
  carpeta:string="";
  categorias:string[]=[];
  
  
  constructor(private fileService:FileService){}

  ngOnInit(): void {
    this.loadFiles();
  }

  loadFiles(){
    this.fileService.getFiles().subscribe(data=>{
      this.files=data;
    });
  }

  saveFile(){
    this.fileService.createFile(this.newFile).subscribe(data=>{
      //this.loadFiles();
      this.newFile.filename=this.titulo;
      this.newFile.folder.foldername=this.carpeta;
      this.newFile.tag=this.categorias;
      this.newFile= new FileModel();
    });
  }
}
