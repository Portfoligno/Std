plugins {
  maven
  `java-library`
  kotlin("jvm") version "1.3.0"
}
tasks.withType<Wrapper> {
  gradleVersion = "4.10.2"
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_6
  targetCompatibility = JavaVersion.VERSION_1_6
}

repositories {
  jcenter()
}
dependencies {
  compileOnly("org.jetbrains:annotations:16.0.3")

  testImplementation(kotlin("stdlib"))
  testImplementation("io.kotlintest:kotlintest-runner-junit5:3.1.10")
}
