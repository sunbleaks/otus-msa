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

  Tests:<br/>
  - newman run Auth.postman_collection.json --verbose<br/>
  - newman run Auth.postman_collection.json --verbose -r cli,junit,htmlextra --reporter-junit-export "newman/prod_report.xml" --reporter-htmlextra-export "newman/Prod_TestReport.html"<br/>
  <br/><br/>