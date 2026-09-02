# ==========================================
# Stage 1: Build the application
# ==========================================
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copy the Gradle wrapper and build files first to leverage Docker caching
COPY gradlew .
COPY gradle gradle
COPY build.gradle .

# Ensure the Gradle wrapper has execution permissions
RUN chmod +x gradlew

# Download dependencies (caches this layer so builds are faster later)
RUN ./gradlew dependencies --no-daemon

# Copy the actual source code
COPY src src

# Compile the application and skip tests
RUN ./gradlew clean build -x test --no-daemon

# ==========================================
# Stage 2: Create the lean runtime image
# ==========================================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy ONLY the built JAR file from the 'builder' stage
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]