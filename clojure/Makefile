CLOJURE ?= $(if $(shell which clj), clj, clojure)
JAVA_OPTS := -Xmx1024M

%: %.clj
	JAVA_OPTS="${JAVA_OPTS}" time ${CLOJURE} $<
