SOEN6471 - Docker + Jenkins + Azure Architecture Project

# To build a docker
docker build -t soen6471-docker .

# To run a docker as a daemon
docker-compose up -d

# To stop all dockers
docker stop $(docker ps -a -q)

# One-line command line to run docker
docker stop $(docker ps -a -q) && docker build -t soen6471-docker . && docker-compose up -d

# To run Jenkins server
localhost:8080 in browser