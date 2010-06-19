package com.urzad.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class SymbolReader {
	private String filename;
	
	public  SymbolReader(String filename) {
		this.filename = filename;
	}	

	public List<SymbolInfo> getTopLevel() throws IOException,FileNotFoundException
	{
		return null;
	}
	public List<SymbolInfo> findChildrens(SymbolInfo parrent) throws IOException,FileNotFoundException
	{	
		String line = "";
		List<SymbolInfo> childrenList = new ArrayList<SymbolInfo>();
		boolean isThereAnyChild = false;
		FileReader fr = null;
		BufferedReader br = null;
	
		fr = new FileReader(filename);
		br = new BufferedReader(fr);
		while((line = br.readLine()) != null)
		{
			SymbolInfo children = SymbolUtils.parseLineToSymbolInfo(line);
			boolean isChild = SymbolUtils.isChild(parrent, children);
			
			if(isChild)
			{
				childrenList.add(children);
				isThereAnyChild = true;
			}
			if(!isChild && isThereAnyChild)
				break;
			
		}
		br.close();
		fr.close();
	
		return childrenList;
		
	}
}
