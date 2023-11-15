# Purge local repository by command
## Delete a specified artifact-version by include
- mvn dependency:purge-local-repository -Dinclude=org.apache.logging.log4j:log4j-api -DreResolve=false -Dverbose=true
## Delete all artifact-versions of a specified group of by include
- mvn dependency:purge-local-repository -Dinclude=org.apache.logging.log4j -DreResolve=false -Dverbose=true
## Delete a specified version of an artifact by manualInclude
- mvn dependency:purge-local-repository -X -DmanualInclude=org.apache.logging.log4j:log4j-api:2.17.2 -DreResolve=false -Dverbose=true
## Delete all versions of a specified artifact by manualInclude
- mvn dependency:purge-local-repository -X -DmanualInclude=org.apache.logging.log4j:log4j-api:2.17.2 -DreResolve=false -Dverbose=true
## Delete all artifacts and versions of a specified group by manualInclude
- mvn dependency:purge-local-repository -X -DmanualInclude=org.apache.logging.log4j -DreResolve=false -Dverbose=true

# Source Code
- https://github.com/apache/maven-dependency-plugin
- https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project/spring-boot-tools/spring-boot-maven-plugin
- https://github.com/apache/maven