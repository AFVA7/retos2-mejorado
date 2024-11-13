FROM jenkins/jenkins:lts

USER root

# Instala git, docker y otros paquetes necesarios
RUN apt-get update && \
    apt-get install -y git docker.io

USER jenkins

docker build -t jenkins-custom .

docker run -d -p 8080:8080 -p 50000:50000 --name jenkins-container -v jenkins_home:/var/jenkins_home jenkins-custom
