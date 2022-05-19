IMAGE := 1.18.0-buster

.PHONY = deps
deps:
	@go install github.com/golangci/golangci-lint/cmd/golangci-lint@v1.46.1

.PHONY = lint
lint:
	@golangci-lint run ./...

%:
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}/P$*:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		golang:${IMAGE} \
		go run main.go $*
else
	go run main.go $*
endif
