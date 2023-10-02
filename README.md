otus-msa

K8s:<br/>
  map local DNS in /etc/hosts<br/>
  make minikube tunnel for local LoadBalancer<br/>

  kubectl apply -f .<br/>
  
  http://arch.homework/health 

  curl http://arch.homework/health<br/>
  {"status":"OK"}<br/>

  curl http://arch.homework/otusapp/oleg/health<br/>
  {"status":"OK"}<br/>

  curl http://arch.homework/otusapp<br/>
  {"timestamp":"2023-10-02T08:41:56.690+00:00","status":404,"error":"Not Found","path":"/otusapp"}<br/>

  curl http://arch.homework/<br/>
  {"timestamp":"2023-10-02T08:41:56.690+00:00","status":404,"error":"Not Found","path":"/"}<br/>

  kubectl delete -f .<br/>
