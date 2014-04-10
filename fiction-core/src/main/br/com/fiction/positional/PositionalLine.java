package main.br.com.fiction.positional;

import java.util.ArrayList;

public abstract class PositionalLine {
	private String lineText;
	
	private final ArrayList<PositionalField> positionalFields = new ArrayList<PositionalField>();

	public PositionalLine() {
		configure();
	}
	
	public PositionalLine(String lineText) {
		this.lineText = lineText;
		
		configure();
	}
	
	protected abstract void configure(); 

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
	
	public void synchronizeObjectToText() {
		objectToText();
	}
	
	private void objectToText() {
        StringBuilder newText = new StringBuilder();

        for (PositionalField positionalField : positionalFields) {
        	newText.append(positionalField.getValue());
        }
        
        lineText = newText.toString();
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
