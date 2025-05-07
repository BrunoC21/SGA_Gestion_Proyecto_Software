FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/app.jar"]