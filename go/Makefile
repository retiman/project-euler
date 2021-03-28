IMAGE := 1.16.2-buster

%: P%
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}/P$*:/src" \
		--volume "${CURDIR}/../data:/data" \
		--workdir /src \
		golang:${IMAGE} \
		go run $*.go
