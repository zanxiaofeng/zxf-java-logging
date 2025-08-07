# Description
- Spring Boot uses Commons Logging for all internal logging but leaves the underlying log implementation open. Default configurations are provided for Java Util Logging, Log4J2, and Logback. In each case, loggers are pre-configured to use console output with optional file output also available.
- By default, if you use the “Starters”, Logback is used for logging. Appropriate Logback routing is also included to ensure that dependent libraries that use Java Util Logging, Commons Logging, Log4J, or SLF4J all work correctly.

# Default config
- spring-boot-2.7.18.jar!/org/springframework/boot/logging/logback/defaults.xml
- spring-boot-2.7.18.jar!/org/springframework/boot/logging/log4j2/log4j2.xml
- spring-boot-2.7.18.jar!/org/springframework/boot/logging/java/logging.properties