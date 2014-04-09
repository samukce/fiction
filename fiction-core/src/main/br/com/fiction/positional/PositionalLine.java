package main.br.com.fiction.positional;

import java.util.ArrayList;

public class PositionalLine {
	private String lineText;
	
	private final ArrayList<PositionalField> positionalFields = new ArrayList<PositionalField>();

	public PositionalLine(String lineText) {
		this.lineText = lineText;
	}

	public void Add(PositionalField positionalField) {
		positionalFields.add(positionalField);
	}

	public String getLineText(){
		return lineText;
	}
	
	public void setLineText(String lineText){
		this.lineText = lineText;
	}
	
	public void synchronizeTextToObject() {
		textToObject();
	}
	
	private void textToObject() {
		for (PositionalField positionalField : positionalFields) {

			int lengthField = positionalField.getLength();

			int initialPosition = positionalField.getInitialPosition() - 1;
			
			int end = initialPosition + lengthField;
			
			String valueField = lineText.substring(initialPosition, end);
			
			positionalField.setValue(valueField);
		}
	}
}
