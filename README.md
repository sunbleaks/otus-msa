otus-msa

K8s:
- set map local DNS in /etc/hosts
- make minikube tunnel for local LoadBalancer

- kubectl apply -f .
- http://arch.homework/health 
- tests:
   curl http://arch.homework/health
   {"status":"OK"}
   curl http://arch.homework/otusapp/oleg/health
   {"status":"OK"}
   curl http://arch.homework/otusapp
   {"timestamp":"2023-10-02T08:41:56.690+00:00","status":404,"error":"Not Found","path":"/otusapp"}
   curl http://arch.homework/
   {"timestamp":"2023-10-02T08:41:56.690+00:00","status":404,"error":"Not Found","path":"/"}
- kubectl delete -f .