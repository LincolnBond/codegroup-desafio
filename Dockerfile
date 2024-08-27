FROM maven:3.8.3-openjdk-17 AS build
COPY src ../desafio/src
COPY pom.xml ../desafio/
RUN mvn clean install -DskipTests
RUN mvn -f ../desafio/pom.xml clean package

FROM openjdk:17-alpine
EXPOSE 8080
COPY src/main/resources/application.properties /app/src/main/resources/application.properties
ADD target/desafio-0.0.1-SNAPSHOT.jar app.war
ENTRYPOINT ["java","-jar","app.war"]