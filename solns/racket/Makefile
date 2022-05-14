IMAGE := 7.9-full

# racket-review can only take one file as an argument
define review
	raco review $1;
endef

.PHONY = deps
deps:
	raco pkg install review

.PHONY = lint
lint:
	$(foreach file,$(wildcard *.rkt),$(call review,$(file)))
	$(foreach file,$(wildcard lib/*.rkt),$(call review,$(file)))

.PHONY = repl
repl:
	$(MAKE) -C lib repl

%: %.rkt
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		racket/racket:${IMAGE} \
		racket $*.rkt
else
	racket $*.rkt
endif
