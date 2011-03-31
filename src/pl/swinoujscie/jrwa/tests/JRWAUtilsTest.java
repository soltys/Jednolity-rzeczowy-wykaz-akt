package pl.swinoujscie.jrwa.tests;

import org.junit.Assert;
import org.junit.Test;

import pl.swinoujscie.jrwa.utils.JRWAUtils;

public class JRWAUtilsTest {

	@Test public void TestSomethingInJava()
	{
		Assert.assertEquals(-1,"00".compareToIgnoreCase("001"));
		Assert.assertEquals(1,"10".compareToIgnoreCase("101"));
	}
}
