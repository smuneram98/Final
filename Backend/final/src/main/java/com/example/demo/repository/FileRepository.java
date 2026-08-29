package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FileModel;

public interface FileRepository extends JpaRepository<FileModel,Long> {
    Optional<FileModel> findByName(String name);
    boolean existByName(String name);
}
