JAVA_OPTS := -Xmx1024M
IMAGE := 17-slim-buster

%: P%.java
	chmod +x scripts/run.sh
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--volume "${CURDIR}/scripts:/scripts:ro" \
		--workdir /workspace \
		openjdk:${IMAGE} \
		/scripts/run.sh $<
else
	/scripts/run.sh $<
endif
