IMAGE := 2.11.12-debian10.8-slim
PWD := $(shell pwd)
.PHONY = image

# NOTE: There is no official image.  We'll have to build it ourselves.
# See https://github.com/geerlingguy/ansible-role-java/issues/64
image:
	docker build --tag retiman/scala:${IMAGE} .

# See https://github.com/scala/bug/issues/10603
%: %.scala
	docker run \
		--pull missing \
		--rm \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		retiman/scala:${IMAGE} \
		scala -nobootcp -nc -feature -deprecation $<
