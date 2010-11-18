JAVA_OPTS := "-Xmx1024M"
CLASSPATH := ${HOME}/.m2/repository/clj-pelib/clj-pelib/1.4.1/clj-pelib-1.4.1.jar

%: %.clj
	JAVA_OPTS="${JAVA_OPTS}" CLASSPATH="${CLASSPATH}" time clojure $<
