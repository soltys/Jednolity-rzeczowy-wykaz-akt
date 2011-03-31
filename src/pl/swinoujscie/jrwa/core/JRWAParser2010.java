package pl.swinoujscie.jrwa.core;

public class JRWAParser2010 extends JRWAParser {

	@Override
	public JRWAEntity parse(String stringToParse) {
		String[] data = stringToParse.split(";");
		JRWAEntity2010 jrwaEntity2010 = new JRWAEntity2010();
		int numberColumns = jrwaEntity2010.getNumberOfColumns();
		String[] columns = new String[numberColumns];	
		columns[0] = data[0];
		columns[1] = data[1];
		columns[2] = data[2];
		columns[3] = data[3];
		columns[4] = data[4];	
	
		switch (data.length) {
		case 9:
			jrwaEntity2010.setComments(data[8]);
		case 8:
			jrwaEntity2010.setKa_ki(data[7]);
		case 7:
			jrwaEntity2010.setKa_km(data[6]);
		case 6:
			jrwaEntity2010.setName(data[5]);
		default:			
		}		
		return jrwaEntity2010;		
	}

	@Override
	public String getVersion() {		
		return "2010";
	}
}