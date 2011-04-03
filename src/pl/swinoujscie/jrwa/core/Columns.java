package pl.swinoujscie.jrwa.core;

public class Columns implements Comparable<Columns>{
	private String[] columns;
	
	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public Columns(int numberColumns) {
		columns = new String[numberColumns];
	}
	
	public String[] fillAllColumns()
	{
		String stringNumber = columns[getLastNotEmptyColumn()];		
		int numberColumns = stringNumber.length();		
		String helper = "";
		
		for(int i=0; i<numberColumns;i++)
		{
			helper += stringNumber.charAt(i);
			columns[i] = helper;
		}
		return columns;
	}
	
	public int getLastNotEmptyColumn()
	{
		int index = 0;
		for(String str: columns)
		{
			if(!str.trim().equals(""))
			{
				return index;
			}
			index++;
		}
		return index;
	}

	@Override
	public int compareTo(Columns o) {
		String lhsCompareData = columns[getLastNotEmptyColumn()];
		String rhsCompareData = o.getColumns()[getLastNotEmptyColumn()];
		int lhsDataLength = lhsCompareData.length();
		int rhsDataLength = rhsCompareData.length();
		int minSize = ( lhsDataLength < rhsDataLength) ? lhsDataLength : rhsDataLength;
		
		for(int index = 0; index <minSize; index++)
		{
			int lhsValue = Integer.valueOf(lhsCompareData.substring(index, index+1)); //Get single number			
			int rhsValue = Integer.valueOf(rhsCompareData.substring(index,index+1));
			if(lhsValue < rhsValue)
				return 1;
			if(lhsValue > rhsValue)
				return -1;
		}	
		if(lhsDataLength < rhsDataLength)
			return 1;
		else if(lhsDataLength > rhsDataLength)
			return -1;
		return 0;
	}
}
