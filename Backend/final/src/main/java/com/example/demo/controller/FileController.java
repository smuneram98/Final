package com.example.demo.controller;

import com.example.demo.service.FileService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.FileModel;
//import com.example.demo.model.TagModel;

@RestController
@RequestMapping("/api/file")
public class FileController {
    
//TODO la etiquta da problemas mirar
    private final FileService fileService;

    FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public FileModel create(@RequestBody FileModel file){
        return fileService.save(file);
    }

    @GetMapping
    public List<FileModel> findAll(){
        return fileService.findAll();
    }

   /*  @GetMapping("/{id}")
    public FileModel findById(@PathVariable Long id){
        return fileService.findById(id);
    } */

    //TODO multiples tipos de dato en un mismo endpoint investiguen
    @GetMapping("/{name}")
    public FileModel findByName(@PathVariable String name){
        return fileService.findByName(name);
    }
    
 /*    @GetMapping("/buscar/{etiqueta}")
    public List<FileModel> findByTag(@PathVariable String etiqueta){
        return fileService.findByTag(etiqueta);
    } */
    @GetMapping("/buscar/{etiqueta}")
    public List<FileModel> findByTag(@PathVariable List<String> etiqueta){
        return fileService.findByTag(etiqueta);
    }

    
    /* @GetMapping("/buscar/{tag}")
    public List<FileModel> findByTag(@PathVariable List<String> etiqueta){
        return fileService.findByTag(etiqueta);
    }
 */
}
