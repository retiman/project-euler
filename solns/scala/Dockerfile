FROM debian:10.8-slim
# This missing directory will cause docker build to fail.
#
# See https://github.com/geerlingguy/ansible-role-java/issues/64
RUN mkdir /usr/share/man/man1/ \
    && apt-get update \
    && apt-get install --no-install-recommends -y scala=2.11.12-4 \
    && rm -rf /var/lib/apt/lists/*
