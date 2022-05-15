IMAGE := openjdk-17-tools-deps-1.10.3.814-slim-buster

%: %.clj
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		clojure:${IMAGE} \
	  clojure -M $<
else
	clojure -M $<
endif
