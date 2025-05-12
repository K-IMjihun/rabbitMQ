# Jenkins 기본 이미지 (JDK 17 포함)
FROM jenkins/jenkins:jdk17

# 루트 권한으로 SSH 클라이언트 설치
USER root
RUN apt-get update && \
    apt-get install -y openssh-client && \
    rm -rf /var/lib/apt/lists/*

# 기본 Jenkins 사용자로 복귀
USER jenkins