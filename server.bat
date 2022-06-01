call package.bat
timeout 7
cd .\target
start users-0.0.1-SNAPSHOT.jar
timeout 2
explorer http://localhost:8080/