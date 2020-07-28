FROM openjdk:8
EXPOSE 8080
ADD target/rest-avalith.jar rest-avalith.jar
ENTRYPOINT ["java", "-jar", "/rest-avalith.jar"]