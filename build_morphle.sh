#!/bin/bash

source /etc/morphle/morphle.profile
cd ${CODE_HOME}/qupath/

./gradlew -Dorg.gradle.java.home=/usr/lib/jvm/java-1.21.0-openjdk-amd64/ clean jpackage

rm -rf ${CODE_HOME}/qupath-morphle/libs/*

cp qupath-app/build/libs/*.jar ${CODE_HOME}/qupath-morphle/libs/
cp qupath-core/build/libs/*.jar ${CODE_HOME}/qupath-morphle/libs/
cp qupath-core-processing/build/libs/*.jar ${CODE_HOME}/qupath-morphle/libs/

mv ${CODE_HOME}/qupath-morphle/libs/qupath-app* ${CODE_HOME}/qupath-morphle/libs/qupath-app.jar
mv ${CODE_HOME}/qupath-morphle/libs/qupath-core-processing* ${CODE_HOME}/qupath-morphle/libs/qupath-core-processing.jar
mv ${CODE_HOME}/qupath-morphle/libs/qupath-core-0* ${CODE_HOME}/qupath-morphle/libs/qupath-core.jar
