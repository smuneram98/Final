import { Component, OnInit } from '@angular/core';
import { FileService } from '../../../services/file.service/file.service';
import { FileModel } from '../../../models/file.model';

@Component({
  selector: 'app-file.component',
  imports: [],
  templateUrl: './file.component.html',
  styleUrl: './file.component.css',
})
export class FileComponent implements OnInit{
  files:FileModel[]=[];
  newFile:FileModel=new FileModel();
  
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
      this.loadFiles();
      this.newFile= new FileModel();
    });
  }
}
