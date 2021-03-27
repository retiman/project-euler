JAVA_OPTS := -Xmx1024M
IMAGE := openjdk-17-tools-deps-1.10.3.814-slim-buster
PWD := $(shell pwd)

%: %.clj
	docker run \
		--pull missing \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		clojure:${IMAGE} \
	  JAVA_OPTS="${JAVA_OPTS}" clojure $<
