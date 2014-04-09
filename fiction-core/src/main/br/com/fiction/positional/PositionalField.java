package main.br.com.fiction.positional;

public class PositionalField {
	private final PositionalLine positionalLine;
	
	private final int length;
	private final int initialPosition;
	
	private String value;

	public PositionalField(PositionalLine positionalLine, int initialPosition, int length) {
		this.length = length;
		this.initialPosition = initialPosition;
		
		this.positionalLine = positionalLine;
		this.positionalLine.Add(this);
	}

	public String getValue() {
		return value;
	}

	public int getLength() {
		return length;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public int getInitialPosition() {
		return this.initialPosition;
	}
}
