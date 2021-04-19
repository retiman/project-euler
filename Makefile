all: primes test

# XDG_CACHE_HOME must be set to something writable.
# See https://github.com/docker-library/golang/issues/225
lint:
	docker run \
			--pull missing \
			--rm \
			--volume ${CURDIR}:/tmp/lint:rw \
			--user $(shell id -u):$(shell id -g) \
			--env DEFAULT_BRANCH=main \
			--env ERROR_ON_MISSING_EXEC_BIT=false \
			--env IGNORE_GITIGNORED_FILES=true \
			--env LOG_FILE=report/super-linter.log \
			--env OUTPUT_FOLDER=report \
			--env OUTPUT_FORMAT=tap \
			--env RUN_LOCAL=true \
			--env VALIDATE_BASH_EXEC=false \
			--env VALIDATE_HTML=false \
			--env VALIDATE_MARKDOWN=false \
			--env VALIDATE_YAML=false \
			--env XDG_CACHE_HOME=/tmp/.cache \
			github/super-linter:v3

primes:
	$(MAKE) -C solns/racket/lib primes

repl:
	$(MAKE) -C solns/racket/lib repl

test:
	$(MAKE) -C solns/racket/lib test
