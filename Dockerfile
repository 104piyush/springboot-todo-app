FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/Springmvc-1.0.jar"]

