#!/bin/bash

BOOKS_ENDPOINT="http://localhost:8080/v1/books"
if [ $# -eq 0 ]; then
    echo "Payload file needs to be provided!"
    exit 1
fi

EVENT_PAYLOAD=$1

curl -X POST -d @$EVENT_PAYLOAD $BOOKS_ENDPOINT --header "Content-Type:application/json"

