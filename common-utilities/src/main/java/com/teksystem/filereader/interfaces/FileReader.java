package com.teksystem.filereader.interfaces;

import java.io.FileInputStream;

public interface FileReader {
  public void readFileContent(FileInputStream fis) throws Exception;
  public void read(String fileName) throws Exception;
}
