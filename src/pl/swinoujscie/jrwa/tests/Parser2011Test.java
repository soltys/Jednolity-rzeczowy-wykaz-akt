package pl.swinoujscie.jrwa.tests;

import org.junit.Assert;
import org.junit.Test;

import pl.swinoujscie.jrwa.core.Entity2011;
import pl.swinoujscie.jrwa.core.Parser2011;

public class Parser2011Test {
	@Test public void lineParser()
	{
		Parser2011 jrwaParser2011 = new Parser2011();
		Entity2011 jrwaEntity = (Entity2011) jrwaParser2011.parse(";;;0003;Wnioski i interpelacje radnych;A;w tym rejestr i odpowiedzi");
		
		Assert.assertEquals("Wnioski i interpelacje radnych", jrwaEntity.getName());
		Assert.assertEquals("A", jrwaEntity.getKa_km());
		Assert.assertEquals("w tym rejestr i odpowiedzi", jrwaEntity.getComments());
	}
	
	@Test public void column2011Test()
	{
		Parser2011 jrwaParser2011 = new Parser2011();
		Entity2011 jrwaEntity = (Entity2011) jrwaParser2011.parse(";;;0003;Wnioski i interpelacje radnych;A;w tym rejestr i odpowiedzi");
		
		String[] columns = jrwaEntity.getColumns().getColumns();		
		Assert.assertEquals("", columns[0]);
		Assert.assertEquals("", columns[1]);
		Assert.assertEquals("", columns[2]);
		Assert.assertEquals("0003", columns[3]);
	}
	
	@Test public void getVersionTest()
	{
		Parser2011 jrwaParser2011 = new Parser2011();
		Assert.assertEquals("2011",jrwaParser2011.getVersion());
	}
	
}
