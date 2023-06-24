package io.fluidsonic.country

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*


/**
 * An ISO 3166-1 alpha-2 country code, for example `US` or `DE`.
 *
 * References:
 * - [https://www.iso.org/iso-3166-country-codes.html]
 * - [https://www.iso.org/obp/ui/]
 */
@Serializable(CountryCodeSerializer::class)
public class CountryCode internal constructor(private val value: String) {

	override fun equals(other: Any?): Boolean =
		this === other || (other is CountryCode && value == other.value)


	override fun hashCode(): Int =
		value.hashCode()


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
				?.let { CountryCode(value = it.uppercase()) }


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


@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = CountryCode::class)
internal object CountryCodeSerializer : KSerializer<CountryCode> {

	override val descriptor: SerialDescriptor =
		PrimitiveSerialDescriptor("io.fluidsonic.country.CountryCode", PrimitiveKind.STRING)


	override fun serialize(encoder: Encoder, value: CountryCode) {
		encoder.encodeString(value.toString())
	}


	override fun deserialize(decoder: Decoder): CountryCode =
		CountryCode.parse(decoder.decodeString())
}
