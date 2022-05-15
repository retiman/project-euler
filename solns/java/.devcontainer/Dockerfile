# syntax=docker/dockerfile:1.4
FROM openjdk:17-slim-buster

WORKDIR /
ADD .devcontainer/devcontainer.sh devcontainer.sh
ADD .devcontainer/prompt.sh prompt.sh

RUN <<EOF
sh devcontainer.sh
rm devcontainer.sh
rm prompt.sh
EOF
