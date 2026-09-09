package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.FileModel;
import com.example.demo.model.FolderModel;
import com.example.demo.model.TagModel;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.FolderRepository;

@Service
public class FileService {
    
    private final FileRepository fileRepository;
    private final FolderRepository folderRepository;

    FileService(FileRepository fileRepository, FolderRepository folderRepository) {
        this.fileRepository = fileRepository;
        this.folderRepository = folderRepository;
    }

    public FileModel save(FileModel file){

        Long folderId=file.getFolder().getId();

        FolderModel folder=folderRepository.findById(folderId)
                    .orElseThrow(()-> new NotFoundException("Folder not found"));// exepcion

        file.setFolder(folder);
        
        return fileRepository.save(file);               
    }

    public List<FileModel> findAll(){
        return fileRepository.findAll();
    }

    public FileModel findById(Long id){
        return fileRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("File not found"));// exepcion;
    }

    public FileModel findByName(String filename){
        return fileRepository.findByFilename(filename)
                .orElseThrow(()-> new NotFoundException("File not found"));// exepcion
    }

    public List<String> findByTag(List<String> etiqueta){
        return fileRepository.findByTag(etiqueta)
               .orElseThrow(()-> new NotFoundException("No files with this tag"));// tags tuto
    }

    //OK
   /*  public List<FileModel> findByTag(List<String> etiqueta){
        return fileRepository.findByTag(etiqueta)
               .orElseThrow(()-> new NotFoundException("No files with this tag"));// tags tuto
    } */


   /*  public FileModel findByTag(List<TagModel> etiqueta){
        return fileRepository.findByTag(etiqueta)
               .orElseThrow(()-> new NotFoundException("No files with this tag"));// tags tuto
    } */

  /*   public FileModel findByTag(TagModel etiqueta){
        return fileRepository.findByTag(etiqueta)
               .orElseThrow(()-> new NotFoundException("No files with this tag"));// tags tuto
    } */

    


}
