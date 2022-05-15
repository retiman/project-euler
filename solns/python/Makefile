IMAGE := 3.9.2-slim-buster

%: %.py
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		python:${IMAGE} \
		python $<
else
	python $<
endif
