package main.br.com.fiction;

public class Field {
	private final Line line;

	private String value;
	
	public Field(Line line) {
		this.line = line;
		this.line.add(this);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
