package main.br.com.fiction.delimited;

import main.br.com.fiction.Field;

public class DelimitedField extends Field {

	private final int index;
	
	public DelimitedField(DelimitedLine delimitedLine, int index) {
		super(delimitedLine);
		
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

}
