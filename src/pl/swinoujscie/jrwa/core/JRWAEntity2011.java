package pl.swinoujscie.jrwa.core;

public class JRWAEntity2011 extends JRWAEntity {
	final static public int NUMBER_OF_COLUMNS = 4;
	public String[] columns = new String [NUMBER_OF_COLUMNS];
	
	
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
}
