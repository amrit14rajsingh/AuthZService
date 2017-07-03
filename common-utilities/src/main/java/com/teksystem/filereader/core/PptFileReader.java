package com.teksystem.filereader.core;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFTextParagraph;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class PptFileReader extends AbstractFileReader{
	public void readFileContent(FileInputStream fis) throws Exception{
		POIFSFileSystem poifs = new POIFSFileSystem(fis);
		HSLFSlideShow show = new HSLFSlideShow(poifs);
		List<HSLFSlide> slideShow = show.getSlides();
		for(HSLFSlide slide:slideShow){
			System.out.println("Slide = "+slide._getSheetNumber()+":"+slide.getTitle());
			List<List<HSLFTextParagraph>> slideParagraphs= slide.getTextParagraphs();
			for(List<HSLFTextParagraph> paragraph:slideParagraphs){
				for(HSLFTextParagraph paragraphTexts:paragraph){
					System.out.println(paragraphTexts);
				}
			}
		}
	 }
}
