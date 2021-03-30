IMAGE := 3.9.2-slim-buster

%: %.py
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		python:${IMAGE} \
		python $<
