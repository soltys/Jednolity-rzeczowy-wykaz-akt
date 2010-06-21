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
		int i = 0;
		for(String str: columns)
		{
			output = output + String.format("{\"%s\": \"%s\"},",Integer.toString(i),str);
			i++;			
		}
		output = output.substring(0, output.length() - 1 );
		output = output + "]";
		return output;
	}
	
	public static String toJSONSymbolInfoList(List<SymbolInfo> symbolInfoList)
	{
		String output = "{ \"list\" : [";
		for(SymbolInfo si: symbolInfoList)
		{
			output = output + si.toJSON() + ",";
		}
		output = output.substring(0, output.length() - 1 );
		output = output + "]}";
		return output;
	
	}
}
