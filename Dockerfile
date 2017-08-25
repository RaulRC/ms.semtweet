FROM centos:latest
MAINTAINER Raul Reguillo raul.reguillo@gmail.com
RUN yum update -y && \
yum install -y which wget git java-1.8.0-openjdk && yum clean all
ENV JAVA_HOME /usr/lib/jvm/jre-1.8.0-openjdk
ENV SEMTWEET_HTTP_INTERFACE 0.0.0.0
ENV SEMTWEET_HTTP_PORT 9003

ADD /target/ms.semtweet-1.0-SNAPSHOT-allinone.jar ms.semtweet-1.0-SNAPSHOT-allinone.jar

EXPOSE 9003
ENTRYPOINT ["java", "-jar", "ms.semtweet-1.0-SNAPSHOT-allinone.jar"]
