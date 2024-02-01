FROM ubuntu:14.04

WORKDIR /workspace

COPY jdk /workspace/jdk

# pwd is example/helloJava
COPY target/helloJava-1.0-SNAPSHOT.jar  /workspace


ARG JAVA_HOME=/workspace/jdk
ENV JAVA_HOME=/workspace/jdk   PATH=$PATH:$JAVA_HOME/bin

CMD [ "java", "-jar","helloJava-1.0-SNAPSHOT.jar" ]
