#!/usr/bin/env bash
mvn clean install
docker build -f Dockerfile -t mssemtweet .
docker run -p 9003:9003 -t mssemtweet:latest