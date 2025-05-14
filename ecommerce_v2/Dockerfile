FROM openjdk:17
ARG JAR_FILE=taget/*.jar
COPY ./target/ecommerce-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080


#FROM maven:lastest
#RUN mkdir /OBO
#WORKDIR /OBO
#COPY . .
#EXPOSE 8080
#CMD ["mvn", "spring-boot:run"]
