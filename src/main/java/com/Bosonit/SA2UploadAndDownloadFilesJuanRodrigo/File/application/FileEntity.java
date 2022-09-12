package com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.application;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private String type;

    @Lob
    private byte[] data;

    @Column (unique = true)
    String name;

    Date upload_date;


    public FileEntity(String fileName, byte[] data, String fileType) {
        this.name = fileName;
        this.data = data;
        this.type = fileType;
    }
}
