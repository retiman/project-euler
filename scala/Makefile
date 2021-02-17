JAVA_OPTS := "-Xmx1024M"

%: %.scala
	# See https://github.com/scala/bug/issues/10603
	JAVA_OPTS=${JAVA_OPTS} time scala -nobootcp -nc -deprecation $<
