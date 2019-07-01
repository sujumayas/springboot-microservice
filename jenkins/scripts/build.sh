#!/usr/bin/env bash

echo 'The following Maven command builds the application to test locally'
set -x
mvn spring-boot:run
set +x
