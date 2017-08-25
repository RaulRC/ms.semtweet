#!/usr/bin/env bash
docker build -f Dockerfile -t mssemtweet .
docker run -d -p 9003:9003 -t mssemtweet:latest