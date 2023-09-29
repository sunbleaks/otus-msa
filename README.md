otus-msa

1) mvn package 
2) docker build --platform linux/amd64 -t sunbleaks/simple-service:v01 .
3) docker push sunbleaks/simple-service:v01
4) docker run -d --rm -p8000:8080 sunbleaks/simple-service:v01
5) http://localhost:8000/health

