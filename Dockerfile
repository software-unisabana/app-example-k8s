FROM amazoncorretto:21.0.1
COPY build/libs/*.jar /app/example.jar
CMD ["java", "-jar", "/app/example.jar"]