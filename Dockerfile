FROM openjdk:11
COPY target/lab3-risk-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]