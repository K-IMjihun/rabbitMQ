FROM jenkins/jenkins:jdk17

USER root
RUN apt-get update &&\
    apt-get upgrade -y &&\
    # 빌드가 완료된 프로젝트를 Jenkins(컨테이너) 외부의 서버에서 실행시켜야 하기 때문에
    # ssh 를 통해 서버에 접속해 빌드된 프로젝트를 실행시키는 방법을 사용하기 위함
    apt-get install -y openssh-client