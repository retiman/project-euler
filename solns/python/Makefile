IMAGE := 3.9.2-slim-buster

.PHONY = deps
deps:
	pip install --upgrade pip
	pip install -r requirements.txt

.PHONY = lint
lint:
	flake8

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
