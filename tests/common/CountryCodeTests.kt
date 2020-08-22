package tests

import io.fluidsonic.country.*
import kotlin.test.*


class CountryCodeTests {

	@Test
	fun testEqualsAndHashCode() {
		assertEquals(expected = CountryCode.parse("US"), actual = CountryCode.parse("us"))
		assertEquals(expected = CountryCode.parse("US").hashCode(), actual = CountryCode.parse("us").hashCode())
	}


	@Test
	fun testIsValid() {
		assertTrue(CountryCode.parse("us").isValid())
		assertFalse(CountryCode.parse("aa").isValid())
	}


	@Test
	fun testParseAndToString() {
		assertEquals(expected = "US", actual = CountryCode.parse("US").toString())
		assertEquals(expected = "AA", actual = CountryCode.parse("aa").toString())

		assertEquals(
			expected = "Invalid ISO 3166-1 alpha-2 country code format: ab1",
			actual = assertFails { CountryCode.parse("ab1") }.message
		)
	}
}
