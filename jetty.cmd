call mvn clean install -DskipTests=true

call java -jar target/dependency/jetty-runner.jar  --port 9090 target/*.war