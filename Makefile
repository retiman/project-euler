.PHONY: %

%:
	npm run test -- -t="problem $@"
