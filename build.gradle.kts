import io.fluidsonic.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.23"
}

fluidLibrary(name = "country", version = "0.9.5")

fluidLibraryModule(description = "Kotlin multiplatform country library") {
	targets {
		common {
			dependencies {
				implementation(kotlinx("serialization-core", "1.2.1"))
			}
		}

		darwin()
		js(KotlinJsCompilerType.BOTH)
		jvm()
	}
}
