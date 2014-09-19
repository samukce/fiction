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
}

