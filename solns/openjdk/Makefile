JAVA_OPTS := -Xmx1024M
IMAGE := 17-slim-buster

%: P%.java
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		openjdk:${IMAGE} \
		/bin/bash -c "javac -Xlint:deprecation -d /tmp/ P$*.java && cd /tmp && JAVA_OPTS=${JAVA_OPTS} java P$* && rm P$*.class"
