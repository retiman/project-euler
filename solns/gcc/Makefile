IMAGE := 10.2.0

%: %.c
	chmod +x scripts/run.sh
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--volume "${CURDIR}/scripts:/scripts:ro" \
		--workdir /src \
		gcc:${IMAGE} \
		/scripts/run.sh $<
