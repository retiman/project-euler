IMAGE := 2.11.12-debian10.8-slim

# NOTE: There is no official image.  We'll have to build it ourselves.
.PHONY = image
image:
	docker build -f .devcontainer/Dockerfile --tag retiman/scala:${IMAGE} .

# Running Scala without -nobootcp and -nc causes some issues.
#
# See https://github.com/scala/bug/issues/10603
%: %.scala
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		retiman/scala:${IMAGE} \
		scala -nobootcp -nc -feature -deprecation $<
