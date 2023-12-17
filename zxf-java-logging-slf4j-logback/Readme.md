# Configurations
- logback.configurationFile[System Property]
- logback.debug[System Property]
- classpath:logback.xml
- classpath:logback-test.xml

# Key Classes
- ch.qos.logback.classic.Logger
- org.slf4j.impl.StaticMDCBinder
- org.slf4j.impl.StaticLoggerBinder
- ch.qos.logback.classic.LoggerContext
- ch.qos.logback.classic.BasicConfigurator[Console]
- ch.qos.logback.classic.joran.JoranConfigurator[logback.xml]
- ch.qos.logback.classic.joran.action.ConfigurationAction
- ch.qos.logback.classic.util.ContextInitializer[init]
- ch.qos.logback.core.status.StatusListener[interface]
- ch.qos.logback.core.status.OnConsoleStatusListener
- ch.qos.logback.core.status.OnErrorConsoleStatusListener
- ch.qos.logback.core.status.NopStatusListener
- ch.qos.logback.core.status.StatusManager[interface]
- ch.qos.logback.core.BasicStatusManager