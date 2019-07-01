#!/usr/bin/env bash

echo 'The following Maven commands builds the application to test locally'
set -x
mvn clean package -DskipTests
set +x
