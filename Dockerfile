FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .

# Эта команда покажет в логах, где лежат файлы (для отладки)
RUN ls -laR

# Если твой pom.xml внутри папки, Docker найдет его сам
RUN mvn clean package -DskipTests -f **/pom.xml

FROM eclipse-temurin:21-jre
WORKDIR /app
# Ищем jar файл где бы он ни создался
COPY --from=build /app/**/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]