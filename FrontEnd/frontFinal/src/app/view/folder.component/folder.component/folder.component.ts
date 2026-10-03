import { Component, OnInit } from '@angular/core';
import { FolderService } from '../../../services/folder.service/folder.service';
import { FolderModel } from '../../../models/folder.model';

@Component({
  selector: 'app-folder.component',
  imports: [],
  templateUrl: './folder.component.html',
  styleUrl: './folder.component.css',
})
export class FolderComponent implements OnInit{

  folders:FolderModel[]=[];
  newFolder:FolderModel=new FolderModel();

  constructor(private folderService:FolderService){}

  ngOnInit(): void {
    this.loadFolders();
  }

  loadFolders(){
    this.folderService.getFolders().subscribe(data=>{
      this.folders=data;
    });
  }

  saveFolder(){
    this.folderService.createFolder(this.newFolder).subscribe(data=>{
      this.loadFolders();
      this.newFolder= new FolderModel();
    })
  }



}
