package de.tud.stg.tigerseye

import static org.junit.Assert.assertTrue
import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

/**
 * Basic test for verifying that tests are setup correctly.
 * @author Tom Dinkelaker
 */
class BaselineTestableTests {

	@Test
	void test() {
		assertTrue(new BaselineTestable().someMethod())
	}

}
