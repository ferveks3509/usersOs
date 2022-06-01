call package.bat
cd .\target
start users-0.0.1-SNAPSHOT.jar
explorer http://localhost:8080/
cd %userprofile%
net users > users.txt