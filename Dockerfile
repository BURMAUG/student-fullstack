FROM openjdk:22-bullseye

WORKDIR /student

COPY /build/libs/amigosstudent-0.0.1-SNAPSHOT.jar /student

EXPOSE 8080

CMD ["java", "-jar", "amigosstudent-0.0.1-SNAPSHOT.jar"]