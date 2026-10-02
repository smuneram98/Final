import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FolderModel } from '../../models/folder.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FolderService {
  private apiURL="http://localhost:8080/api/folder";

  constructor(private http:HttpClient){}

  getFolders(): Observable<FolderModel[]>{
    return this.http.get<FolderModel[]>(this.apiURL);
  }

  createFolder(folder:FolderModel): Observable<FolderModel>{
    return this.http.post<FolderModel>(this.apiURL,folder);
  } 

  getFolderByName(name:String): Observable<FolderModel>{
    return this.http.get<FolderModel>(`${this.apiURL}/${name}`);
  }
  

}
