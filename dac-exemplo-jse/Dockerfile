FROM maven:3.3.9-jdk-8
ADD target/dac-exemplo-jse-jar-with-dependencies.jar /opt/app/
RUN chmod +x /opt/app/
ENTRYPOINT ["java", "-jar", "/opt/app/dac-exemplo-jse-jar-with-dependencies.jar"]