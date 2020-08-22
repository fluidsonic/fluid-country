package tests

import io.fluidsonic.country.*
import kotlin.test.*


class CountryTests {

	@Test
	fun testEqualsAndHashCode() {
		assertEquals(expected = Country.forCode("US"), actual = Country.forCode("us"))
		assertEquals(expected = Country.forCode("US").hashCode(), actual = Country.forCode("us").hashCode())
	}


	@Test
	fun testForCode() {
		assertEquals(expected = "US", actual = Country.forCode(CountryCode.parse("US")).code.toString())
		assertNull(Country.forCodeOrNull(CountryCode.parse("aa")))

		assertEquals(
			expected = "Invalid ISO 3166-1 alpha-2 country code: AA",
			actual = assertFails { Country.forCode(CountryCode.parse("AA")) }.message
		)
	}


	@Test
	fun testForCodeString() {
		assertEquals(expected = "US", actual = Country.forCode("US").code.toString())
		assertEquals(expected = "US", actual = Country.forCode("us").code.toString())
		assertNull(Country.forCodeOrNull("aa"))
		assertNull(Country.forCodeOrNull("a1"))

		assertEquals(
			expected = "Invalid ISO 3166-1 alpha-2 country code: aa",
			actual = assertFails { Country.forCode("aa") }.message
		)
		assertEquals(
			expected = "Invalid ISO 3166-1 alpha-2 country code format: a1",
			actual = assertFails { Country.forCode("a1") }.message
		)
	}


	@Test
	fun testProperties() {
		val usCode = CountryCode.parse("US")
		val us = Country.forCode(usCode)

		assertEquals(expected = usCode, actual = us.code)
		assertEquals(expected = "US", actual = us.code(CountryCode.Format.iso3166_alpha2))
		assertEquals(expected = "USA", actual = us.code(CountryCode.Format.iso3166_alpha3))
		assertEquals(expected = "United States of America (the)", actual = us.name)
		assertEquals(expected = 840, actual = us.numericCode)
	}


	@Test
	fun testToString() {
		assertEquals(expected = "US", actual = Country.forCode("us").toString())
	}
}
