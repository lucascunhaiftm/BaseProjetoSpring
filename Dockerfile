FROM openjdk
WORKDIR /app
COPY target/appBase-0.0.1-SNAPSHOT.jar /app/meuapp.jar
ENTRYPOINT ["java", "-jar", "meuapp.jar"] 