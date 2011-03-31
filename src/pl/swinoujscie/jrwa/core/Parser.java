package pl.swinoujscie.jrwa.core;

abstract class Parser implements JRWA {
	public abstract Entity parse(String stringToParse);
}
