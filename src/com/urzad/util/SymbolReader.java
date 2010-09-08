package com.urzad.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
public class SymbolReader {
	
	BufferedReader br = null;

	public  SymbolReader(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));                
                
	}	

	protected void finalize() throws Throwable
	{
	  br.close();
          super.finalize();
	} 
	public List<SymbolInfo> getTopLevel() throws IOException,FileNotFoundException
	{
		String line = "";
		List<SymbolInfo> topLevelList = new ArrayList<SymbolInfo>();
		
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
	public List<SymbolInfo> getShortTree(SymbolInfo element) throws IOException,FileNotFoundException
	{
		String line = "";
		List<SymbolInfo> results = new ArrayList<SymbolInfo>();
		while((line = br.readLine()) != null)
		{		
			//TODO Find better name for variable
			SymbolInfo foo = SymbolUtils.parseLineToSymbolInfo(line);
			if(element.isSymbolParent(foo))
			{				
				results.add(foo);
			}			
		}		
		return results;
	}
}
