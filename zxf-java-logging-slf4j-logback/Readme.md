# Configurations
- logback.configurationFile[System Property]
- classpath:logback.xml
- classpath:logback-test.xml

# Key Classes
- ch.qos.logback.classic.Logger
- org.slf4j.impl.StaticMDCBinder
- org.slf4j.impl.StaticLoggerBinder
- ch.qos.logback.classic.LoggerContext
- ch.qos.logback.classic.BasicConfigurator[Console]
- ch.qos.logback.classic.joran.JoranConfigurator[logback.xml]
- ch.qos.logback.classic.util.ContextInitializer[init]