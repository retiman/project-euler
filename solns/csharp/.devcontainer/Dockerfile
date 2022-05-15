# syntax=docker/dockerfile:1.4
FROM mcr.microsoft.com/dotnet/sdk:5.0.202-buster-slim

WORKDIR /
ADD .devcontainer/devcontainer.sh devcontainer.sh
ADD .devcontainer/prompt.sh prompt.sh

RUN <<EOF
sh devcontainer.sh
rm devcontainer.sh
rm prompt.sh
EOF
