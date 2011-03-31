package pl.swinoujscie.jrwa.core;
public abstract class JRWAEntity implements JRWA {
	
	private String name;
	private String ka_km;	
	private String comments;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKa_km() {
		return ka_km;
	}
	public void setKa_km(String ka_km) {
		this.ka_km = ka_km;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public abstract String toJSON();
	public abstract boolean isJRWAEntityParent(JRWAEntity children);
	public abstract boolean isJRWAEntityChildren(JRWAEntity parent);
	public abstract String getVersion();
	public abstract int getNumberOfColumns();
	
}

class JRWAColumns implements Comparable<JRWAColumns>{
	private String[] columns;
	
	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public JRWAColumns(int numberColumns) {
		columns = new String[numberColumns];
	}
	
	public String[] fillAllColumns()
	{
		String stringNumber = columns[getLastNotEmptyColumn()];		
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
	
	public int getLastNotEmptyColumn()
	{
		int index = 0;
		for(String str: columns)
		{
			if(str.equalsIgnoreCase("") || str == null)
				return index;
			index++;
		}
		return index;
	}

	@Override
	public int compareTo(JRWAColumns o) {
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
