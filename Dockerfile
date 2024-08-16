FROM amazoncorretto:21.0.1
COPY build/libs/otrodemo-0.0.1-SNAPSHOT.jar /app/example.jar
CMD ["java", "-jar", "/app/example.jar"]