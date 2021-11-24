FROM openjdk:17-jdk-alpine
ARG JAR_FILE = tarjet/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
CMD gunicorn --bind 0.0.0.0:$PORT wsgi