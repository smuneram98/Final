package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.FileModel;
import com.example.demo.model.FolderModel;
import com.example.demo.model.TagModel;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.FolderRepository;

@Service
public class FileService {
    
    private FileRepository fileRepository;
    private FolderRepository folderRepository;

    public FileModel save(FileModel file){

        Long folderId=file.getFolder().getId();

        FolderModel folder=folderRepository.findById(folderId)
                    .orElseThrow(null);//TODO exepcion

        file.setFolder(folder);
        file.getFilename();
        return fileRepository.save(file);               
    }

    public List<FileModel> findAll(){
        return fileRepository.findAll();
    }

    public FileModel findById(Long id){
        return fileRepository.findById(id)
                .orElseThrow(null);//TODO exepcion;
    }

    public FileModel findByName(String filename){
        return fileRepository.findByName(filename)
                .orElseThrow(null);//TODO exepcion
    }

    public FileModel findByTag(List<TagModel> etiqueta){
        return fileRepository.findByTag(etiqueta)
               .orElseThrow(null);//TODO tags tuto
    }

    


}
