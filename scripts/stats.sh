#!/bin/bash
# Prints out solutions per language, and which solutions have been solved in
# which language.
echo "Solutions Per Language"
echo "======================"

for dir in *; do
  if [[ $dir = 'data' || $dir = 'scripts' ]]; then continue; fi
  if [ ! -d $dir ]; then continue; fi

  cd $dir
  make clean > /dev/null 2>&1
  num=$(ls | wc -l)
  solns=""
  echo -e -n "$dir ($((num - 1))):\t"
  if [ $dir = 'c' ]; then echo -e -n "\t"; fi

  for f in *; do
    if [ $f = 'Makefile' ]; then continue; fi
    if [ $f = 'a.out' ]; then continue; fi
    if [ $f = 'lib' ]; then continue; fi
    solns="$solns $f "
  done

  solns=$(echo -n "$solns" | sed 's/\.[^ ]*\s/ /g' | sed 's/P//g')
  solns=$(echo $solns | tr ' ' '\n' | sort -n | tr '\n' ' ')
  echo $solns
  cd ..
done
