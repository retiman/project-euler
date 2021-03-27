PWD=$(shell pwd)
IMAGE=8.8.4

%: %.hs
	docker run \
		--pull missing \
		--volume "$(PWD):/src" \
		--volume "$(PWD)/../data:/data" \
		--workdir /src \
		haskell:$(IMAGE) \
		runghc $<
