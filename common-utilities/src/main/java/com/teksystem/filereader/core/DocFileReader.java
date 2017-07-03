package com.teksystem.filereader.core;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class DocFileReader extends AbstractFileReader{

	public void readFileContent(FileInputStream fis) throws Exception{
		HWPFDocument doc = new HWPFDocument(fis);
		WordExtractor we = new WordExtractor(doc);
		String[] paragraphs = we.getParagraphText();
		System.out.println("Total no of paragraph "+paragraphs.length);
		for (String para : paragraphs) {
			System.out.println(para.toString());
		} 
	 }
}
