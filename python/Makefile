IMAGE := 3.9.2-slim-buster

%: %.py
	docker run \
		--pull missing \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../data:/data" \
		--workdir /src \
		python:${IMAGE} \
		python $<
