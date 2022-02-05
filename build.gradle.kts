import io.fluidsonic.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.25"
}

fluidLibrary(name = "country", version = "0.11.0")

fluidLibraryModule(description = "Kotlin multiplatform country library") {
	targets {
		common {
			dependencies {
				implementation(kotlinx("serialization-core", "1.3.2"))
			}
		}

		darwin()
		js(KotlinJsCompilerType.BOTH)
		jvm()
	}
}
