package main.br.com.fiction;

public abstract class Line {
	
	public Line() {
		configure();
	}
	
	public Line(String lineText) {
		configure();
		
		setLineText(lineText);
	}
	
	protected void configure() {
		registerFields();
	}
	
	public String getLineText(){
		return objectToText();
	}
	
	public void setLineText(String lineText){
		textToObject(lineText);
	}
	
	/**
     * Register your fields:
     * <p>Example: 
	 * <pre class="code"><code class="java">
	 * 
	 * public class ExamplePositional extends PositionalLine {
	 *    private PositionalField track;
	 *
	 *    protected void registerFields() {
	 *       this.field = new PositionalField(this, 1, 10, false);
	 *    }
	 * }
	 * </code></pre>
     */
	protected abstract void registerFields(); 
	
	protected abstract String objectToText(); 
	
	protected abstract void textToObject(String lineText);
	
	public abstract void add(Field positionalField);
}
