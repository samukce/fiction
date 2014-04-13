package main.br.com.fiction.delimited;

import main.br.com.fiction.Field;

public class DelimitedField extends Field {

	private final int index;
	private final String delimiter;
	
	public DelimitedField(DelimitedLine delimitedLine, int index, String delimiter) {
		super(delimitedLine);
		
		this.index = index;
		this.delimiter = delimiter;
	}
	
	public String getDelimiter() {
		return delimiter;
	}

	public int getIndex() {
		return index;
	}

}
