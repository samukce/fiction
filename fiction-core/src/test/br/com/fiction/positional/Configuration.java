package test.br.com.fiction.positional;

import static org.junit.Assert.*;

import org.junit.Test;

public class Configuration {

	@Test
	public void shouldIgnoreTheResgitrationOrderOfTheFields() {
        MockNoOrder mockNoOrder = new MockNoOrder();
        mockNoOrder.getTrack().setValue("123");
        mockNoOrder.getName().setValue("John");
        
        mockNoOrder.synchronizeObjectToText();

        assertEquals("   123John    ", mockNoOrder.getLineText());
	}
}

