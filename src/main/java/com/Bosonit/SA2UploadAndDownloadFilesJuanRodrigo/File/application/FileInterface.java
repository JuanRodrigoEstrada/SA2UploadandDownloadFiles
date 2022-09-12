package com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.application;

import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.infraestructure.DTO.FileInputDTO.FileInputDTO;
import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.infraestructure.DTO.FileOutputDTO.FileOutputDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface FileInterface {

ResponseEntity<?>getFilebyId(int id , String path )throws IOException;
FileOutputDTO postFile(String type , FileInputDTO fileInputDTO)throws IOException;

}
