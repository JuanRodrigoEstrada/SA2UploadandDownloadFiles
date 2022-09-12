package com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.application;

import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.FileRepository.FileRepository;
import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.infraestructure.DTO.FileInputDTO.FileInputDTO;
import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.infraestructure.DTO.FileOutputDTO.FileOutputDTO;
import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.Sa2UploadAndDownloadFilesJuanRodrigoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileService implements FileInterface {

    @Autowired
    FileRepository fileRepository;



    @Override
    public ResponseEntity<?> getFilebyId(int id, String path)throws IOException{
        FileEntity fileEntity = fileRepository.findById(id).orElseThrow(()->new RuntimeException("File with id: " + id + "not exist"));
        File newfile =new File(path + fileEntity.getName());
        System.out.println("File path is : " + newfile.getAbsolutePath());
        newfile.createNewFile();
        FileOutputStream output = new FileOutputStream(newfile);
        output.write(fileEntity.getData());
        output.close();
        return null;
    }

    @Override
    public FileOutputDTO postFile(String type, FileInputDTO fileInputDTO) throws IOException {
        String fileName = fileInputDTO.getName() + "." + type;
        byte [] data= fileInputDTO.getFile().getBytes();
        String fileType = fileInputDTO.getFile().getContentType();
        FileEntity fileEntity = new FileEntity(fileName, data,fileType);
        fileRepository.save(fileEntity);
        return new FileOutputDTO(fileEntity);
    }


}
