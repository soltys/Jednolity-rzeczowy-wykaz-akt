package pl.swinoujscie.jrwa.core;


public class JRWAEntity2010 extends JRWAEntity {
	final static private int NUMBER_OF_COLUMNS = 5;
	private String[] columns = new String [NUMBER_OF_COLUMNS];
	private String ka_ki;
	
	public int getNumberOfColumns() {
		return NUMBER_OF_COLUMNS;
	}
	
	public String[] getColumns() {
		return columns;
	}
	

	public void setColumns(String[] columns) {
		this.columns = columns;
	}


	public String getKa_ki() {
		return ka_ki;
	}


	public void setKa_ki(String ka_ki) {
		this.ka_ki = ka_ki;
	}	

	@Override
	public String toJSON() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isJRWAEntityParent(JRWAEntity children) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isJRWAEntityChildren(JRWAEntity parent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getVersion() {		
		return "2010";
	}
}
