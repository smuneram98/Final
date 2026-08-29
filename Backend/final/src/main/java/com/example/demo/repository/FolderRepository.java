package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.demo.model.FolderModel;

public interface FolderRepository extends JpaRepository<FolderModel,Long> {
    Optional<FolderModel> findByName(String name);
    boolean existByName(String name);
}
