package com.urzad.util;

import java.util.List;

public class SymbolInfo {
	public String[] columns = new String [5];
	public String name;
	public String ka_km;
	public String ka_ki;
	public String comments;
	
	final static public int NUMBER_OF_COLUMNS = 5;
	
	public SymbolInfo(){
		for (int i = 0; i < columns.length; i++) {
			columns[i] = "";
		}
		name = "";    
		ka_km = "";   
		ka_ki = "";   
		comments = "";
	}	

	public String toJSON()
	{
		String strJSON = "{";
		
		strJSON = strJSON + String.format("\"%s\" : \"%s\",", "name",name);
		strJSON = strJSON + String.format("\"%s\" : \"%s\",", "ka_km",ka_km);
		strJSON = strJSON + String.format("\"%s\" : \"%s\",", "ka_ki",ka_ki);
		strJSON = strJSON + String.format("\"%s\" : \"%s\",", "comments",comments);
		strJSON = strJSON +  columnsToJSON();
		strJSON = strJSON + "}";
		return strJSON;
	}
	
	private String columnsToJSON()
	{
		String output = "\"columns\": [";
		for(String str: columns)
		{
			output = output + String.format("{\"%s\": \"%s\"},","val",str);					
		}
	
		output = removeLastCharacter(output);
		output = output + "]";
		return output;
	}

	private static String removeLastCharacter(String output) {
		output = output.substring(0, output.length() - 1 );
		return output;
	}
	
	public static String toJSONSymbolInfoList(List<SymbolInfo> symbolInfoList)
	{
		String output = "{ \"list\" : [";
		for(SymbolInfo si: symbolInfoList)
		{
			output = output + si.toJSON() + ",";
		}
		output = removeLastCharacter(output);
		output = output + "]}";
		return output;
	
	}
	public String toString()
	{
		String output = "";
		for(String str : columns)
		{
			output = output + str;
		}
		
		output = output + name + ka_km + ka_ki + comments;
		return output;
	}
	private String getLastNotEmptyColumn()
	{
		String output = "";
		for(String str : columns)
		{
			if(!str.isEmpty())
				output = str;
		}
		return output;
	}	

	public boolean isSymbolParent(SymbolInfo parent)
	{
		boolean isParent = true;
		int index = parent.getLastNotEmptyColumn().length();
		for(int i=0 ;i< index ;i++)
		{		
			if(!columns[i].equalsIgnoreCase(parent.columns[i]))
				isParent = false;			
		}
		return isParent;
	}
}
