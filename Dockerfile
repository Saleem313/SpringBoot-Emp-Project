FROM java:8-jdk-alpine
WORKDIR /usr/app
COPY  /target/SpringBoot-Emp-Project-0.0.1-SNAPSHOT.jar  ${WORKDIR}
EXPOSE 7070
CMD ["java","-jar", "SpringBoot-Emp-Project-0.0.1-SNAPSHOT.jar"]