CLOJURE ?= $(if $(shell which clj), clj, clojure)
JAVA_OPTS := -Xmx1024M
CLASSPATH := ${HOME}/.m2/repository/clj-pelib/clj-pelib/1.4.5/clj-pelib-1.4.5.jar:${CLASSPATH}

%: %.clj
	JAVA_OPTS="${JAVA_OPTS}" CLASSPATH="${CLASSPATH}" time ${CLOJURE} $<

repl:
	JAVA_OPTS="${JAVA_OPTS}" CLASSPATH="${CLASSPATH}" ${CLOJURE}
