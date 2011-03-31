package pl.swinoujscie.jrwa.core;

public abstract class JRWAManager implements JRWA {
	private JRWAReader jrwaReader;
	
	public abstract String getVersion();
	public abstract String getStartupResponse();
	public abstract String getSearchResponse(String searchLine);
	public abstract String getChildrenResponse(JRWAEntity jrwaEntity);	
}
