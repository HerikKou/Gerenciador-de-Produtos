# === Estágio 1: Build com Maven ===
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

COPY Produto/pom.xml .
RUN mvn dependency:go-offline -B

COPY Produto/src ./src
RUN mvn clean package -DskipTests

# === Estágio 2: Imagem final para rodar o Java ===
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/target/*.jar ./app.jar
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
