IMAGE := 15.12.0-buster-slim
.PHONY := repl

repl:
	docker run \
		--pull missing \
		--interactive \
		--tty \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		node:${IMAGE} \
		node

%: %.js
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		node:${IMAGE} \
		node $<
