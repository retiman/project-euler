FROM debian:10.8-slim
# This missing directory will cause docker build to fail.
#
# See https://github.com/geerlingguy/ansible-role-java/issues/64
RUN mkdir /usr/share/man/man1/
RUN apt-get update
RUN apt-get install -y scala
