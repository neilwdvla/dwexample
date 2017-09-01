FROM maven:3.3.9-jdk-8

RUN mkdir -p /code
ADD . /code
WORKDIR /code

RUN bash -c "mvn -e package"