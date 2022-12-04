FROM adoptopenjdk/openjdk11
EXPOSE 8080
ADD /target/forum-1.0.0.jar forum.jar
ENTRYPOINT ["java", "$JAVA_OPTS -XX:+UseContainerSupport", "-Xmx300m -Xss512k -XX:CICompilerCount=2", "-Dserver.port=$PORT", "-Dspring.profiles.active=prd", "-jar", "forum.jar"]
