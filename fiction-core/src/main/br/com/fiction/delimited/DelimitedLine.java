package main.br.com.fiction.delimited;

import java.util.ArrayList;
import java.util.List;

import main.br.com.fiction.Field;
import main.br.com.fiction.Line;

public abstract class DelimitedLine extends Line {
	private List<DelimitedField> delimitedFields;

	public DelimitedLine() {
		super();
	}

	public DelimitedLine(String lineText) {
		super(lineText);
	}

	public void add(Field positionalField) {
		getDelimitedFields().add((DelimitedField) positionalField);
	}

	public List<DelimitedField> getDelimitedFields() {
		if (delimitedFields == null)
			delimitedFields = new ArrayList<DelimitedField>();

		return delimitedFields;
	}

	protected String objectToText() {
		StringBuilder newText = new StringBuilder();

		int beforeFieldPosition = 1000;
		for (DelimitedField delimitedField : delimitedFields) {
			String valueField = delimitedField.getValue();

			
			int indexDelimited = delimitedFields.indexOf(delimitedField);
			
			for (int i = beforeFieldPosition; i < delimitedField.getIndex() ; i++) {
				newText.append(delimitedField.getDelimiter());
			}
			beforeFieldPosition = delimitedField.getIndex();
			
			if (valueField != null)
				newText.append(delimitedField.getValue());

			
			//if (indexDelimited < delimitedFields.size() - 1) {
			//	newText.append(delimitedField.getDelimiter());
			//}
		}

		return newText.toString();
	}

	protected void textToObject(String lineText) {
		for (DelimitedField delimitedField : delimitedFields) {
			String value = getFieldValue(delimitedField.getIndex(), 
										 delimitedField.getDelimiter(), 
										 lineText);

			delimitedField.setValue(value);
		}
	}

	private String getFieldValue(int index, String delimiter, String text) {
		String[] arraySplit = text.split("\\" + delimiter);

		if (arraySplit.length < index){
			return "";
		}
		
		return arraySplit[index - 1];
	}
}
