package pl.swinoujscie.jrwa.tests;

import org.junit.Assert;
import org.junit.Test;

import pl.swinoujscie.jrwa.core.Columns;

public class ColumnsTest {
	@Test public void getLastNotEmptyColumnTest()
	{
		final int NUMBER_COLUMN = 5;
		Columns column = new Columns(NUMBER_COLUMN);
		String[] columnData = new String[NUMBER_COLUMN];
		columnData[0] = "";
		columnData[1] = "";
		columnData[2] = "";
		columnData[3] = "0024";
		column.setColumns(columnData);
		
		Assert.assertEquals(3, column.getLastNotEmptyColumn());		
	}
	
	@Test public void fillAllColumns()
	{
		final int NUMBER_COLUMN = 5;
		Columns column = new Columns(NUMBER_COLUMN);
		String[] columnData = new String[NUMBER_COLUMN];
		columnData[0] = "";
		columnData[1] = "";
		columnData[2] = "";
		columnData[3] = "0024";
		column.setColumns(columnData);
		column.fillAllColumns();
		columnData = column.getColumns();
		
		Assert.assertEquals("0",columnData[0]);
		Assert.assertEquals("00",columnData[1]);
		Assert.assertEquals("002",columnData[2]);
		Assert.assertEquals("0024",columnData[3]);		
	}
	@Test public void compareTest()
	{
		
	}
}
