FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/eureka-server.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app.jar"]
