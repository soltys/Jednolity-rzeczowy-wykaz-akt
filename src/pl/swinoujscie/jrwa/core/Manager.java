package pl.swinoujscie.jrwa.core;

public abstract class Manager implements JRWA {
	private Reader jrwaReader;
	
	public abstract String getVersion();
	public abstract String getStartupResponse();
	public abstract String getSearchResponse(String searchLine);
	public abstract String getChildrenResponse(Entity jrwaEntity);	
}
