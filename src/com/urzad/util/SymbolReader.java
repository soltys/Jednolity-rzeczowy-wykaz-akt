package com.urzad.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class SymbolReader {
	private String filename;
	FileReader fr = null;
	BufferedReader br = null;

	public  SymbolReader(String filename) throws FileNotFoundException {
		this.filename = filename;
		
		fr = new FileReader(filename);
		br = new BufferedReader(fr);
	}	

	protected void finalize() throws Throwable
	{	 
	  br.close();
	  fr.close();
	} 
	public List<SymbolInfo> getTopLevel() throws IOException,FileNotFoundException
	{
		String line = "";
		List<SymbolInfo> topLevelList = new ArrayList<SymbolInfo>();
		FileReader fr = null;
		BufferedReader br = null;
	
		fr = new FileReader(filename);
		br = new BufferedReader(fr);
		while((line = br.readLine()) != null)
		{
			SymbolInfo topLevel = SymbolUtils.parseLineToSymbolInfo(line);						
			if(topLevel.columns[1].isEmpty())
			{
				topLevelList.add(topLevel);
			}
		}	
		return topLevelList;
	}
	public List<SymbolInfo> findChildrens(SymbolInfo parrent) throws IOException,FileNotFoundException
	{	
		String line = "";
		List<SymbolInfo> childrenList = new ArrayList<SymbolInfo>();
		
		while((line = br.readLine()) != null)
		{
			SymbolInfo children = SymbolUtils.parseLineToSymbolInfo(line);
			boolean isChild = SymbolUtils.isChild(parrent, children);
			
			if(isChild)
			{
				childrenList.add(children);				
			}
			
		}	
	
		return childrenList;
		
	}
	
	public List<SymbolInfo> findSimilar(String searchLine)  throws IOException,FileNotFoundException
	{
		String line = "";
		List<SymbolInfo> results = new ArrayList<SymbolInfo>();
	
		while((line = br.readLine()) != null)
		{		
			if(line.toUpperCase().contains(searchLine.toUpperCase()))
			{
				SymbolInfo itemSimilar = SymbolUtils.parseLineToSymbolInfo(line);
				results.add(itemSimilar);
			}			
		}		
	
		return results;
	
	}
}
