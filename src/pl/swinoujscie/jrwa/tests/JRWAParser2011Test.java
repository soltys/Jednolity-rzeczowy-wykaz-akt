package pl.swinoujscie.jrwa.tests;

import org.junit.Assert;
import org.junit.Test;

import pl.swinoujscie.jrwa.core.JRWAEntity2011;
import pl.swinoujscie.jrwa.core.JRWAParser2011;

public class JRWAParser2011Test {
	@Test public void lineParser()
	{
		JRWAParser2011 jrwaParser2011 = new JRWAParser2011();
		JRWAEntity2011 jrwaEntity = (JRWAEntity2011) jrwaParser2011.parse(";;;0003;Wnioski i interpelacje radnych;A;w tym rejestr i odpowiedzi");
		
		Assert.assertEquals("Wnioski i interpelacje radnych", jrwaEntity.getName());
		Assert.assertEquals("A", jrwaEntity.getKa_km());
		Assert.assertEquals("w tym rejestr i odpowiedzi", jrwaEntity.getComments());
	}
	
	@Test public void getVersionTest()
	{
		JRWAParser2011 jrwaParser2011 = new JRWAParser2011();
		Assert.assertEquals("2011",jrwaParser2011.getVersion());
	}
	
}
