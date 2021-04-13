JAVA_OPTS := -Xmx1024M
IMAGE := 17-slim-buster

%: P%.java
	chmod +x scripts/run.sh
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--volume "${CURDIR}/scripts:/scripts:ro" \
		--workdir /src \
		openjdk:${IMAGE} \
		/scripts/run.sh $<
