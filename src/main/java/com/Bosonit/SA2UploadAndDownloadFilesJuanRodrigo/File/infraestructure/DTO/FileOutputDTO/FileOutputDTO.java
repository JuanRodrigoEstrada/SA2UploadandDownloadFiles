package com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.infraestructure.DTO.FileOutputDTO;

import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.application.FileEntity;
import lombok.Data;


import java.util.Date;

@Data

public class FileOutputDTO {

    Integer id;
    String type;
    String name;
    Date upload_date;

    public FileOutputDTO(FileEntity fileEntity) {
        this.id = fileEntity.getId();
        this.type = fileEntity.getType();
        this.name = fileEntity.getName();
        this.upload_date = fileEntity.getUpload_date();
    }



}
