package com.urzad.util;
public class SymbolParser {
	public static SymbolInfo parseLineToSymbolInfo(String line){		
		String[] data = line.split(";");
		SymbolInfo symbolInfo = new SymbolInfo();
		
		symbolInfo.columns[0] = data[0];
		symbolInfo.columns[1] = data[1];
		symbolInfo.columns[2] = data[2];
		symbolInfo.columns[3] = data[3];
		symbolInfo.columns[4] = data[4];	
		
		symbolInfo.name = data[5];
		symbolInfo.ka_km = data[6];
		symbolInfo.ka_ki = data[7];
		symbolInfo.comments = data[8];
		
		return symbolInfo;
	}
}
