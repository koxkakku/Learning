FROM openjdk:17
VOLUME /tmp
COPY target/custom-api-gateway-0.0.1-SNAPSHOT.jar custom-api-gateway-1.0.0.jar
ENTRYPOINT ["java","-jar","/custom-api-gateway-1.0.0.jar"]