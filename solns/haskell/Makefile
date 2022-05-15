IMAGE := 8.8.4

%: %.hs
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		haskell:${IMAGE} \
		runghc $<
else
	runghc $<
endif
