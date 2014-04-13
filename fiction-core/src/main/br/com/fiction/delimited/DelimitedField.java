package main.br.com.fiction.delimited;

public class DelimitedField {
	private final DelimitedLine delimitedLine;

	private final int index;
	private final String delimiter;
	private String value;
	
	public DelimitedField(DelimitedLine delimitedLine, int index, String delimiter) {
		this.index = index;
		this.delimiter = delimiter;
		
		this.delimitedLine = delimitedLine;
		this.delimitedLine.add(this);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public int getIndex() {
		return index;
	}

}
