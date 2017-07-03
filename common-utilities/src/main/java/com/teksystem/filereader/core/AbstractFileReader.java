package com.teksystem.filereader.core;

import java.io.FileInputStream;

import com.teksystem.filereader.interfaces.FileReader;
import com.teksystem.filereaderutilities.FileReaderUtilities;

public abstract class AbstractFileReader implements FileReader{
	
	public void readFileContent(FileInputStream fis) throws Exception{
		//Needs to be implemented for each document type. 
	 }
	public void read(String fileName) throws Exception{
		FileReaderUtilities fileReaderUtilities = null;
		FileInputStream fis = null;
		try{
			fileReaderUtilities = new FileReaderUtilities();
			fis = fileReaderUtilities.getFileInputStream(fileName);
			readFileContent(fis);
		}
		catch(Exception e){
			System.out.println("Exception in read, while reding :: "+fileName);
			throw e;
		}
		finally{
			fis.close();
		}
	}
	
	
}
