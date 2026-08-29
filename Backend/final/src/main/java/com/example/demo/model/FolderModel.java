package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="folder")
public class FolderModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String foldername;

    @OneToMany
    private List<FileModel> files;

    @OneToMany
    private List<FolderModel> folders;

    public FolderModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }

    public List<FileModel> getFiles() {
        return files;
    }

    public void setFiles(List<FileModel> files) {
        this.files = files;
    }

    public List<FolderModel> getFolders() {
        return folders;
    }

    public void setFolders(List<FolderModel> folders) {
        this.folders = folders;
    }

    
}
