package test.br.com.fiction.positional;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToText {

	@Test
	public void shouldSynchronizeObjectToText() {
        MockPositional mockPositional = new MockPositional();
        mockPositional.getTrack().setValue("123456");
        mockPositional.getName().setValue("John Foo");

        assertEquals("123456John Foo", mockPositional.getLineText());
	}
	
	@Test
	public void shouldTruncateIfValueFromFieldGreaterThanConfigured() {
        MockPositional mockPositional = new MockPositional();
        mockPositional.getTrack().setValue("12345600000000000");
        mockPositional.getName().setValue("John Foooooooooooo");

        assertEquals("123456John Foo", mockPositional.getLineText());
	}
	
	@Test
	public void shouldAlignToRightTrackField() {
        MockPositional mockPositional = new MockPositional();
        mockPositional.getTrack().setValue("123");
        mockPositional.getName().setValue("John Foo");

        assertEquals("   123John Foo", mockPositional.getLineText());
	}
	
	@Test
	public void shouldFillUntilEnd() {
        MockPositional mockPositional = new MockPositional();
        mockPositional.getTrack().setValue("123");
        mockPositional.getName().setValue("John");
        
        assertEquals("   123John    ", mockPositional.getLineText());
	}

	@Test
	public void shouldIgnoreTheResgitrationOrderOfTheFields() {
        MockNoOrder mockNoOrder = new MockNoOrder();
        mockNoOrder.getTrack().setValue("123");
        mockNoOrder.getName().setValue("John");

        assertEquals("   123John    ", mockNoOrder.getLineText());
	}
}

