IMAGE := openjdk-17-tools-deps-1.10.3.814-slim-buster

%: %.clj
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../data:/data" \
		--workdir /src \
		clojure:${IMAGE} \
	  clojure -M $<
