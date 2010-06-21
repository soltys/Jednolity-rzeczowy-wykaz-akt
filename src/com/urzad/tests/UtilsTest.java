package com.urzad.tests;
import org.junit.Assert;
import org.junit.Test;

import com.urzad.util.SymbolInfo;
import com.urzad.util.SymbolUtils;

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

	
	@Test public void isChildTest()
	{
		SymbolInfo parrent  = SymbolUtils.parseLineToSymbolInfo("0;00;003;;;Referenda;;;");
		SymbolInfo children = SymbolUtils.parseLineToSymbolInfo("0;00;003;0030;;Referendum ogólnokrajowe;B-5;Bc;Postępowanie z dokumentacją  referendum regulują odrębne przepisy");
		
		Assert.assertTrue(SymbolUtils.isChild(parrent, children));		
	}
	
	@Test public void isNotChildrTest()
	{
		SymbolInfo parrent  = SymbolUtils.parseLineToSymbolInfo("0;00;005;;;Działalność organów gminy;;;");
		SymbolInfo children = SymbolUtils.parseLineToSymbolInfo("0;00;006;0062;;Programy działania komisji i zespołów;A;Bc;");
		
		Assert.assertFalse(SymbolUtils.isChild(parrent, children));		
	}
	
	//TODO It need a better name
	@Test public void isNotChildrTest2()
	{
		SymbolInfo parrent  = SymbolUtils.parseLineToSymbolInfo("0;00;;;;PRZEPISY PRAWNE DOTYCZĄCE ORGANÓW JEDNOOSOBOWYCH I KOLEGIALNYCH;B-10;Bc;");
		SymbolInfo children = SymbolUtils.parseLineToSymbolInfo("0;00;002;0026;;Interwencje, wnioski i postulaty senatorów;B-5;Bc;");
		
		Assert.assertFalse(SymbolUtils.isChild(parrent, children));		
	}
}
