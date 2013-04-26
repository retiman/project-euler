JAVA_OPTS := "-Xmx1024M"

SCALA_VERSION := 2.10
SPIRE_VERSION := 0.4.0-M4
SPIRE_PATH := org/spire-math/spire_${SCALA_VERSION}/${SPIRE_VERSION}
SPIRE_DIR := ${HOME}/.m2/repository/${SPIRE_PATH}
SPIRE_JAR := spire_${SCALA_VERSION}-${SPIRE_VERSION}.jar
SPIRE_URL := http://search.maven.org/remotecontent?filepath=${SPIRE_PATH}/${SPIRE_JAR}

deps:
	mkdir -p ${SPIRE_DIR}
	[ -f ${SPIRE_DIR}/${SPIRE_JAR} ] || wget ${SPIRE_URL} -O ${SPIRE_DIR}/${SPIRE_JAR}

repl: deps
	JAVA_OPTS=${JAVA_OPTS} scala -cp ${SPIRE_DIR}/${SPIRE_JAR} -deprecation

%: deps %.scala
	JAVA_OPTS=${JAVA_OPTS} time scala -cp ${SPIRE_DIR}/${SPIRE_JAR} -deprecation $<
