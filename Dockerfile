FROM openjdk:17-jdk-slim
LABEL authors="shruti"
COPY target/CaesarCipher-0.0.1-SNAPSHOT.jar /cipher.jar
# Expose the port on which the application will run
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/cipher.jar"]