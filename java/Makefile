JAVA_OPTS := "-Xmx1024M"

%: P%.java
	javac P$*.java
	JAVA_OPTS=${JAVA_OPTS} time java P$*
	rm P$*.class

clean:
	rm *.class
