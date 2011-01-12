JAVA_OPTS := "-Xmx1024M"

%: %.scala
	JAVA_OPTS=${JAVA_OPTS} time scala -deprecation $<
