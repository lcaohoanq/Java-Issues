FROM tomcat:8.5-jdk8
LABEL maintainer="hoangclw@gmail.com"

ADD ./dist/WS2.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
