CLOJURE ?= $(if $(shell which clj), clj, clojure)
JAVA_OPTS := -Xmx1024M
POMEGRANATE_VERSION := 0.0.10-20120314
POMEGRANATE_DIR := ${HOME}/.m2/repository/com/lousycoder/pomegranate/${POMEGRANATE_VERSION}
POMEGRANATE_URL := https://github.com/downloads/retiman/pomegranate/pomegranate-${POMEGRANATE_VERSION}-jar-with-dependencies.jar

deps:
	mkdir -p ${POMEGRANATE_DIR}
	wget ${POMEGRANATE_URL} -O ${POMEGRANATE_DIR}/pomegranate-${POMEGRANATE_VERSION}.jar

%: %.clj
	JAVA_OPTS="${JAVA_OPTS}" CLOJURE_LIB=${POMEGRANATE_DIR} time ${CLOJURE} $<
