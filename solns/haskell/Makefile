IMAGE := 8.8.4

.PHONY = deps
deps:
	cabal update
	cabal install apply-refact
	cabal install hlint

.PHONY = lint
lint:
	hlint -h .hlint.yml .

%: %.hs
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		haskell:${IMAGE} \
		runghc $<
else
	runghc $<
endif
