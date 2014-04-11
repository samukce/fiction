package test.br.com.fiction.positional;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToObject {

	@Test
	public void shouldSplitTheFields() {
        MockPositional mockPositional = new MockPositional("123456John Foo");
        mockPositional.synchronizeTextToObject();

        assertEquals("123456", mockPositional.getTrack().getValue());
        assertEquals("John Foo", mockPositional.getName().getValue());
	}
	
	@Test
	public void shouldTruncateIfTextGreaterThanTotalConfigured() {
        MockPositional mockPositional = new MockPositional("123456John Foooooooo");
        mockPositional.synchronizeTextToObject();

        assertEquals("123456", mockPositional.getTrack().getValue());
        assertEquals("John Foo", mockPositional.getName().getValue());
	}
}

