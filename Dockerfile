FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
COPY target/choice_of_name-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java","-jar","/app/app.jar"]