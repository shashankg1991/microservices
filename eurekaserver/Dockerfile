FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/eurekaserver-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/eurekaserver-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]
EXPOSE 8761