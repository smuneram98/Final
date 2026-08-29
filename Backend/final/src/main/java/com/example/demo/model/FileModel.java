package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="file")
public class FileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private List<TagModel> tag;

    @ManyToOne(optional = false)
    @JoinColumn(name = "folder_id",nullable = false)
    private FolderModel folder;

    public FileModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<TagModel> getTag() {
        return tag;
    }

    public void setTag(List<TagModel> tag) {
        this.tag = tag;
    }

    public FolderModel getFolder() {
        return folder;
    }

    public void setFolder(FolderModel folder) {
        this.folder = folder;
    }

    


    
}
