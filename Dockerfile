FROM openjdk:11

COPY ./target/spring-websocket-example-0.0.1-SNAPSHOT.jar /service/app.jar

WORKDIR /service

CMD ["java", "-jar", "app.jar"]