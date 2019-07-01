#!/usr/bin/env bash
cat $1

ID=$(curl -XPOST --unix-socket /var/run/docker.sock -d '{"Image":"sujumayas/springboot-test"}' -H 'Content-Type: application/json' http://localhost/containers/create | grep -oP '(?<="Id": ")[^"]*')

echo "$ID"

curl -XPOST --unix-socket /var/run/docker.sock "http://localhost/containers/$ID/start"

