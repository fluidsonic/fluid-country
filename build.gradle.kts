import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.12"
}

fluidLibrary(name = "country", version = "0.9.1")

fluidLibraryModule(description = "Kotlin multiplatform country library") {
	targets {
		common {
			dependencies {
				implementation(kotlinx("serialization-core", "1.0.1"))
			}
		}

		darwin()
		js()
		jvm()
	}
}
