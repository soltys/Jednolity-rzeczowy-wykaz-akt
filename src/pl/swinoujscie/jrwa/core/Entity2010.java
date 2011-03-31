package pl.swinoujscie.jrwa.core;
public class Entity2010 extends Entity {
	final static private int NUMBER_OF_COLUMNS = 5;
	
	private String ka_ki;
	public Entity2010()
	{
		this.setColumns(new Columns(NUMBER_OF_COLUMNS));
	}
	public int getNumberOfColumns() {
		return NUMBER_OF_COLUMNS;
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
	public boolean isJRWAEntityParent(Entity children) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isJRWAEntityChildren(Entity parent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getVersion() {		
		return "2010";
	}
}
