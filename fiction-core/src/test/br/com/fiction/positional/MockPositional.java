package test.br.com.fiction.positional;

import main.br.com.fiction.positional.PositionalField;
import main.br.com.fiction.positional.PositionalLine;

public class MockPositional extends PositionalLine {
	private PositionalField track;
	private PositionalField name;
	
	public MockPositional(String lineText)  {
		super(lineText);
		
		this.track = new PositionalField(this, 1, 6);
		this.name = new PositionalField(this, 7, 8);
	}

	public PositionalField getTrack() {
		return track;
	}

	public PositionalField getName() {
		return name;
	}

	
}
