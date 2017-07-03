package com.teksystem.filereader.core;

import com.teksystem.filereader.interfaces.FileReader;
import com.teksystem.filereader.interfaces.ReaderFactory;
import com.teksystem.filereaderutilities.FileReadersContants;

public class FileReaderFactory implements ReaderFactory{

	private static FileReaderFactory fileReaderFactory = null;
	FileReader fileReader = null;
	
	private FileReaderFactory(){}

	public static FileReaderFactory getInstance(){
		if(null == fileReaderFactory){
			fileReaderFactory = new FileReaderFactory();
		}
		return fileReaderFactory;
	}
	

	public FileReader getFileReaderFor(String fileType){
		switch (fileType) {
		case FileReadersContants.DOCEXTENSION:
			fileReader = new DocFileReader();
			break;
		case FileReadersContants.PPTEXTENSION:
			fileReader = new PptFileReader();
			break;
		case FileReadersContants.XLSEXTENSION:
			fileReader = new XlsFileReader();
			break;
		}

		return fileReader;
	}
}
