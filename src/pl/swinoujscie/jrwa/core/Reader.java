package pl.swinoujscie.jrwa.core;

import java.io.BufferedReader;
import java.util.List;

public abstract class Reader implements JRWA {
	BufferedReader bufferedReaderr = null;
	private String FILENAME;
	
	public abstract List<Entity> getTopLevel(); 
	public abstract List<Entity> findChildrens(Entity parrent);
	public abstract List<Entity> findSimilar(String searchLine);
	public abstract List<Entity> getShortTree(Entity element);
	
	public String getFILENAME() {
		return FILENAME;
	}
	
	
}
