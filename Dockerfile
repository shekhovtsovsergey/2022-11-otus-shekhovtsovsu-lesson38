FROM maven:3.8.3-jdk-11-slim AS build
COPY . /app
WORKDIR /app
RUN mvn package
FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]