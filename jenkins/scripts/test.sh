#!/usr/bin/env bash

echo 'The following Maven command tests the application locally'
set -x
mvn test
set +x