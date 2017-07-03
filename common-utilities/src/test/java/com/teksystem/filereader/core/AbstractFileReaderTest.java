package com.teksystem.filereader.core;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.teksystem.filereaderutilities.FileReaderUtilities;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.teksystem.*")
public class AbstractFileReaderTest {
	
	@Mock
	AbstractFileReader abstractFileReader;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRead() {
		boolean exceptionThrown = false;
		AbstractFileReader spy = PowerMockito.spy(abstractFileReader);
		String fileName = "WordFile1.doc";
		try{
			doNothing().when(spy).read(fileName);;
			abstractFileReader.read(fileName);
		}catch(Exception e){
			exceptionThrown = true;
		}
		assertFalse(exceptionThrown);
	}
	
	@Test
	public void testReadForException() {
		boolean exceptionThrown = false;
		abstractFileReader = PowerMockito.mock(AbstractFileReader.class);
		String fileName = "WordFile1.doc";
		Throwable ex = new FileNotFoundException();
		//PowerMockito.when(fileReaderUtilitiesMock.handleFileReadingException(ex, fileName)).thenThrow(new Exception());  //.doThrow(new Exception());
		try{
			doThrow(new Exception()).when(abstractFileReader).read(fileName);;
			abstractFileReader.read(fileName);
		}catch(Exception e){
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}
}
