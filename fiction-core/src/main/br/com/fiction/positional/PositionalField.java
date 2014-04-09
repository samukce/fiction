package main.br.com.fiction.positional;


public class PositionalField {
	private final PositionalLine positionalLine;
	
	private String value;

	public boolean alignRight;

	public PositionalField(PositionalLine positionalLine) {
		this.positionalLine = positionalLine;
		this.positionalLine.Add(this);
	}

	public String getValue() {
		return value;
	}
}
