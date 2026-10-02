package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.FileModel;
import java.util.List;
//import com.example.demo.model.TagModel;


public interface FileRepository extends JpaRepository<FileModel,Long> {
  Optional<FileModel> findByFilename(String filename);
        
  @Query("SELECT f from FileModel f JOIN f.tag t WHERE t=LOWER(:etiqueta)")
  Optional<List<FileModel>> findByTag(@Param("etiqueta") String etiqueta); 

  @Query("SELECT f from FileModel f JOIN f.tag t WHERE t=LOWER(:etiqueta1) AND t=LOWER(:etiqueta2)")
  Optional<List<FileModel>> findByTagsAnd(@Param("etiqueta1") String etiqueta1,@Param("etiqueta2") String etiqueta2);

  @Query("SELECT f from FileModel f JOIN f.tag t WHERE t=LOWER(:etiqueta1) OR t=LOWER(:etiqueta2)")
  Optional<List<FileModel>> findByTagsOr(@Param("etiqueta1") String etiqueta1,@Param("etiqueta2") String etiqueta2);
  //TODO otro query con AND y OR

  //TODO el archivo no existe, tiene nombre pero no contenido

}
