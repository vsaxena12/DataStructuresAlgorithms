# Docker

Using Example PostgreSQL
docker run postgres:9.6 -> if postgres is not present, then an image will be installed before running it in the container. 
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=password postgres:9.6 -> If error occurs for seeking password and specifiy port


Docker vs VM 
Docker has Applications layer
    - Docker size is smaller
    - Speed is faster
    - 
VM has Applications layer and OS Kernel layer 
    - 

Docker tool box

Image vs Containers -> Containers a running environment for image
    - Application image: Postgres. redis etc
    - Port binded: talk to application runing inside of conatiner
    - Virtual file system. 

## Basic Docker Commands
1. docker pull <image>
2. docker images
3. docker run -p 1000:1000 -d <image>
4. docker kill <container id>
5. docker start <contianer id>
6. docker stop <container id>
7. docker ps -a

Container Port vs Host Port
- Multiple containers can run on your host machine
- Eg: 3000:3000, 3001:3000 -> Port binding and port forwarding



Example: 
1. Created an postgres docker image and run the image to container
    - docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=password postgres:9.6
2. Open DBeaver tool to use/create database, create table Student, insert values and select * from Student
3. Kill all the docker processes
4. DB connection will close
5. Start the docker again with new instance
6. Old data created in Student table is erased and need to create new db/tables everytime. 
7. When the same steps are performed with docker stop/start (instead of docker kill <ps>), the instance is maintained

Data Persistence Clarification: The persistence of data within a Docker container, especially for databases like PostgreSQL, is not directly related to whether docker stop or docker kill is used. Data persistence across container restarts is achieved by mounting a Docker volume to the container. Without a volume, both stopping and killing the container leave the data at risk because the container's filesystem is ephemeral.

Docker Kill vs. Docker Stop:

docker stop gracefully stops a container by sending a SIGTERM signal (allowing the process to clean up) followed by a SIGKILL signal if the process doesn't exit on time.
docker kill immediately sends a SIGKILL signal to the container, stopping it abruptly. This can be necessary for unresponsive containers but is less safe for databases because it doesn't allow for graceful shutdown and cleanup.
Addition - Volume Usage for Persistence:

Creating a Volume: Use docker volume create <volume_name> to create a new volume for persistent data storage.
Mounting the Volume: When running your PostgreSQL container, mount the volume to /var/lib/postgresql/data using the -v or --mount flag. This ensures that data written by PostgreSQL is stored on the volume, which exists independently of the container lifecycle.
Importance of Graceful Shutdown:

While docker stop and docker kill both stop the container, using docker stop is preferable for databases because it allows for a graceful shutdown, ensuring transactions are completed and the database is correctly closed, reducing the risk of data corruption.
Data Retention:

Data retention is ensured by the volume, not the stop/start method. Whether you use docker stop or docker kill, if your data is stored on a mounted volume, it will persist across container restarts and even after the container is removed, as long as the volume is not deleted.

