package pl.swinoujscie.jrwa.core;

public class Parser2011 extends Parser {

	@Override
	public Entity parse(String stringToParse) {
		String[] data = stringToParse.split(";");
		Entity2011 jrwaEntity2011 = new Entity2011();
		int numberColumns = jrwaEntity2011.getNumberOfColumns();
		Columns jrwaColumns = getJRWAColumns(data, numberColumns);
		jrwaEntity2011.setColumns(jrwaColumns);
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

	private Columns getJRWAColumns(String[] data, int numberColumns) {
		Columns jrwaColumns = new Columns(numberColumns);
		String[] columns = new String[numberColumns];	
		columns[0] = data[0];
		columns[1] = data[1];
		columns[2] = data[2];
		columns[3] = data[3];		
		jrwaColumns.setColumns(columns);
		return jrwaColumns;
	}

	@Override
	public String getVersion() {
		return "2011";
	}
}
