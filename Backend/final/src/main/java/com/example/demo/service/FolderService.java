package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.FolderModel;
import com.example.demo.repository.FolderRepository;

@Service
public class FolderService {

    private final FolderRepository folderRepository;

    FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public FolderModel save(FolderModel folder){

        return folderRepository.save(folder);
    }

    public List<FolderModel> findAll(){
        return folderRepository.findAll();
    }

    public FolderModel findById(Long id){
        return folderRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Folder not found"));// exepcion
    }

    public FolderModel findByName(String foldername){
        return folderRepository.findByFoldername(foldername)
                .orElseThrow(()-> new NotFoundException("Folder not found"));// exepcion
    }

    
    
}
