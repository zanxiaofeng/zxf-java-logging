# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a multi-module Maven project demonstrating Java logging frameworks and their integration patterns. The project showcases:
- Legacy logging frameworks (JUL, JCL, Log4j v1, Log4j v2)
- SLF4J facade pattern with different implementations (Logback, Log4j2)
- Spring Boot logging integration
- Bridge patterns for routing legacy logging calls to SLF4J

## Build and Run

### IMPORTANT: JDK Requirement

This project requires **JDK 21**. The system's default OpenJDK 21 (`/usr/lib/jvm/java-21-openjdk-amd64`) is JRE-only and lacks `javac`. Use the Microsoft JDK 21:

```bash
export JAVA_HOME=/home/davis/.jdks/ms-21.0.10
export PATH=$JAVA_HOME/bin:$PATH
```

### Build entire project
```bash
mvn clean install
```

### Build specific module
```bash
mvn clean install -pl zxf-java-logging-legacy
mvn clean install -pl zxf-java-logging-slf4j-logback
mvn clean install -pl zxf-java-logging-slf4j-log4j2
mvn clean install -pl zxf-java-logging-springboot
```

### Run test programs

**Legacy logging module** (JUL, JCL, Log4j v1, Log4j v2):
```bash
mvn exec:java -pl zxf-java-logging-legacy -Dexec.mainClass="zxf.logging.legacy.Tests"
```

**SLF4J + Logback module**:
```bash
mvn exec:java -pl zxf-java-logging-slf4j-logback -Dexec.mainClass="zxf.logging.slf4j2logback.Tests"
```

**SLF4J + Log4j2 module**:
```bash
mvn exec:java -pl zxf-java-logging-slf4j-log4j2 -Dexec.mainClass="zxf.logging.slf4j2log4j2.Tests"
```

**SLF4J API module**:
```bash
mvn exec:java -pl zxf-java-logging-sfl4j-api -Dexec.mainClass="zxf.logging.slf4japi.Tests"
```

**Spring Boot module**:
```bash
mvn spring-boot:run -pl zxf-java-logging-springboot
# Then access http://localhost:8080 for various logging demos
```

## Module Architecture

```
zxf-java-logging (parent)
├── zxf-java-logging-legacy        # JUL, JCL, Log4j v1/v2 implementations
├── zxf-java-logging-sfl4j-api     # SLF4J API facade only
├── zxf-java-logging-slf4j-logback # SLF4J + Logback with bridges
├── zxf-java-logging-slf4j-log4j2  # SLF4J + Log4j2 with bridges
└── zxf-java-logging-springboot    # Spring Boot logging integration
```

### Key Design Patterns

**Bridge Pattern**: The `slf4j-logback` and `slf4j-log4j2` modules use bridge dependencies to route calls from legacy frameworks (JUL, JCL, Log4j) through SLF4J to a single implementation. Bridge dependencies:
- `log4j-over-slf4j` - Log4j v1 calls → SLF4J
- `log4j-to-slf4j` - Log4j v2 calls → SLF4J
- `jul-to-slf4j` - JUL calls → SLF4J
- `jcl-over-slf4j` - JCL calls → SLF4J

**Provided Scope Pattern**: When using bridges, competing implementations are marked as `provided` to exclude them from the classpath at runtime, preventing conflicts.

## Logging Configuration Files

Each framework uses its own configuration file, located in `src/main/resources/`:

| Framework | Configuration File |
|-----------|-------------------|
| JUL | `jul.logging.properties` |
| Log4j v1 | `log4j.properties` or `log4j.xml` |
| Log4j v2 | `log4j2.xml`, `log4j2.properties`, `log4j2.system.properties` |
| Logback | `logback.xml` |
| Spring Boot | `application.yml` (logging prefix) |

## Dependency Management

The parent POM manages all logging library versions:
- `slf4jv2.version` = 2.0.17 (SLF4J v2)
- `log4j1.version` = 1.2.17
- `log4j2.version` = 2.25.1
- `logback.version` = 1.5.21
- `commons-logging.version` = 1.3.5

## Java Version

- Project uses **Java 21**
- Full JDK required: `/home/davis/.jdks/ms-21.0.10`
- Spring Boot 3.5.9 requires minimum Java 17 (fully supports Java 21)

## Spring Boot Logging

- Spring Boot version: 3.5.9
- Jakarta EE 9+ namespace (`jakarta.*`) is used (not `javax.*`)
- Spring Boot uses Commons Logging internally but defaults to Logback via `spring-boot-starter-logging`. To use Log4j2 instead:
1. Exclude `spring-boot-starter-logging` from `spring-boot-starter-web`
2. Add `spring-boot-starter-log4j2`

These starters cannot coexist - choose one implementation.
