# syntax=docker/dockerfile:1
FROM centos:centos7
FROM gradle:jdk8
COPY --chown=gradle:gradle . /opt
WORKDIR /opt
COPY gradle/ .gradle
COPY gradle .gradle
COPY gradlew settings.gradle build.gradle ./
RUN ./gradlew assemble
COPY src ./src
CMD ./gradlew bootRun --args='--spring.profiles.active=dev'