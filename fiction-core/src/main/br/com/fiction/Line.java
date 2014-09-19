package main.br.com.fiction;

public abstract class Line {
	protected String lineText;
	
	public Line() {
		configure();
	}
	
	public Line(String lineText) {
		this.lineText = lineText;
		
		configure();
		
		setLineText(lineText);
	}
	
	protected void configure() {
		registerFields();
	}
	
	public String getLineText(){
		objectToText();
		
		return lineText;
	}
	
	public void setLineText(String lineText){
		this.lineText = lineText;
		
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
	
	protected abstract void objectToText(); 
	
	protected abstract void textToObject(String lineText);
	
	public abstract void add(Field positionalField);
}
