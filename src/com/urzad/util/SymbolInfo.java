package com.urzad.util;
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
}
