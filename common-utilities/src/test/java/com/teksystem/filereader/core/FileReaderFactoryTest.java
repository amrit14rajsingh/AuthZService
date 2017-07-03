package com.teksystem.filereader.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.teksystem.*")
public class FileReaderFactoryTest {

	FileReaderFactory fileReaderFactory = null;
	
	@Before
	public void setUp(){
		fileReaderFactory = FileReaderFactory.getInstance();
	}
	@Test
	public void testGetInstance() {
		assertTrue(fileReaderFactory instanceof FileReaderFactory);
   }

	@Test
	public void testGetFileReaderFor() {
		assertTrue( fileReaderFactory.getFileReaderFor(".doc")  instanceof DocFileReader);
	}

}
