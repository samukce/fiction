package test.br.com.fiction.positional;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextByPosition {

	@Test
	public void shouldSplitTheFields() {
        MockPositional mockPositional = new MockPositional("123456John Foo");
        mockPositional.synchronizeTextToObject();

        assertEquals("123456", mockPositional.getTrack().getValue());
        assertEquals("John Foo", mockPositional.getName().getValue());
	}
	
	@Test
	public void shouldTruncateIfTextGreaterThanTotalConfigured(){
        MockPositional mockPositional = new MockPositional("123456John Foooooooo");
        mockPositional.synchronizeTextToObject();

        assertEquals("123456", mockPositional.getTrack().getValue());
        assertEquals("John Foo", mockPositional.getName().getValue());
	}
	
	@Test
	public void shouldSynchronizeObjectToText(){
        MockPositional mockPositional = new MockPositional();
        mockPositional.getTrack().setValue("123456");
        mockPositional.getName().setValue("John Foo");
        
        mockPositional.synchronizeObjectToText();

        assertEquals("123456John Foo", mockPositional.getLineText());
	}
	
	@Test
	public void shouldTruncateIfValueFromFieldGreaterThanConfigured() {
        MockPositional mockPositional = new MockPositional();
        mockPositional.getTrack().setValue("12345600000000000");
        mockPositional.getName().setValue("John Foooooooooooo");
        
        mockPositional.synchronizeObjectToText();

        assertEquals("123456John Foo", mockPositional.getLineText());
	}
	
	@Test
	public void shouldAlignToRightTrackField() {
        MockPositional mockPositional = new MockPositional();
        mockPositional.getTrack().setValue("123");
        mockPositional.getName().setValue("John Foo");
        
        mockPositional.synchronizeObjectToText();

        assertEquals("   123John Foo", mockPositional.getLineText());
	}
	
	@Test
	public void shouldFillUntilEnd() {
        MockPositional mockPositional = new MockPositional();
        mockPositional.getTrack().setValue("123");
        mockPositional.getName().setValue("John");
        
        mockPositional.synchronizeObjectToText();

        assertEquals("   123John    ", mockPositional.getLineText());
	}

}

