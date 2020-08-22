package io.fluidsonic.country


internal fun Char.isLatinLetter() =
	this in 'a' .. 'z' || this in 'A' .. 'Z'
