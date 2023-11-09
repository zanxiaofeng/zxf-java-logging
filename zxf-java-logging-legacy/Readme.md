# Configurations
## JUL configuration
### Default configuration
- {-D:java.home}/conf/logging.properties
### Custom configration
- java.util.logging.config.file[System Property]
- java.util.logging.config.class[System Property]

## JCL configuration
### org.apache.commons.logging.LogFactory
- org.apache.commons.logging.LogFactory=*******[System Property]
- classpath:/META-INF/services/org.apache.commons.logging.LogFactory[Resource file, className]
- classpath:/commons-logging.properties["org.apache.commons.logging.LogFactory=*", priority=*]
- org.apache.commons.logging.impl.LogFactoryImpl[default log factory implementation]
### org.apache.commons.logging.diagnostics.dest
- org.apache.commons.logging.diagnostics.dest=STDOUT|STDERR[System Property]
### org.apache.commons.logging.Log
- org.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog[Attribute]
- org.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog[System Property]
### Other attributes
- classpath:/commons-logging.properties["org.apache.commons.logging.LogFactory=*", priority=*]

## Log4j V1 configuration
### Default configuration
- classpath:/log4j.xml
- classpath:/log4j.properties
### Custom configration
- log4j.configuration[System Property]
- log4j.configuratorClass[System Property]

## Log4j V2 configuration


# Key Classes
## JUL Key Classes
- java.util.logging.Logger
- java.util.logging.Handler
- java.util.logging.FileHandler
- java.util.logging.ConsoleHandler
- java.util.logging.Formatter
- java.util.logging.SimpleFormatter
- java.util.logging.XMLFormatter
## JCL Key Classes
- org.apache.commons.logging.Log
- org.apache.commons.logging.LogFactory.getLog(<class>)
- org.apache.commons.logging.impl.LogFactoryImpl.discoverLogImplementation(String logCategory)
## Log4j V1 Key Classes
- org.apache.log4j.Level
- org.apache.log4j.Logger
- org.apache.log4j.LogManager
- org.apache.log4j.MDC
- org.apache.log4j.Appender
- org.apache.log4j.ConsoleAppender
- org.apache.log4j.FileAppender
- org.apache.log4j.spi.Configurator
- org.apache.log4j.PropertyConfigurator.PropertyConfigurator
- org.apache.log4j.xml.DOMConfigurator

## Log4j V2 Key Classes


