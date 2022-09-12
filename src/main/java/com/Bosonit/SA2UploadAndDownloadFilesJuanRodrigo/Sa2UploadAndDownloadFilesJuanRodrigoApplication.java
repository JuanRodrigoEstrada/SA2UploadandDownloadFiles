package com.Bosonit.SA2UploadAndDownloadFilesJuanRodrigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sa2UploadAndDownloadFilesJuanRodrigoApplication {

	public static String fileRoute = "";

	public static void main(String[] args) {

		if(args.length > 0){
			fileRoute = args[0];


		}
		SpringApplication.run(Sa2UploadAndDownloadFilesJuanRodrigoApplication.class, args);


	}

}
