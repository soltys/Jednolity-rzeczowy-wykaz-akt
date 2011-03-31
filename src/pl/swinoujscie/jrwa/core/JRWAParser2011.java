package pl.swinoujscie.jrwa.core;

public class JRWAParser2011 extends JRWAParser {

	@Override
	public JRWAEntity parse(String stringToParse) {
		String[] data = stringToParse.split(";");
		JRWAEntity2011 jrwaEntity2011 = new JRWAEntity2011();
		int numberColumns = jrwaEntity2011.getNumberOfColumns();
		String[] columns = new String[numberColumns];	
		columns[0] = data[0];
		columns[1] = data[1];
		columns[2] = data[2];
		columns[3] = data[3];		
	
		switch (data.length) {
		case 7:
			jrwaEntity2011.setComments(data[6]);		
		case 6:
			jrwaEntity2011.setKa_km(data[5]);
		case 5:
			jrwaEntity2011.setName(data[4]);
		default:			
		}		
		return jrwaEntity2011;
	}

	@Override
	public String getVersion() {
		return "2011";
	}
}
