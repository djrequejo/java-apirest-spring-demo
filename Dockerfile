# Use a base image with Maven installed
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Download all dependencies. Dependencies will be cached if the pom.xml is not changed
RUN mvn dependency:go-offline -B

# Copy the project source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a lightweight base image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage to the container
COPY --from=build /app/target/*.jar app.jar

# Specify the command to run the application
CMD ["java", "-jar", "app.jar"]
