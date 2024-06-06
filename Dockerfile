#
#FROM openjdk:17-jdk-alpine
##ARG JAR_FILE=target/*.jar
#COPY ./target/BookingHotel-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

## Đặt biến môi trường active profile (optional)
#ENV SPRING_PROFILES_ACTIVE docker

# Use the official image as a parent image
FROM openjdk:17-jdk-slim
#FROM openjdk:23-ea-17-jdk-bullseye
# Set the working directory
WORKDIR /app
# COPY FROM HOST SENT TO CONTAINER
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# RUN INSIDE IMAGE: DE DOWNLOAD CAC DEPENDENCY
RUN ./mvnw dependency:go-offline
COPY src ./src
# RUN INSIDE CONTAINER
CMD ["./mvnw","spring-boot:run"]
