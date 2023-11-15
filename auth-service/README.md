mvn clean package<br/>
docker build --no-cache --platform linux/amd64 -t sunbleaks/auth-service:v01 .<br/>
docker push sunbleaks/auth-service:v01<br/>