FROM gradle AS build

ARG CACHEBUST=1

WORKDIR /student

COPY src ./src

COPY build.gradle settings.gradle  ./

RUN gradle build -x test > /dev/null

FROM openjdk:22-bullseye

COPY --from=build /student/build/libs/amigosstudent-0.0.1-SNAPSHOT.jar ./amigosstudent-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "amigosstudent-0.0.1-SNAPSHOT.jar"]