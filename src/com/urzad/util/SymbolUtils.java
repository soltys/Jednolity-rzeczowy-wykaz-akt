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
		
		switch (data.length) {
		case 9:
			symbolInfo.comments = data[8];
		case 8:
			symbolInfo.ka_ki = data[7];
		case 7:
			symbolInfo.ka_km = data[6];
		case 6:
			symbolInfo.name = data[5];
		default:			
		}
			
		
		return symbolInfo;
	}
	
	public static boolean isChild(SymbolInfo parent, SymbolInfo child)
	{
		boolean isChildren = false;
		int parentDeepth = computeDeepth(parent);
		int childrenDeepth = computeDeepth(child);
		
		if(parentDeepth + 1 == childrenDeepth && isSameToDeepth(parent,child,parentDeepth))
			isChildren = true;
		
		return isChildren;
	}
	private static boolean isSameToDeepth(SymbolInfo parent,
			SymbolInfo children, int deepth) {
		boolean isSame = false;
		for(int i = 0; i < deepth ; ++i)
		{
			if(parent.columns[i].equals(children.columns[i]))
				isSame = true;
			else
				isSame = false;
		}
		return isSame;
	}
	public static int computeDeepth(SymbolInfo symbolInfo)
	{
		int count = 0;
		for(String i: symbolInfo.columns)
		{			
			if(i != "" && !i.isEmpty())
				++count;
		}
		return count;
	}
}
