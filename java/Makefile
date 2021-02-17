JAVA_OPTS := "-Xmx1024M"

%: P%.java
	javac -Xlint:deprecation P$*.java
	JAVA_OPTS=${JAVA_OPTS} time java P$* && $(RM) P$*.class
	$(RM) *.class
