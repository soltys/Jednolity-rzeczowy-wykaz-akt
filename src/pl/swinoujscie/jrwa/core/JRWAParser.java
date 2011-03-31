package pl.swinoujscie.jrwa.core;

abstract class JRWAParser implements JRWA {
	public abstract JRWAEntity parse(String stringToParse);
}
