FROM openjdk:17

WORKDIR /app

COPY /target/barook-app.jar /app
CMD ["java", "-jar", "barook-app.jar"]