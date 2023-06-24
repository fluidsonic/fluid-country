import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.3.1"
}

fluidLibrary(name = "country", version = "0.13.0")

fluidLibraryModule(description = "Kotlin multiplatform country library") {
	targets {
		common {
			dependencies {
				implementation(kotlinx("serialization-core", "1.5.1"))
			}
		}

		darwin()
		js()
		jvm()
	}
}
