package com.octo.spike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class FooBarQixTest {


    private final LambdaFooBarQix fooBar = new LambdaFooBarQix();

    @Test public void should_return_BAR() {
        String bar = fooBar.charToCode('5');
        assertEquals("BAR", bar);
    }

    @Test public void should_return_null() {
        String bar = fooBar.charToCode('1');
        assertNull(bar);
    }

    @Test public void should_return_number() {
        // When
		String result = fooBar.translate(1);
		
		// Then
		assertEquals("1", result);
	}

	@Test public void should_return_foo() {
		// When
		String result = fooBar.translate(3);
		
		// Then
		assertEquals("FOOFOO" ,result);
	}
	
	@Test public void should_return_bar() {
		// When
		String result = fooBar.translate(5);
		
		// Then
		assertEquals("BARBAR" ,result);
	}
	
	@Test public void should_return_qix() {
		// When
		String result = fooBar.translate(7);
		
		// Then
		assertEquals("QIXQIX" ,result);
	}

	@Test public void should_return_foobar() {
		// When
		String result = fooBar.translate(15);
		
		// Then
		assertEquals("FOOBARBAR" ,result);
	}
	
	@Test public void should_return_fooqix() {
		// When
		String result = fooBar.translate(21);
		
		// Then
		assertEquals("FOOQIX" ,result);
	}
	
	@Test public void should_return_bar_qix_foo_bar() {
		// When
		String result = fooBar.translate(35);
		
		// Then
		assertEquals("BARQIXFOOBAR" ,result);
	}
}
