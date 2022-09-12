package com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.FileRepository;

import com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo.File.application.FileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends CrudRepository<FileEntity,Integer> {
    static FileEntity findbyId(int id) {
        return null;
    }
}
