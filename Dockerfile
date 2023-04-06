######### Stage 1 #########
# First stage: complete build environment
FROM maven:3.8.3-openjdk-17 AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

######### Stage 2 #########
# Second stage: minimal runtime environment
FROM openjdk:17-slim

# copy jar from the first stage
COPY --from=builder target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]