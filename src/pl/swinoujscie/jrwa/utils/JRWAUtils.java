package pl.swinoujscie.jrwa.utils;
public class JRWAUtils {
	public static String[] numberToColumns(String stringNumber)
	{
		int numberColumns = stringNumber.length();
		String[] columns = new String[numberColumns];
		String helper = "";
		
		for(int i=0; i<numberColumns;i++)
		{
			helper += stringNumber.charAt(i);
			columns[i] = helper;
		}
		return columns;
	}
}
