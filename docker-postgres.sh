#!/bin/bash
  
docker run --detach \
  --name postgres-db \
  --env POSTGRES_PASSWORD=ulyseo \
  --env POSTGRES_USER=ulyseo \
  --publish 5432:5432 \
  postgres:9.4.4
