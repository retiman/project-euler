IMAGE := 5.0.202-buster-slim

%: %.cs
	chmod +x scripts/run.sh
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--volume "${CURDIR}/scripts:/scripts:ro" \
		--workdir /src \
		mcr.microsoft.com/dotnet/sdk:${IMAGE} \
		/scripts/run.sh $<
