mvn clean package<br/>
docker build --no-cache --platform linux/amd64 -t sunbleaks/order-service:v01 .<br/>
docker push sunbleaks/order-service:v01<br/>