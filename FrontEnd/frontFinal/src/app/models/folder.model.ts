import { FileModel } from "./file.model";

export class FolderModel {
    id?:number;
    foldername!:string;
    files!:FileModel[];
    folders!:FolderModel[];
}
