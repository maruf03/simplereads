# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-17-alpine AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Package the Spring Boot application (runs 'mvn clean package')
RUN mvn clean package -DskipTests

# Stage 2: Create a minimal runtime image
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port on which the Spring Boot application will run
EXPOSE 5000

# Set the default command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
