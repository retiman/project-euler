.PHONY := image
IMAGE := 5.3-debian10.8-slim

# NOTE: There is no official image.  We'll have to build it ourselves.
# https://github.com/docker-library/official-images/issues/3404
image:
	docker build --tag retiman/lua:${IMAGE} .

%: %.lua
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../.data:/data" \
		--workdir /src \
		retiman/lua:${IMAGE} \
		lua $<
