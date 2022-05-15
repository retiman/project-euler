IMAGE := 1.18.0-buster

.PHONY = deps
deps:
	@go install github.com/golangci/golangci-lint/cmd/golangci-lint@v1.46.1

.PHONY = lint
lint: GO111MODULES=off
lint:
	@golangci-lint run ./...

# NOTE: You cannot have more than one main method per package/directory, so each
# golang problem needs its own directory.  Golang was not intended to be run
# like a scripting language.
%: P%
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}/P$*:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		golang:${IMAGE} \
		go run $*.go
else
	go run $*.go
endif
