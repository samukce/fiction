package main.br.com.fiction.positional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import main.br.com.fiction.Field;
import main.br.com.fiction.Line;

public abstract class PositionalLine extends Line {
	private List<PositionalField> positionalFields;
	
	public PositionalLine() {
		super();
	}
	
	public PositionalLine(String lineText) {
		super(lineText);
	}
	
	protected void configure() {
		super.configure();
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

	protected List<PositionalField> getPositionalFields() {
		if (positionalFields == null){
			positionalFields = new ArrayList<PositionalField>();
		}
		
		return positionalFields;
	}
	
	public void add(Field positionalField) {
		getPositionalFields().add((PositionalField)positionalField);
	}
	
	protected void objectToText() {
        StringBuilder newText = new StringBuilder();

        for (PositionalField positionalField : positionalFields) {
        	newText.append(positionalField.getValue());
        }
        
        lineText = newText.toString();
    }
	
	protected void textToObject(String lineText) {
		String valueLineText = lineText;
		
		for (PositionalField positionalField : positionalFields) {

			int lengthField = positionalField.getLength();

			int initialPosition = positionalField.getInitialPosition() - 1;
			
			int end = initialPosition + lengthField;
			
			String valueField = valueLineText.substring(initialPosition, end);
			
			positionalField.setValue(valueField);
		}
	}
}
