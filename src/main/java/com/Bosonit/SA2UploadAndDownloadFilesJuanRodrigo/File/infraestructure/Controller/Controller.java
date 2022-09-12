package com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.infraestructure.Controller;

import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.application.FileService;
import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.infraestructure.DTO.FileInputDTO.FileInputDTO;
import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.Sa2UploadAndDownloadFilesJuanRodrigoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class Controller {

    @Autowired
    FileService fileService;

    private String fileRoute = Sa2UploadAndDownloadFilesJuanRodrigoApplication.fileRoute;

    @GetMapping("/{id}")
    public ResponseEntity<?>getFilebyIdpath(@PathVariable int id, @RequestParam
            (defaultValue = "C:\\Users\\juanrodrigo.estrada\\Desktop\\")String path){
        try {

            if(!fileRoute.equals(""))
                return fileService.getFilebyId(id, fileRoute);
            else return fileService.getFilebyId(id , path);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (IOException i){
            return new ResponseEntity<>(i.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }
    @PostMapping("/upload/{type}")
    public ResponseEntity<?>postFilepath(@PathVariable String type , @ModelAttribute FileInputDTO fileInputDTO){
        try {
            return new ResponseEntity<>(fileService.postFile(type, fileInputDTO), HttpStatus.OK);
        }catch (IOException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

}
