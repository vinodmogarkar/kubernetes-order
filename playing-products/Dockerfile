FROM openjdk:11

RUN mkdir /opt/playing-products

ENV DEPLOYMENT_JAR /opt/playing-products

COPY target/playing-products.jar $DEPLOYMENT_JAR

ENTRYPOINT exec java -jar $DEPLOYMENT_JAR/playing-products.jar
