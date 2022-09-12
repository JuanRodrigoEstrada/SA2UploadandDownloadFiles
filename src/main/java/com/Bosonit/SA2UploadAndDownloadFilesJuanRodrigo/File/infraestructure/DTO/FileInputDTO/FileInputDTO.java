package com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.infraestructure.DTO.FileInputDTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class FileInputDTO {
    MultipartFile file;
    String name;
}
