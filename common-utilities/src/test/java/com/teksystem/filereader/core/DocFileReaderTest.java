package com.teksystem.filereader.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class DocFileReaderTest {

	DocFileReader docFileReader = null;
	
	@Before
	public void setUp(){
		docFileReader = new DocFileReader();
	}
	
	@Test
	public void testReadFileContent() {
		boolean exceptionThrown = false;
		String fileName = "WordFile1.doc";
		try{
			docFileReader.read(fileName);
		}catch(Exception e){
			exceptionThrown = true;
		}
		assertFalse(exceptionThrown);
	}

	@Test
	public void testRead() {
		boolean exceptionThrown = false;
		String fileName = "WordFile1.doc";
		try{
			docFileReader.read(fileName);
		}catch(Exception e){
			exceptionThrown = true;
		}
		assertFalse(exceptionThrown);
	}

}
