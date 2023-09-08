otus-msa

1) docker build --platform linux/amd64 -t sunbleaks/simple-service:v01 .
2) docker run -d --rm -p8000:8080 sunbleaks/simple-service:v01
3) http://localhost:8000/health

