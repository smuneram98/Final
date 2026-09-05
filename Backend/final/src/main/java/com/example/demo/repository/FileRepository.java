package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.FileModel;
import java.util.List;
import com.example.demo.model.TagModel;


public interface FileRepository extends JpaRepository<FileModel,Long> {
    Optional<FileModel> findByFilename(String filename);
  
    //TODO el archivo no existe, tiene nombre pero no contenido
    //Revisar query
    /* @Query("SELECT e.filename FROM file e"+
            "WHERE e.tag = :etiqueta" ) */
            
    //Optional<FileModel> findByTag(@Param("etiqueta") List<TagModel> tag); 
    Optional<FileModel> findByTag( List<TagModel> tag); 
    // Optional<FileModel> findByTag(@Param("etiqueta") TagModel tag); 
     //TODO devuelve varios archivos entonces list??

}
