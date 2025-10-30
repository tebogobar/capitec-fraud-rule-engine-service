FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
COPY target/capitec-fraud-rule-engine-service-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]