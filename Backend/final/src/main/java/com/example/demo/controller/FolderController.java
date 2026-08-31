package com.example.demo.controller;

import com.example.demo.service.FolderService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FolderModel;

@RestController
@RequestMapping("/api/folder")
public class FolderController {

    private final FolderService folderService;

    FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @PostMapping
    public FolderModel create(@RequestBody FolderModel folder){
        return folderService.save(folder);
    }

    @GetMapping
    public List<FolderModel> findAll(){
        return folderService.findAll();
    }

    @GetMapping("/{id}")
    public FolderModel findById(@PathVariable Long id){
        return folderService.findById(id);
    }

     //TODO multiples tipos de dato en un mismo endpoint investiguen
   /*  @GetMapping("/{name}")
    public FolderModel findByName(@PathVariable String name){
        return folderService.findByName(name);
    } */

    
}
