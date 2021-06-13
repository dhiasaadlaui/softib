FROM openjdk:8-jdk-alpine
EXPOSE 8081
COPY target/soft-ib-0.0.1-SNAPSHOT.war soft-ib-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/soft-ib-0.0.1-SNAPSHOT.war"]