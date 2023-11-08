# Configurations
## JUL configuration
### Default configuration
- {-Djava.home}/conf/logging.properties
### Custom configration
- -Djava.util.logging.config.file
- -Djava.util.logging.config.class

## JCL configuration(LogFactory Configuration)
### org.apache.commons.logging.LogFactory
- org.apache.commons.logging.LogFactory[System Property]
- classpath:/META-INF/services/org.apache.commons.logging.LogFactory[Resource file, className]
- classpath:/commons-logging.properties["org.apache.commons.logging.LogFactory=*", priority=*]
- org.apache.commons.logging.impl.LogFactoryImpl[default log factory implementation]
### org.apache.commons.logging.diagnostics.dest
- org.apache.commons.logging.diagnostics.dest=STDOUT|STDERR[System Property]
### Other attributes
- classpath:/commons-logging.properties["org.apache.commons.logging.LogFactory=*", priority=*]

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
- org.apache.commons.logging.impl.LogFactoryImpl