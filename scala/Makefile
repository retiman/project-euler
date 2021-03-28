IMAGE := 2.11.12-debian10.8-slim
.PHONY = image

# NOTE: There is no official image.  We'll have to build it ourselves.
image:
	docker build --tag retiman/scala:${IMAGE} .

# Running Scala without -nobootcp and -nc causes some issues.
#
# See https://github.com/scala/bug/issues/10603
%: %.scala
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../.data:/data" \
		--workdir /src \
		retiman/scala:${IMAGE} \
		scala -nobootcp -nc -feature -deprecation $<
