package main.br.com.fiction.positional;

import main.br.com.fiction.Field;
import main.br.com.fiction.Line;

public class PositionalField extends Field {
	private final int length;
	private final int initialPosition;
	private final boolean alighRight;
	
	public PositionalField(Line line, int initialPosition, int length, boolean alighRight) {
		super(line);
		
		this.alighRight = alighRight;
		this.length = length;
		this.initialPosition = initialPosition;
	}

	public int getLength() {
		return length;
	}
	
	public String getValue() {
		while (value.length() < length) {
			if (alighRight) {
				value = " " + value;
			} else {
				value += " ";
			}
		}
		
		return value;
	}
	
	public void setValue(String valueParameter) {
		String valueField = valueParameter;
		
		if (valueParameter.length() > length){
			valueField = valueParameter.substring(0, length);
		}
			
		value = valueField;
	}

	public Integer getInitialPosition() {
		return initialPosition;
	}
}
