package test.br.com.fiction.delimited;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToText {

	@Test
	public void shouldSynchronizeObjectToText() {
        MockDelimited mockDelimited = new MockDelimited();
        mockDelimited.getTrack().setValue("123456");
        mockDelimited.getName().setValue("John Foo");

        assertEquals("123456|John Foo|||", mockDelimited.getLineText());
	}

	@Test
	public void shouldBeEmptyFieldNotFilled() {
        MockDelimited mockDelimited = new MockDelimited();
        mockDelimited.getTrack().setValue("123456");
        
        assertEquals("123456||||", mockDelimited.getLineText());
	}

	@Test
	public void shouldFillEmptyFields() {
        MockDelimited mockDelimited = new MockDelimited();
        mockDelimited.getTrack().setValue("123456");
        
        assertEquals("123456||||", mockDelimited.getLineText());
	}
	
	@Test
	public void shouldFillEmptyFieldsUntilFiveField() {
        MockDelimited mockDelimited = new MockDelimited();
        mockDelimited.getTrack().setValue("123456");
        mockDelimited.getFiveField().setValue("Five Content");
        
        assertEquals("123456||||Five Content", mockDelimited.getLineText());
	}
	
	@Test
	public void shouldFillEmptyAllFields() {
        MockDelimited mockDelimited = new MockDelimited();
        
        assertEquals("||||", mockDelimited.getLineText());
	}
}

