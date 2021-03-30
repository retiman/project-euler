IMAGE := 1.16.2-buster

# NOTE: You cannot have more than one main method per package/directory, so each
# golang problem needs its own directory.  Golang was not intended to be run
# like a scripting language.
%: P%
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}/P$*:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		golang:${IMAGE} \
		go run $*.go
