package main.br.com.fiction.delimited;

import java.util.ArrayList;
import java.util.List;

public abstract class DelimitedLine {
	private String lineText;
	
	private final List<DelimitedField> delimitedFields = new ArrayList<DelimitedField>();

	public DelimitedLine() {
		configure();
	}
	
	public DelimitedLine(String lineText) {
		this.lineText = lineText;
		
		configure();
	}
	
	protected void configure() {
		registerFields();
	}
	
	protected abstract void registerFields(); 

	public void add(DelimitedField positionalField) {
		delimitedFields.add(positionalField);
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

        for (DelimitedField delimitedField : delimitedFields) {
        	newText.append(delimitedField.getValue());
        	
        	int indexDelimited = delimitedFields.indexOf(delimitedField);
        	
        	if (indexDelimited < delimitedFields.size() - 1)
        		newText.append(delimitedField.getDelimiter());
        }
        
        lineText = newText.toString();
    }
	
	private void textToObject() {
		for (DelimitedField delimitedField : delimitedFields) {
			String value = getFieldValue(delimitedField.getIndex(), delimitedField.getDelimiter(), lineText);
			
			delimitedField.setValue(value);
        }
	}

	private String getFieldValue(int index, String delimiter, String text) {
		String[] arraySplit = text.split("\\"+delimiter);
		
		return arraySplit[index - 1];
	}
}
