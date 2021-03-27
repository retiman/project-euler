IMAGE=10.8-slim
PWD=$(shell pwd)

%: %.sh
	docker run \
		--pull missing \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		debian:${IMAGE} \
		bash $<
