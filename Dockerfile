FROM eclipse-temurin:21-jdk-slim as build
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]