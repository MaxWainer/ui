plugins {
  java
}

allprojects {
  apply {
    plugin("java")
  }

  repositories {
    mavenCentral()
    maven { setUrl("https://repo.codemc.org/repository/nms/") }
  }

  dependencies {
    implementation("org.jetbrains:annotations:20.1.0")
  }
}