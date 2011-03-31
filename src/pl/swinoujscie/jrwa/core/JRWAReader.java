package pl.swinoujscie.jrwa.core;

import java.io.BufferedReader;
import java.util.List;

public abstract class JRWAReader implements JRWA {
	BufferedReader bufferedReaderr = null;
	private String FILENAME;
	
	public abstract List<JRWAEntity> getTopLevel(); 
	public abstract List<JRWAEntity> findChildrens(JRWAEntity parrent);
	public abstract List<JRWAEntity> findSimilar(String searchLine);
	public abstract List<JRWAEntity> getShortTree(JRWAEntity element);
	
	public String getFILENAME() {
		return FILENAME;
	}
	
	
}
