IMAGE := 5.0.202-buster-slim

%: %.cs
ifeq ("$(wildcard /.dockerenv)","")
	chmod +x scripts/run.sh
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--volume "${CURDIR}/scripts:/scripts:ro" \
		--workdir /workspace \
		mcr.microsoft.com/dotnet/sdk:${IMAGE} \
		/scripts/run.sh $<
else
	/scripts/run.sh $<
endif
