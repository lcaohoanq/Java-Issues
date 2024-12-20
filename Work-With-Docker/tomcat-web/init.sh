#!/bin/bash
docker container run --name ws2 --ulimit nofile=122879:122880 -p 8080:8080 -d lcaohoanq/prj301-ws2:1.1

echo -e "Start Server Successully!\nListenning on: http://localhost:8080/WS2/\nStop container: docker container stop ws2"
