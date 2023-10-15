mvn clean package<br/>
docker build --no-cache --platform linux/amd64 -t sunbleaks/simple-service:v03 .<br/>
docker push sunbleaks/simple-service:v03<br/>