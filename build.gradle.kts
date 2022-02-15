repositories {
  mavenCentral()
  maven("https://jitpack.io")
}
plugins {
  kotlin("jvm") version "1.6.20-M1"
  id("com.palantir.graal") version "0.10.0"
}
dependencies {
  implementation("com.google.code.gson:gson:2.9.0")
  implementation("com.github.sisyphsu:dateparser:1.0.9")
  implementation("com.github.vidstige:jadb:v1.2.1")
  implementation("com.github.ajalt.clikt:clikt:3.4.0")
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
  testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
  testImplementation("io.mockk:mockk:1.12.2")
}
tasks.compileKotlin {
  kotlinOptions.jvmTarget = "17"
}
tasks.compileTestKotlin {
  kotlinOptions.jvmTarget = "17"
}
tasks.test {
  useJUnitPlatform()
}
graal {
  graalVersion("21.3.0")
  javaVersion("17")
  mainClass("MainKt")
  outputName(projectDir.name)
  option("--no-fallback")
  windowsVsVarsPath("C:\\Program Files\\Microsoft Visual Studio\\2022\\Enterprise\\VC\\Auxiliary\\Build\\vcvars64.bat")
}
tasks.build {
  dependsOn(tasks.nativeImage)
}
