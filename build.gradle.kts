plugins {
  maven
  `java-library`
}
tasks.withType<Wrapper> {
  gradleVersion = "4.10"
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_6
  targetCompatibility = JavaVersion.VERSION_1_6
}

repositories {
  jcenter()
}
dependencies {
  compileOnly("org.jetbrains:annotations:16.0.2")
}
