CLASSPATH := ${HOME}/.m2/repository/pelib/pelib_2.8.1/1.4.1/pelib_2.8.1-1.4.1.jar
JAVA_OPTS := "-Xmx1024M"

%: %.scala
	JAVA_OPTS=${JAVA_OPTS} CLASSPATH=${CLASSPATH} time scala -deprecation $<
