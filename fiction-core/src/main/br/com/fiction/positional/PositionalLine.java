package main.br.com.fiction.positional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class PositionalLine {
	private String lineText;
	
	private final List<PositionalField> positionalFields = new ArrayList<PositionalField>();

	public PositionalLine() {
		configure();
	}
	
	public PositionalLine(String lineText) {
		this.lineText = lineText;
		
		configure();
	}
	
	protected void configure() {
		registerFields();
		orderFields();
	}
	
	private void orderFields() {
		Collections.sort(positionalFields, new Comparator<PositionalField>() {
	        @Override
	        public int compare(PositionalField  field1, PositionalField field2){
	            return  field1.getInitialPosition().compareTo(field2.getInitialPosition());
	        }
	    });
	}
	
	protected abstract void registerFields(); 

	public void add(PositionalField positionalField) {
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
