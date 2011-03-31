package pl.swinoujscie.jrwa.core;
public abstract class JRWAEntity implements JRWA {
	
	private JRWAColumns columns;
	private String name;
	private String ka_km;	
	private String comments;
	
	public void setColumns(JRWAColumns columns) {
		this.columns = columns;
	}
	public JRWAColumns getColumns() {
		return columns;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKa_km() {
		return ka_km;
	}
	public void setKa_km(String ka_km) {
		this.ka_km = ka_km;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public abstract String toJSON();
	public abstract boolean isJRWAEntityParent(JRWAEntity children);
	public abstract boolean isJRWAEntityChildren(JRWAEntity parent);
	public abstract String getVersion();
	public abstract int getNumberOfColumns();
	
}

