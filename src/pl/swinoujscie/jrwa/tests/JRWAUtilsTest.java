package pl.swinoujscie.jrwa.tests;

import org.junit.Assert;
import org.junit.Test;

import pl.swinoujscie.jrwa.utils.JRWAUtils;

public class JRWAUtilsTest {

	@Test public void NumberToCollumns()
	{
		String stringNumber = "0020";
		String[] columns = new String[4];
		String[] expectedColumns = new String [4];
		expectedColumns[0]="0";
		expectedColumns[1]="00";
		expectedColumns[2]="002";
		expectedColumns[3]="0020";
			
		columns = JRWAUtils.numberToColumns(stringNumber);
		
		Assert.assertArrayEquals(expectedColumns, columns);		
	}
}
