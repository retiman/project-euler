JAVA_OPTS := "-Xmx1024M"

%: P%.java
	javac P$*.java
	JAVA_OPTS=${JAVA_OPTS} time java P$* && $(RM) P$*.class

clean:
	$(RM) *.class
