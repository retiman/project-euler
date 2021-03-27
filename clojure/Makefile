IMAGE := openjdk-17-tools-deps-1.10.3.814-slim-buster
PWD := $(shell pwd)

%: %.clj
	docker run \
		--pull missing \
		--rm \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		clojure:${IMAGE} \
	  clojure -M $<
