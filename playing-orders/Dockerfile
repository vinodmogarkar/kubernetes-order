FROM openjdk:11

RUN mkdir /opt/playing-orders

ENV DEPLOYMENT_JAR /opt/playing-orders

COPY target/playing-orders.jar $DEPLOYMENT_JAR

ENTRYPOINT exec java -jar $DEPLOYMENT_JAR/playing-orders.jar
