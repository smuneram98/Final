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
  
    //Revisar query
    /* @Query("SELECT e.filename FROM file e"+
            "WHERE e.tag = :etiqueta" ) */
/*     @Query("SELECT e.filename from file e"+
           "WHERE :etiqueta =ANY (e.tag)" ) */
     @Query("SELECT file.filename from file WHERE 'PHOTO' =ANY (file.tag)")
     Optional<List<String>> findByTag( List<String> tag); 
     //Optional<List<String>> findByTag(@Param("etiqueta") List<String> tag); 


     // el archivo no existe, tiene nombre pero no contenido

     /* @Query("SELECT * from file e WHERE :etiqueta =ANY (e.tag)" )
     Optional<List<FileModel>> findByTag(@Param("etiqueta") List<String> tag);  */
     //devuelve varios archivos entonces list??

}
