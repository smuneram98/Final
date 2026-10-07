import { Component, OnInit } from '@angular/core';
import { FolderModel } from '../../../models/folder.model';
import { FileModel } from '../../../models/file.model';
import { FolderService } from '../../../services/folder.service/folder.service';
import { FileService } from '../../../services/file.service/file.service';
import { forkJoin } from 'rxjs';
import { ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-dashboard.component',
  imports: [CommonModule,FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export class DashboardComponent implements OnInit{
  foldersTodo:FolderModel[]=[];
  filesTodo:FileModel[]=[];
 // todo:any[]=[];
  resultados:any[]=[];
  busqueda:string='';
  categoria:string='';

  constructor(private folderService:FolderService, private fileService:FileService, private cDRef:ChangeDetectorRef){}

  ngOnInit(): void {
    this.load();
  }

  load(){
    forkJoin({
      folders:this.folderService.getFolders(),
      files:this.fileService.getFiles()
    }).subscribe({
      next: (res)=>{
        console.log('folders',res.folders);
        console.log('files',res.files);
        this.foldersTodo=res.folders;
        this.filesTodo=res.files;

        this.cDRef.detectChanges();
      }
    });
  }

  busquedaNameFiles(){
    const bus=this.busqueda.toLowerCase();
    this.resultados=this.filesTodo.filter(item=>
      item.filename.toLowerCase().includes(bus)
    );
  }

  busquedaNameFolders(){
    const bus=this.busqueda.toLowerCase();
    this.resultados=this.foldersTodo.filter(item=>
      item.foldername.toLowerCase().includes(bus)
    );
  }

  busquedaTag(){
    this.resultados=this.filesTodo.filter(item=>
      item.tag.includes(this.categoria)
    );
  }


}
