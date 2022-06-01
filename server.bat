net users > users.txt
mvn compile
cd .\target
start users-0.0.1-SNAPSHOT.jar
timeout 2
explorer http://localhost:8080/