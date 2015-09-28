package test.br.com.fiction.delimited;

import main.br.com.fiction.delimited.DelimitedField;
import main.br.com.fiction.delimited.DelimitedLine;

public class MockDelimited extends DelimitedLine {
	private DelimitedField track;
	private DelimitedField name;
	
	private DelimitedField fiveField;
	
	public MockDelimited() {
		super();
	}
	
	public MockDelimited(String lineText)  {
		super(lineText);
	}

	protected void registerFields() {
		this.track = new DelimitedField(this, 1, "|");
		this.name = new DelimitedField(this, 2, "|");
		this.fiveField = new DelimitedField(this, 5, "|");
	}

	public DelimitedField getTrack() {
		return track;
	}

	public DelimitedField getName() {
		return name;
	}

	public DelimitedField getFiveField() {
		return fiveField;
	}
}
