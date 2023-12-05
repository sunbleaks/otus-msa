FROM eclipse-temurin:17-jdk-alpine
RUN apk --no-cache add curl
COPY target/*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app.jar"]