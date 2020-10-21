plugins {
    java
}

group = "it.cngei"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    val jbossLoggingVersion = "3.4.1.Final"
    val keycloakVersion = "11.0.2"

    // BCrypt
    implementation("commons-codec:commons-codec:1.15")
    testImplementation("junit:junit:4.13")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")

    // JBoss
    compileOnly("org.jboss.logging:jboss-logging:$jbossLoggingVersion")
    testImplementation("org.jboss.logging:jboss-logging:$jbossLoggingVersion")

    // Keycloak
    compileOnly("org.keycloak:keycloak-common:$keycloakVersion")
    compileOnly("org.keycloak:keycloak-core:$keycloakVersion")
    compileOnly("org.keycloak:keycloak-server-spi:$keycloakVersion")
    compileOnly("org.keycloak:keycloak-server-spi-private:$keycloakVersion")
    testImplementation("org.keycloak:keycloak-common:$keycloakVersion")
    testImplementation("org.keycloak:keycloak-core:$keycloakVersion")
    testImplementation("org.keycloak:keycloak-server-spi:$keycloakVersion")
    testImplementation("org.keycloak:keycloak-server-spi-private:$keycloakVersion")
    testImplementation("org.keycloak:keycloak-core:$keycloakVersion")
    testImplementation("org.keycloak:keycloak-server-spi:$keycloakVersion")
    testImplementation("org.keycloak:keycloak-common:$keycloakVersion")
    testImplementation("org.keycloak:keycloak-server-spi-private:$keycloakVersion")
}

tasks {
    jar {
        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }) {
            exclude("META-INF/MANIFEST.MF")
            exclude("META-INF/*.SF")
            exclude("META-INF/*.DSA")
            exclude("META-INF/*.RSA")
        }
    }

    wrapper {
        gradleVersion = "6.4"
    }
}

tasks.test {
    useJUnit()
    useJUnitPlatform()

    maxHeapSize = "1G"
}