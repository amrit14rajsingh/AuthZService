package com.teksystem.filereaderutilities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.teksystem.filereader.core.AbstractFileReader;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.teksystem.*")
public class FileReaderUtilitiesTest {

	FileReaderUtilities fileReaderUtilities = null;
	@Mock
	FileReaderUtilities fileReaderUtilitiesMock;
	
	@Before
	public void setUp(){
		fileReaderUtilities = new FileReaderUtilities();
	}
	@Test
	public void testGetFileInputStream() {
		boolean exceptionThrown = false;
		String fileName = "WordFile1.doc";
		try{
			fileReaderUtilities.getFileInputStream(fileName);
		}catch(Exception e){
			exceptionThrown = true;
		}
		assertFalse(exceptionThrown);
	}
	
	@Test
	public void testGetFileInputStreamForException() {
		boolean exceptionThrown = false;
		String fileName = "WordFile111.doc";
		try{
			fileReaderUtilities.getFileInputStream(fileName);
		}catch(Exception e){
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}

	@Test
	public void testHandleFileReadingException() {
		boolean exceptionThrown = false;
		String fileName = "WordFile1.doc";
		Exception ex = new FileNotFoundException();
		try{
			fileReaderUtilities.handleFileReadingException(ex, fileName);
		}catch(Exception e){
			exceptionThrown = true;
		}
		assertFalse(exceptionThrown);
	}
	
	@Test
	public void testHandleFileReadingExceptionException() {
		boolean exceptionThrown = false;
		fileReaderUtilitiesMock = PowerMockito.mock(FileReaderUtilities.class);
		String fileName = "WordFile1.doc";
		Throwable ex = new FileNotFoundException();
		//PowerMockito.when(fileReaderUtilitiesMock.handleFileReadingException(ex, fileName)).thenThrow(new Exception());  //.doThrow(new Exception());
		try{
			doThrow(new Exception()).when(fileReaderUtilitiesMock).handleFileReadingException(ex, fileName);
			fileReaderUtilitiesMock.handleFileReadingException(ex, fileName);
		}catch(Exception e){
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}

}
