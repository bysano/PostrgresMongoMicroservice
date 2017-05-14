FROM java:8
VOLUME /tmp
ADD config-microservices-1.5.2.RELEASE.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]