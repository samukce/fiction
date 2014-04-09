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

}

