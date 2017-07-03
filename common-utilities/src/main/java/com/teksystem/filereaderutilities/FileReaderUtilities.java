package com.teksystem.filereaderutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

/*
 * An utility file that perform all common functionality related with file read operations like
 * (1). Discovering location of file in project and handling of space in URI name.
 * (2). Common exception handling mechanism.
 * 
 */

public class FileReaderUtilities {

	public FileInputStream getFileInputStream(String fileName) 
			throws Exception{
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(fileName);
		if(null==url){
			throw new FileNotFoundException();
		}
		File file = new File(url.getFile());
		FileInputStream fis = new FileInputStream(file.getPath().replaceAll("%20", " "));
		return fis;
	}
	
	
	
	public void handleFileReadingException(Throwable throwable, String fileName) throws Exception{
		if(throwable instanceof FileNotFoundException){
			FileNotFoundException fnfe = (FileNotFoundException)throwable;
			System.out.println("File with name " +fileName+ "does not exist");
		}else if(throwable instanceof NullPointerException){
			NullPointerException npe = (NullPointerException)throwable;
			System.out.println("There is some issue in reading " +fileName+ ", please check stacj trace");
			npe.printStackTrace();
		}else if(throwable instanceof Exception){
			Exception e = (Exception)throwable;
			System.out.println("There is some issue in reading" +fileName+ ", please check stacj trace");
			e.printStackTrace();
		}
	}
}
