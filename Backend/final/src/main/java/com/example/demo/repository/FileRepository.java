package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FileModel;
import java.util.List;
import com.example.demo.model.TagModel;


public interface FileRepository extends JpaRepository<FileModel,Long> {
    Optional<FileModel> findByFilename(String filename);
  //  boolean existByFilename(String filename);
    Optional<FileModel> findByTag(List<TagModel> tag);  
}
