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

/*     @Query("SELECT e from FileModel e"+
           "WHERE :etiqueta =ANY (e.tag)" ) */

           /*    @Query("SELECT f from FileModel f WHERE (:etiqueta) MEMBER OF f.tag") */
              //@Query("Select f from FileModel f where (f.tag) LIKE %:etiqueta%")
              //@Query("SELECT f from FileModel f WHERE LOWER(:etiqueta)=ANY (select fe.tag from FileModel fe)")
             // Optional<List<FileModel>> findByTag(@Param("etiqueta") List<String> tag); 
        
  @Query("SELECT f from FileModel f JOIN f.tag t WHERE t=LOWER(:etiqueta)")
  Optional<List<FileModel>> findByTag(@Param("etiqueta") List<String> etiqueta); 
             
  @Query("SELECT f from FileModel f JOIN f.tag t WHERE t=LOWER(:etiqueta1) AND t=LOWER(:etiqueta2)")
  Optional<List<FileModel>> findByTagsAnd(@Param("etiqueta1") String etiqueta1, String etiqueta2);

  @Query("SELECT f from FileModel f JOIN f.tag t WHERE t=LOWER(:etiqueta1) OR t=LOWER(:etiqueta2)")
  Optional<List<FileModel>> findByTagsOr(@Param("etiqueta1") String etiqueta1, String etiqueta2);
  //TODO otro query con AND y OR

     //Optional<List<FileModel>> findByTagIn(List<String> tag); 
   // Optional<List<FileModel>> findByTagLike(List<String> tag);
    
     //Este funciona maso
     /* Optional<List<FileModel>> findByTagIn(List<String> tag); */ 
    
    
     //Optional<List<String>> findByTag(@Param("etiqueta") List<String> tag); 


     // el archivo no existe, tiene nombre pero no contenido

     /* @Query("SELECT * from file e WHERE :etiqueta =ANY (e.tag)" )
     Optional<List<FileModel>> findByTag(@Param("etiqueta") List<String> tag);  */
     //devuelve varios archivos entonces list??

}
