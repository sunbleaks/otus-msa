mvn clean package<br/>
docker build --no-cache --platform linux/amd64 -t sunbleaks/app-service:v01 .<br/>
docker push sunbleaks/app-service:v01<br/>