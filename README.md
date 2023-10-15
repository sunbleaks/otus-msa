otus-msa

<br/>
  - map local DNS in /etc/hosts<br/>
  - minikube start --driver=virtualbox<br/>
  - make minikube tunnel for local LoadBalancer<br/>
  - kubectl create ns app<br/>
  - kubectl config set-context --current --namespace=app<br/>
  - kubectl create namespace m && helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx/ && helm repo update && helm install nginx ingress-nginx/ingress-nginx --namespace m -f nginx-ingress.yaml</br>


  Start:<br>
  helm install postgres helm/postgres<br/>
  kubectl apply -f .<br/>

  newman run postman/user_collection.json

  User Collection

  → Create user
  POST http://arch.homework/user [201 Created, 104B, 162ms]

  → Get user
  GET http://arch.homework/user/1 [200 OK, 258B, 159ms]

  → Edit user
  PUT http://arch.homework/user/1 [200 OK, 99B, 351ms]

  → Delete user
  DELETE http://arch.homework/user/1 [204 No Content, 88B, 488ms]


  Delete:<br/>
  kubectl delete -f .<br/>
  helm uninstall postgres helm/postgres<br/>
  kubectl delete pvc pvc-postgres-ss-0<br/>
  minikube ssh and exexute rm -r /var/lib/postgresql</br>