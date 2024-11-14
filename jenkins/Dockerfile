FROM jenkins/jenkins:lts

USER root

# Instala git, docker y otros paquetes necesarios
RUN apt-get update && \
    apt-get install -y git docker.io

USER jenkins
