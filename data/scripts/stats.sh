#!/bin/bash

for dir in *; do
  if [ $dir = 'data' ]; then continue; fi
  if [ ! -d $dir ]; then continue; fi

  echo -n "$dir: "
  cd $dir
  solns=""

  for f in *; do
    if [ $f = 'Makefile' ]; then continue; fi
    if [ $f = 'a.out' ]; then continue; fi
    solns="$solns $f "
  done

  solns=$(echo -n "$solns" | sed 's/\.[^ ]*\s/ /g' | sed 's/P//g')
  echo $solns | sort
  cd ..
done
