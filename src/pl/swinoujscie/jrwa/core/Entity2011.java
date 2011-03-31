package pl.swinoujscie.jrwa.core;

public class Entity2011 extends Entity {
	final static private int NUMBER_OF_COLUMNS = 4;
	public Entity2011()
	{
		this.setColumns(new Columns(NUMBER_OF_COLUMNS));
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
		return "2011";
	}


	public int getNumberOfColumns() {	
		return NUMBER_OF_COLUMNS;
	}
}
