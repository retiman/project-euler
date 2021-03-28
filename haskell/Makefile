IMAGE := 8.8.4

%: %.hs
	docker run \
		--pull missing \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../data:/data" \
		--workdir /src \
		haskell:${IMAGE} \
		runghc $<
