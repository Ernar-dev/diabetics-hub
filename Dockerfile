# Этап 1: Сборка проекта
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Этап 2: Запуск собранного приложения
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Стандартная команда запуска Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]