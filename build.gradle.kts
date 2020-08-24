import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.7"
}

fluidLibrary(name = "country", version = "0.9.1")

fluidLibraryModule(description = "Kotlin multiplatform country library") {
	targets {
		darwin()
		js()
		jvm()
	}
}
