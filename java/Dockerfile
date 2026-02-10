FROM maven:3.9.0-eclipse-temurin as build
WORKDIR /usr/src/app
COPY . /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM eclipse-temurin:22.0.2_9-jdk-jammy
WORKDIR /usr/src/app

COPY --from=build /usr/src/app/target/azure-0.0.1-SNAPSHOT.jar azure-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "azure-0.0.1-SNAPSHOT.jar" ]