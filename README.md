otus-msa

<br/>
<b>Install:</b><br>
  - minikube start --driver=virtualbox<br/>
  - check minikube ip and map arch.homework local DNS in /etc/hosts<br/>
  - minikube tunnel<br/>
  <br/>
  - kubectl create ns order && kubectl create ns auth && kubectl create ns m && kubectl create ns database && kubectl create ns app<br/>
  <br/>
  - helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx/</br>
  - helm repo update</br>
  - helm install nginx ingress-nginx/ingress-nginx -f kube/nginx-ingress.yaml -n m</br>
  - helm install postgres kube/helm/postgres -n database<br/>
  <br/>
  - kubectl apply -f kube/auth/. -n auth<br/>
  - kubectl apply -f kube/app/. -n app<br/>
  - kubectl apply -f kube/order/. -n order<br/>
  <br/><br/>

<b>Архитектурное решение</b>
![Архитектурное решение drawio](https://github.com/sunbleaks/otus-msa/assets/144436024/a1b8e16a-b320-499e-ae45-9eac485415c2)
  <br/><br/>

<b>Tests:</b><br/>
  - newman run Order.postman_collection.json --verbose<br/>
  - newman run Order.postman_collection.json --verbose -r cli,junit,htmlextra --reporter-junit-export "newman/prod_report.xml" --reporter-htmlextra-export "newman/Prod_OrderServiceReport.html"<br/>

![Снимок экрана от 2023-12-05 13-47-52](https://github.com/sunbleaks/otus-msa/assets/144436024/fab68b3d-17cb-405e-a38e-30c45a2dcdcf)
 <br/><br/>