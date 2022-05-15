IMAGE := 3.9.2-slim-buster

%: %.py
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		python:${IMAGE} \
		python $<
else
	python $<
endif
