plugins {
	id("org.springframework.boot") version "3.3.1-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("plugin.jpa") version "1.9.21"
	kotlin("jvm") version "1.9.21"
	kotlin("plugin.spring") version "1.9.21"
	id("io.gitlab.arturbosch.detekt") version "1.23.4"
}

group = "br.com.rssdev"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(19)
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("com.h2database:h2")
	implementation("org.flywaydb:flyway-core")

	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.springframework.boot:spring-boot-starter-actuator")

	testImplementation("io.mockk:mockk:1.12.4")

	detekt("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.4")
	detekt("io.gitlab.arturbosch.detekt:detekt-cli:1.23.4")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

detekt {
	toolVersion = "1.23.4"
	source.setFrom(files("./"))
	config.setFrom(files("./detekt-config.yml"))
	autoCorrect = true
}
