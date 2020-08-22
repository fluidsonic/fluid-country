package io.fluidsonic.country


/**
 * An ISO 3166-1 alpha-2 country code, for example `US` or `DE`.
 *
 * References:
 * - [https://www.iso.org/iso-3166-country-codes.html]
 * - [https://www.iso.org/obp/ui/]
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS", "UNUSED_PARAMETER")
public inline class CountryCode @PublishedApi internal constructor(private val value: String) {

	public fun isValid(): Boolean =
		Country.forCodeOrNull(this) != null


	override fun toString(): String =
		value


	public companion object {

		public fun parse(string: String): CountryCode =
			parseOrNull(string) ?: error("Invalid ISO 3166-1 alpha-2 country code format: $string")


		public fun parseOrNull(string: String): CountryCode? =
			string
				.takeIf(this::isValidFormat)
				?.let { CountryCode(value = it.toUpperCase()) }


		private fun isValidFormat(string: String) =
			string.length == 2 &&
				string[0].isLatinLetter() &&
				string[1].isLatinLetter()
	}


	public enum class Format {

		iso3166_alpha2,
		iso3166_alpha3
	}
}
