FROM openjdk:8-jdk-alpine
EXPOSE 8081
COPY target/soft-ib-core-0.0.1-SNAPSHOT.war soft-ib-core-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/soft-ib-core-0.0.1-SNAPSHOT.war"]