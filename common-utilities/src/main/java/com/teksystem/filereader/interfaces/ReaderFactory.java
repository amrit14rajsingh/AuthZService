package com.teksystem.filereader.interfaces;

public interface ReaderFactory {
	public FileReader getFileReaderFor(String fileType);
}
