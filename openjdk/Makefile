JAVA_OPTS := -Xmx1024M
IMAGE := 17-slim-buster

%: P%.java
	docker run \
		--pull missing \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../.data:/data" \
		--workdir /src \
		openjdk:${IMAGE} \
		/bin/bash -c "javac -Xlint:deprecation P$*.java && JAVA_OPTS=${JAVA_OPTS} java P$* && rm *.class"
