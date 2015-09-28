package test.br.com.fiction.delimited;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToObject {

	@Test
	public void shouldSplitTheFields() {
        MockDelimited mockDelimited = new MockDelimited("123456|John Foo");

        assertEquals("123456", mockDelimited.getTrack().getValue());
        assertEquals("John Foo", mockDelimited.getName().getValue());
	}
	
	@Test
	public void shouldBeEmptySecondFieldNotFilled() {
        MockDelimited mockDelimited = new MockDelimited("123456|");

        assertEquals("123456", mockDelimited.getTrack().getValue());
        assertEquals("", mockDelimited.getName().getValue());
	}
	
	@Test
	public void shouldBeEmptyFirstFieldNotFilled() {
        MockDelimited mockDelimited = new MockDelimited("|John Foo");

        assertEquals("", mockDelimited.getTrack().getValue());
        assertEquals("John Foo", mockDelimited.getName().getValue());
	}
	
	@Test
	public void shouldBeFillFieldFiveAfterEmptiesFields() {
        MockDelimited mockDelimited = new MockDelimited("||||Five Content");

        assertEquals("Five Content", mockDelimited.getFiveField().getValue());
	}
}

