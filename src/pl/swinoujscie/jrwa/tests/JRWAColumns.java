package pl.swinoujscie.jrwa.tests;

import org.junit.Assert;
import org.junit.Test;

import pl.swinoujscie.jrwa.core.JRWAEntity2011;
import pl.swinoujscie.jrwa.core.JRWAParser2011;

public class JRWAColumns {
	@Test public void columnTest()
	{
		JRWAParser2011 jrwaParser2011 = new JRWAParser2011();
		JRWAEntity2011 jrwaEntity = (JRWAEntity2011) jrwaParser2011.parse(";;;0003;Wnioski i interpelacje radnych;A;w tym rejestr i odpowiedzi");
		
		String[] columns = jrwaEntity.getColumns().getColumns();		
		Assert.assertEquals("", columns[0]);
		Assert.assertEquals("", columns[1]);
		Assert.assertEquals("", columns[2]);
		Assert.assertEquals("0003", columns[3]);
	}
}
