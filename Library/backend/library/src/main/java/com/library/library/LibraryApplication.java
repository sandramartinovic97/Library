package com.library.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {

		String url = 'jdbc:mysql://localhost:3306/?user=root';
		String user = 'root';
		String password = '0637263646'
		Connection myConnection = DriveManager.getConnection(url,user,password);
		SpringApplication.run(LibraryApplication.class, args);
	}

}
