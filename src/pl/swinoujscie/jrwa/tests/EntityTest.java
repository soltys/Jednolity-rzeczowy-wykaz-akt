package pl.swinoujscie.jrwa.tests;

import junit.framework.Assert;

import org.junit.Test;

import pl.swinoujscie.jrwa.core.Entity;
import pl.swinoujscie.jrwa.core.Parser2010;

public class EntityTest {
	
	Entity higherPriorytyEntity;
	Entity lowerPriorytyEntity;
	
	public void SetUp(String higherPriorytyLine,String lowerPriorytyLine)
	{	
		Parser2010 jrwaParser2010 = new Parser2010();		
		higherPriorytyEntity = jrwaParser2010.parse(higherPriorytyLine);
		lowerPriorytyEntity =  jrwaParser2010.parse(lowerPriorytyLine);
	}
	
	@Test public void compareToTest()
	{
		String higherPriorytyLine = "0;00;002;0020;;Wybory do Sejmu i Senatu RP;B-5;Bc;Postępowanie z dokumentacją wyborczą regulują  odrębne przepisy";
		String lowerPriorytyLine = "0;00;004;;;Organy samorządu terytorialnego;;;";
		SetUp(higherPriorytyLine, lowerPriorytyLine);		
		Assert.assertEquals(-1, lowerPriorytyEntity.compareTo(higherPriorytyEntity));		
	}
	
	@Test public void compareToDiffrentRootLevelTest()
	{
		String higherPriorytyLine = "0;;;;;ORGANY JEDNOOSOBOWE I KOLEGIALNE;;;";
		String lowerPriorytyLine = "1;;;;;ORGANIZACJA;;;";
		SetUp(higherPriorytyLine, lowerPriorytyLine);
		Assert.assertEquals(-1, lowerPriorytyEntity.compareTo(higherPriorytyEntity));	
	}
	
	@Test public void compareToEqualsColumnsTest()
	{
		String line = "1;;;;;ORGANIZACJA;;;";
		SetUp(line, line);
		Assert.assertEquals(0, lowerPriorytyEntity.compareTo(lowerPriorytyEntity));
	}
	
	@Test public void compareToHigherFirst()
	{
		String higherPriorytyLine = "1;12;122;1224;;Szkolenie praktykantów;B-3;Bc;";
		String lowerPriorytyLine = "1;12;122;1225;;Egzaminy kwalifikacyjne;B-50;Bc;";
		SetUp(higherPriorytyLine, lowerPriorytyLine);
		Assert.assertEquals(1, higherPriorytyEntity.compareTo(lowerPriorytyEntity));
		
	}
}
