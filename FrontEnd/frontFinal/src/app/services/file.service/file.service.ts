import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {FileModel} from '../../models/file.model'

@Injectable({
  providedIn: 'root',
})
export class FileService {
  private apiURL="http://localhost:8080/api/file";

  constructor(private http:HttpClient){}

  getFiles():Observable<FileModel[]>{
    return this.http.get<FileModel[]>(this.apiURL);
  }

  createFile(file:FileModel):Observable<FileModel>{
    return this.http.post<FileModel>(this.apiURL,file);
  }

  getFileByName(name:String):Observable<FileModel>{
    return this.http.get<FileModel>(`${this.apiURL}/${name}`);
  }

  getFileByTag(tag:String):Observable<FileModel>{
    return this.http.get<FileModel>(`${this.apiURL}/buscar?etiqueta=${tag}`);
  }

  getFilesOr(tag1:String,tag2:String):Observable<FileModel[]>{
    return this.http.get<FileModel[]>(`${this.apiURL}/buscaror?etiqueta1=${tag1}&etiqueta2=${tag2}`);
  }

  getFilesAnd(tag1:String,tag2:String):Observable<FileModel[]>{
    return this.http.get<FileModel[]>(`${this.apiURL}/buscarand?etiqueta1=${tag1}&etiqueta2=${tag2}`);
  }

}
