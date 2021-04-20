#!/bin/bash
# Build via maven and run the jlink

mvn clean compile javafx:jlink
if [[ $? -eq 0 ]] ;
  then
    ./target/ProgressBarTest/bin/launcher
  else
    echo $?
    echo "Build Failed, no run."
fi