package com.urzad.util;
public class SymbolUtils {
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
	public static boolean isChildren(SymbolInfo parrent, SymbolInfo children)
	{
		boolean isChildren = false;
		int parrentDeepth = computeDeepth(parrent);
		int childrenDeepth = computeDeepth(children);
		
		if(parrentDeepth - 1 == childrenDeepth && isSameToDeepth(parrent,children,parrentDeepth))
			isChildren = true;
		
		return isChildren;
	}
	private static boolean isSameToDeepth(SymbolInfo parrent,
			SymbolInfo children, int deepth) {
		boolean isSame = false;
		for(int i = 0; i < deepth ; ++i)
		{
			if(parrent.columns[i] == children.columns[i])
				isSame = true;
			else
				isSame = false;
		}
		return isSame;
	}
	public static int computeDeepth(SymbolInfo parrent)
	{
		int i = 0;
		do{
			if(parrent.columns[i] == "")
				break;
			++i;
		}while(i < SymbolInfo.NUMBER_OF_COLUMNS);
		return --i;
	}
}
