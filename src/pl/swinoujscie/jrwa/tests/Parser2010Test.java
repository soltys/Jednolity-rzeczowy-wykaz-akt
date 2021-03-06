package pl.swinoujscie.jrwa.tests;
import pl.swinoujscie.jrwa.core.*;

import org.junit.Assert;
import org.junit.Test;

public class Parser2010Test {
	@Test public void LineParserTest(){
		Parser2010 jrwaParser2010 = new Parser2010();
		//line 6
		String line = "0;00;002;0020;;Wybory do Sejmu i Senatu RP;B-5;Bc;Postępowanie z dokumentacją wyborczą regulują  odrębne przepisy";
		Entity2010 jrwaEntity2010;
		jrwaEntity2010 = (Entity2010) jrwaParser2010.parse(line);
		Assert.assertEquals("Wybory do Sejmu i Senatu RP", jrwaEntity2010.getName());
		Assert.assertEquals("B-5", jrwaEntity2010.getKa_km());
		Assert.assertEquals("Bc", jrwaEntity2010.getKa_ki());
		Assert.assertEquals("Postępowanie z dokumentacją wyborczą regulują  odrębne przepisy", jrwaEntity2010.getComments());		
	}
	
	@Test public void column2010Test()
	{
		String line = "0;00;002;0020;;Wybory do Sejmu i Senatu RP;B-5;Bc;Postępowanie z dokumentacją wyborczą regulują  odrębne przepisy";
		Parser2010 jrwaParser2010 = new Parser2010();
		Entity2010 entity2010 = (Entity2010) jrwaParser2010.parse(line);
		String[] columns = entity2010.getColumns();			
		Assert.assertEquals("0", columns[0]);
		Assert.assertEquals("00", columns[1]);
		Assert.assertEquals("002", columns[2]);
		Assert.assertEquals("0020", columns[3]);
	}
	
	@Test public void getVersionTest()
	{
		Parser2010 jrwaParser2010 = new Parser2010();		
		Assert.assertEquals("2010", jrwaParser2010.getVersion());
	}	
}
