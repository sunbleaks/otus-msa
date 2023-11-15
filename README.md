otus-msa

<br/>
<b>Install:</b><br>
  - minikube start --driver=virtualbox<br/>
  - check minikube ip and map arch.homework local DNS in /etc/hosts<br/>
  - minikube tunnel<br/>
  <br/>
  - kubectl create ns auth && kubectl create ns m && kubectl create ns database && kubectl create ns app<br/>
  <br/>
  - helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx/</br>
  - helm repo update</br>
  - helm install nginx ingress-nginx/ingress-nginx -f kube/nginx-ingress.yaml -n m</br>
  - helm install postgres kube/helm/postgres -n database<br/>
  <br/>
  - kubectl apply -f kube/auth/. -n auth<br/>
  - kubectl apply -f kube/app/. -n app<br/>
  <br/><br/>

<b>Архитектурное решение</b> 
  ![Архитектурное решение drawio](https://github.com/sunbleaks/otus-msa/assets/144436024/35bb1039-9cc7-44da-8f6d-2907007d3928)
  <br/><br/>

<b>Tests:</b><br/>
  - newman run Auth.postman_collection.json --verbose<br/>
  ![Снимок экрана от 2023-11-15 13-02-59](https://github.com/sunbleaks/otus-msa/assets/144436024/499e03ec-5916-4697-931f-75de8150414c)
  <br/><br/>



