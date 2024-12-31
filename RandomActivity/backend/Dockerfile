#oficjalny obraz Javy
FROM openjdk:17-jdk-slim-bullseye

#katalog roboczy
WORKDIR /app

#Kopia pliku JAR aplikacji
COPY target/RandomActivity-0.0.1-SNAPSHOT.jar app.jar

#port aplikacji
EXPOSE 8080

#Komenda uruchamiajaca aplikacje
ENTRYPOINT ["java", "-jar", "app.jar"]