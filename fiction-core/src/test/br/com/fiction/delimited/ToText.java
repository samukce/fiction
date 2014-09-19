package test.br.com.fiction.delimited;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToText {

	@Test
	public void shouldSynchronizeObjectToText() {
        MockDelimited mockDelimited = new MockDelimited();
        mockDelimited.getTrack().setValue("123456");
        mockDelimited.getName().setValue("John Foo");
        
        mockDelimited.synchronizeObjectToText();

        assertEquals("123456|John Foo", mockDelimited.getLineText());
	}

	@Test
	public void shouldBeEmptyFieldNotFilled() {
        MockDelimited mockDelimited = new MockDelimited();
        mockDelimited.getTrack().setValue("123456");
        
        mockDelimited.synchronizeObjectToText();

        assertEquals("123456|", mockDelimited.getLineText());
	}

}

