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

    /*  @Query("SELECT f from FileModel f WHERE f.filename = :nombre")
     Optional<FileModel> findByFilena(@Param("nombre") String filename); */
    //Revisar query
    /* @Query("SELECT e.filename FROM file e"+
            "WHERE e.tag = :etiqueta" ) */
/*     @Query("SELECT e.filename from file e"+
           "WHERE :etiqueta =ANY (e.tag)" ) */
   //  @Query("SELECT f from FileModel f WHERE LOWER(:etiqueta)=ANY (f.tag)")
     Optional<List<FileModel>> findByTag(@Param("etiqueta") List<String> tag); 

     //Optional<List<String>> findByTagIn(List<String> tag); 
   // Optional<List<FileModel>> findByTagLike(List<String> tag);
    
     //Este funciona maso
     /* Optional<List<FileModel>> findByTagIn(List<String> tag); */ 
    
    
     //Optional<List<String>> findByTag(@Param("etiqueta") List<String> tag); 


     // el archivo no existe, tiene nombre pero no contenido

     /* @Query("SELECT * from file e WHERE :etiqueta =ANY (e.tag)" )
     Optional<List<FileModel>> findByTag(@Param("etiqueta") List<String> tag);  */
     //devuelve varios archivos entonces list??

}
