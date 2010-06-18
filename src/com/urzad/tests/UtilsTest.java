package com.urzad.tests;
import org.junit.Assert;
import org.junit.Test;
import com.urzad.util.*;

public class UtilsTest {
	@Test public void ParserLineTest()
	{
		//line 6
		String line = "0;00;002;0020;;Wybory do Sejmu i Senatu RP;B-5;Bc;Postępowanie z dokumentacją wyborczą regulują  odrębne przepisy";
		SymbolInfo test = SymbolUtils.parseLineToSymbolInfo(line);
		
		Assert.assertNotNull(test);
		//Columns section
		Assert.assertEquals("0"   , test.columns[0]);
		Assert.assertEquals("00"  , test.columns[1]);
		Assert.assertEquals("002" , test.columns[2]);
		Assert.assertEquals("0020", test.columns[3]);
		Assert.assertEquals(""    , test.columns[4]);
		
		//Rest of info
		Assert.assertEquals("Wybory do Sejmu i Senatu RP", test.name);
		Assert.assertEquals("B-5", test.ka_km);
		Assert.assertEquals("Bc", test.ka_ki);
		Assert.assertEquals("Postępowanie z dokumentacją wyborczą regulują  odrębne przepisy", test.comments);	
	}
	
	@Test public void DeepthTest()
	{
		SymbolInfo symbolInfo  = new SymbolInfo();
		
		symbolInfo.columns[0] = "0";
		symbolInfo.columns[1] = "";
		Assert.assertEquals(0, SymbolUtils.computeDeepth(symbolInfo));
		symbolInfo.columns[0] = "1";
		symbolInfo.columns[1] = "2";
		symbolInfo.columns[2] = "";
		Assert.assertEquals(1, SymbolUtils.computeDeepth(symbolInfo));
	}
}
