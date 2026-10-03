import { Component, OnInit } from '@angular/core';
import { FolderModel } from '../../../models/folder.model';
import { FileModel } from '../../../models/file.model';
import { FolderService } from '../../../services/folder.service/folder.service';
import { FileService } from '../../../services/file.service/file.service';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-dashboard.component',
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export class DashboardComponent implements OnInit{
  folders:FolderModel[]=[];
  files:FileModel[]=[];

  constructor(private folderService:FolderService, private fileService:FileService){}

  ngOnInit(): void {
    
  }

  load(){
    forkJoin({
      folders:this.folderService.getFolders(),
      files:this.fileService.getFiles()
    }).subscribe({
      next: (res)=>{
        console.log('folders',res.folders);
        console.log('files',res.files);
        this.folders=res.folders;
        this.files=res.files;
      }
    });
  }

  //poner la busqueda y las etiquetas
}
