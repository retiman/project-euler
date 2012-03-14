CLOJURE ?= $(if $(shell which clj), clj, clojure)
JAVA_OPTS := -Xmx1024M
POMEGRANATE := ${HOME}/.m2/repository/com/cemerick/pomegranate/0.0.9
CLASSPATH := ${POMEGRANATE}/pomegranate-0.0.9.jar:${CLASSPATH}

deps:
	mkdir -p ${POMEGRANATE}
	wget http://search.maven.org/remotecontent?filepath=com/cemerick/pomegranate/0.0.9/pomegranate-0.0.9.jar -O ${POMEGRANATE}/pomegranate-0.0.9.jar

%: %.clj
	JAVA_OPTS="${JAVA_OPTS}" CLASSPATH=${CLASSPATH} time ${CLOJURE} $<
