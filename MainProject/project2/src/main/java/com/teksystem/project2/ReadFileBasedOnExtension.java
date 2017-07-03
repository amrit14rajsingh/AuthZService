package com.teksystem.project2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.teksystem.filereader.core.FileReaderFactory;
import com.teksystem.filereader.interfaces.FileReader;
import com.teksystem.filereader.interfaces.ReaderFactory;
import com.teksystem.filereaderutilities.FileReaderUtilities;

//- Document: WordFile1 - Extension: .doc - URL: MainProject/project1/WordFile1.doc
// - Document: WordFile1 - Extension:  .doc - URL: /MainProject/src/main/resources/WordFile1.doc
public class ReadFileBasedOnExtension {
	
		public Map<String,String> getFileName(String[] args){
		StringBuffer sb = new StringBuffer();
		Map<String,String> argMap = new HashMap<String,String>();
		for(String st:args){
			sb.append(st.trim());
		}
		List<String> inputString = Arrays.asList(sb.toString().split("-"));
		for(String str:inputString){
			if(!str.isEmpty()){
				String[] tempString = str.split(":");
				if(tempString.length>1){
					argMap.put(tempString[0], tempString[1]);
				}
				
			}
		}
		return argMap;
	}
		
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Throwable{
		FileReaderUtilities fileReaderUtilities = new FileReaderUtilities();
		String fileName = null;
		try{
			ReadFileBasedOnExtension wdr = new ReadFileBasedOnExtension();
			Map<String,String> argMap = wdr.getFileName(args);
			fileName = argMap.get("Document")+argMap.get("Extension");
			if(null == fileName){
				throw new NullPointerException();
			}
			ReaderFactory fileReaderFactory = FileReaderFactory.getInstance();
			FileReader fileReader = fileReaderFactory.getFileReaderFor(argMap.get("Extension"));
			fileReader.read(fileName);
			
		}catch(Exception e){
			fileReaderUtilities.handleFileReadingException(e, fileName);
		}
		
	}

}
