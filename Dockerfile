FROM openjdk:21-jdk

ENV TZ=Asia/Manila

WORKDIR /app

COPY target/discuss-hub-1.0.jar /app/discuss-hub.jar

EXPOSE 8080

CMD ["java", "-jar", "discuss-hub.jar"]
