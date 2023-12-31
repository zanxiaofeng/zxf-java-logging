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
- classpath:META-INF/services/org.apache.commons.logging.LogFactory[Resource file, className]
- classpath:commons-logging.properties["org.apache.commons.logging.LogFactory=*", priority=*]
- org.apache.commons.logging.impl.LogFactoryImpl[default log factory implementation]
### org.apache.commons.logging.diagnostics.dest
- org.apache.commons.logging.diagnostics.dest=STDOUT|STDERR[System Property]
### org.apache.commons.logging.Log
- org.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog[Attribute]
- org.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog[System Property]
### Other attributes
- classpath:/commons-logging.properties["org.apache.commons.logging.LogFactory=*", priority=*]

## Log4j V1 configuration
### Configuration file selection
#### Default configuration file
- classpath:log4j.xml
- classpath:log4j.properties
#### Custom configration file
- log4j.configuration[System Property]
### Configuration class selection
1. From log4j.configuratorClass[System Property]
2. org.apache.log4j.xml.DOMConfigurator[if fileName end with .xml]
3. org.apache.log4j.PropertyConfigurator.PropertyConfigurator

## Log4j V2 configuration
### Supported Property Keys
- log4j2.loggerContextFactory=****[Property]
- log4j2.debug=false[Property]
- Log4jContextSelector=****[Property]
- log4j.configurationFactory=*****[Property]
- log4j.configurationFile=*****[Property]
### System Properties
- Include Supported Property Keys
### classpath:log4j2.system.properties
- Include Supported Property Keys
### classpath:log4j2.component.properties
- Include Supported Property Keys

# Key Classes

## JUL Key Classes
- java.util.logging.Logger
- java.util.logging.LogManager
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
- org.apache.logging.log4j.Logger;
- org.apache.logging.log4j.LogManager;
- org.apache.logging.log4j.ThreadContext
- org.apache.logging.log4j.util.ProviderUtil
- org.apache.logging.log4j.util.PropertiesUtil
- org.apache.logging.log4j.util.PropertiesUtil.Environment
- org.apache.logging.log4j.spi.LoggerContextFactory[log4j-api, interface]
- org.apache.logging.log4j.simple.SimpleLoggerContextFactory[log4j-api]
- org.apache.logging.slf4j.SLF4JLoggerContextFactory[log4j-to-slf4j]
- org.apache.logging.log4j.core.impl.Log4jContextFactory[log4j-core]
- org.apache.logging.log4j.core.config.ConfigurationFactory(ConfigurationFactory getInstance())
- org.apache.logging.log4j.core.config.ConfigurationFactory.Factory(Configuration getConfiguration(****))
- org.apache.logging.log4j.core.config.properties.PropertiesConfigurationFactory[log4j2.properties]
- org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory[log4j2.xml]
- org.apache.logging.log4j.core.config.json.JsonConfigurationFactory[log4j2.json,log4j2.jsn]
- org.apache.logging.log4j.core.config.yaml.YamlConfigurationFactory[log4j2.yml,log4j2.yaml]
