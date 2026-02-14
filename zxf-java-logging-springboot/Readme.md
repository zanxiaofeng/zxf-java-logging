# Description
- Spring Boot uses Commons Logging for all internal logging but leaves the underlying log implementation open. Default configurations are provided for Java Util Logging, Log4J2, and Logback. In each case, loggers are pre-configured to use console output with optional file output also available.
- By default, if you use the “Starters”, Logback is used for logging. Appropriate Logback routing is also included to ensure that dependent libraries that use Java Util Logging, Commons Logging, Log4J, or SLF4J all work correctly.


# Log相关的Starter及使用原则
- spring-boot-starter-logging以logback作为日志实现
- spring-boot-starter-log4j2以Log4j2作为日志实现
- 两个Starter不能并存，只能二选其一
- 除了从这两个Starter引入的log库外，其他地方引入log库一律排除（jboss-logging除外）

# spring-boot-starter-loggin
- spring-boot-starter-logging由spring-boot-starter-web引入
- spring-boot-starter-logging会引入logback-classic作为日志实现
- spring-boot-starter-logging会引入log4j-to-slf4j，jul-to-slf4j作为日志桥接
- spring-jcl由spring-core引入，用于在spring框架中替代commons-logging

# Default config
- spring-boot-2.7.18.jar!/org/springframework/boot/logging/logback/defaults.xml
- spring-boot-2.7.18.jar!/org/springframework/boot/logging/log4j2/log4j2.xml
- spring-boot-2.7.18.jar!/org/springframework/boot/logging/java/logging.properties