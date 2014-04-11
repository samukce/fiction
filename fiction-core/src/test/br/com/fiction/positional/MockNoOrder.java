package test.br.com.fiction.positional;

import main.br.com.fiction.positional.PositionalField;
import main.br.com.fiction.positional.PositionalLine;

public class MockNoOrder extends PositionalLine {
	private PositionalField track;
	private PositionalField name;
	
	public MockNoOrder() {
		super();
	}
	
	public MockNoOrder(String lineText)  {
		super(lineText);
	}

	protected void registerFields() {
		this.name = new PositionalField(this, 7, 8, false);
		this.track = new PositionalField(this, 1, 6, true);
	}

	public PositionalField getTrack() {
		return track;
	}

	public PositionalField getName() {
		return name;
	}
}
