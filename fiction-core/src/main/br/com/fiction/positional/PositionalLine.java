package main.br.com.fiction.positional;

import java.util.ArrayList;

public class PositionalLine {

	private final ArrayList<PositionalField> positionalFields;
	
	public PositionalLine() {
		positionalFields = new ArrayList<PositionalField>();
	}
	
	public void Add(PositionalField positionalField) {
		positionalFields.add(positionalField);
    }
}
