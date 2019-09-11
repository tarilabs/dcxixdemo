#!/bin/bash

if [ "$1" != "" ]; then
  echo "Positional parameter 1 contains something"
  while [ 1 ]
  do
    echo "Refreshing.."
    git -C $1 pull origin
    find $1 -type f -name "*.dmn" -exec cp {} ./src/main/resources \;
    sleep 1
  done
else
  echo "Positional parameter 1 is empty"
fi
