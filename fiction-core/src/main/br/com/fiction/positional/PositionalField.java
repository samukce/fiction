package main.br.com.fiction.positional;

public class PositionalField {
	private final PositionalLine positionalLine;
	
	private final int length;
	private final int initialPosition;
	private final boolean alighRight;
	
	private String value;

	public PositionalField(PositionalLine positionalLine, int initialPosition, int length, boolean alighRight) {
		this.alighRight = alighRight;
		this.length = length;
		this.initialPosition = initialPosition;
		
		this.positionalLine = positionalLine;
		this.positionalLine.Add(this);
	}

	public int getLength() {
		return length;
	}
	
	public String getValue() {
		while (value.length() < length) {
			if (alighRight) {
				value = " " + value;
			} else{
				value += " ";
			}
		}
		
		return value;
	}
	
	public void setValue(String value) {
		String valueField = value;
		
		if (value.length() > length){
			valueField = value.substring(0, length);
		}
			
		this.value = valueField;
	}

	public int getInitialPosition() {
		return this.initialPosition;
	}
}
