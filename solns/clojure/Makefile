IMAGE := openjdk-17-tools-deps-1.10.3.814-slim-buster

%: %.clj
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		clojure:${IMAGE} \
	  clojure -M $<
