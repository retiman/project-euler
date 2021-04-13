#!/bin/bash
filename=$1

javac -Xlint:deprecation -d /tmp $filename
cd /tmp
JAVA_OPTS=-Xmx1024M java ${filename%.*}
rm ${filename%.*}.class
