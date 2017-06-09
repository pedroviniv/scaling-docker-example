sudo docker rmi -f dac/docker-exemplo/db 
sudo docker build -t dac/docker-exemplo/db .
sudo docker rm -f dac-docker-exemplo-db
sudo docker run -p 5433:5432 -d --name dac-docker-exemplo-db dac/docker-exemplo/db
