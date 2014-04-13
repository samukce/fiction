package main.br.com.fiction;

public abstract class Line {
	private String lineText;
	
	public Line() {
		configure();
	}
	
	public Line(String lineText) {
		this.lineText = lineText;
		
		configure();
	}
	
	protected void configure() {
		registerFields();
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
	
	protected abstract void registerFields(); 
	
	protected abstract void objectToText(); 
	
	protected abstract void textToObject();
	
	public abstract void add(Field positionalField);
}
