package com.urzad.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.urzad.util.SymbolInfo;
import com.urzad.util.SymbolReader;

import junit.framework.Assert;

public class SymbolReaderTest {
	@Test public void getTopLevelTest() throws FileNotFoundException, IOException
	{
		SymbolReader sr = new SymbolReader("symbol.csv");
		List<SymbolInfo> topLevelList = sr.getTopLevel();
		Assert.assertEquals(10, topLevelList.toArray().length);
		
	}
}
