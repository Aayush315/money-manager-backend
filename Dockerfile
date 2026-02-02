FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# Fix permission for mvnw
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# ✅ FIX: use exact jar name (NO wildcard)
CMD ["java", "-jar", "target/money-manager-backend-0.0.1-SNAPSHOT.jar"]
