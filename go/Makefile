IMAGE := 1.16.2-buster
PWD := $(shell pwd)

%: P%
	docker run \
		--pull missing \
		--rm \
		--volume "${PWD}/P$*:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		golang:${IMAGE} \
		go run $*.go
