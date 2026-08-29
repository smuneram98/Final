package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.FileModel;
import com.example.demo.model.FolderModel;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.FolderRepository;

@Service
public class FileService {
    
    private FileRepository fileRepository;
    private FolderRepository folderRepository;

    public FileModel save(FileModel file){

        Long folderId=file.getFolder().getId();

        FolderModel folder=folderRepository.findById(folderId)
                    .orElseThrow(null);//TO DO exepcion

        file.setFolder(folder);

        return fileRepository.save(file);               
    }

    public List<FileModel> findAll(){
        return fileRepository.findAll();
    }

    public FileModel findById(Long id){
        return fileRepository.findById(id)
                .orElseThrow(null);//TO DO exepcion;
    }

    


}
