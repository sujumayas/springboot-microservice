#!/usr/bin/env bash

cat $1
echo '$1'

curl -XPOST --unix-socket /var/run/docker.sock -d '{"Image":"sujumayas/springboot-test"}' -H 'Content-Type: application/json' http://localhost/containers/create