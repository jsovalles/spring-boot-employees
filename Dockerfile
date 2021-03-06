FROM adoptopenjdk/openjdk11:latest

COPY ./target/employees-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch employees-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","employees-0.0.1-SNAPSHOT.jar"]