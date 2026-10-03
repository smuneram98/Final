import { FolderModel } from "./folder.model";

export class FileModel {
    id?:number;
    filename!:string;
    tag!:string[];
    folder!:FolderModel;
}
