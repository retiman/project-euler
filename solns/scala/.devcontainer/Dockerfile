# syntax=docker/dockerfile:1.4
FROM debian:10.8-slim

# This missing directory will cause docker build to fail.
#
# See https://github.com/geerlingguy/ansible-role-java/issues/64
RUN <<EOF
mkdir -p /usr/share/man/man1/
apt-get update
apt-get install --no-install-recommends -y scala=2.11.12-4
EOF

WORKDIR /
ADD .devcontainer/devcontainer.sh devcontainer.sh
ADD .devcontainer/prompt.sh prompt.sh

RUN <<EOF
sh devcontainer.sh
rm devcontainer.sh
rm prompt.sh
EOF
