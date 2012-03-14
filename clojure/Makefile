CLOJURE ?= $(if $(shell which clj), clj, clojure)
JAVA_OPTS := -Xmx1024M
POMEGRANATE := ${HOME}/.m2/repository/com/cemerick/pomegranate/0.0.9
URL := https://github.com/downloads/retiman/pomegranate/pomegranate-0.0.10-20120314-jar-with-dependencies.jar

deps:
	mkdir -p ${POMEGRANATE}
	wget ${URL} -O ${POMEGRANATE}/pomegranate-0.0.9.jar

%: %.clj
	JAVA_OPTS="${JAVA_OPTS}" CLOJURE_LIB=${POMEGRANATE} time ${CLOJURE} $<
