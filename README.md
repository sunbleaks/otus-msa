otus-msa

<br/>
<b>Install:</b><br>
  - minikube start --driver=virtualbox<br/>
  - check minikube ip and map arch.homework local DNS in /etc/hosts<br/>
  - <br/>
  - kubectl create ns monitoring && kubectl create ns m && kubectl create ns database && kubectl create ns app<br/>
  - <br/>
  - helm repo add prometheus-community https://prometheus-community.github.io/helm-charts</br>
  - helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx/</br>
  - helm repo update</br>
  - helm install nginx ingress-nginx/ingress-nginx -f kube/nginx-ingress.yaml -n m</br>
  - helm install postgres kube/helm/postgres -n database<br/>
  - helm install stack prometheus-community/kube-prometheus-stack -f kube/prometheus.yaml -n monitoring</br>
  - <br/>
  - kubectl apply -f kube/service-monitor.yaml -n monitoring<br/>
  - kubectl apply -f kube/app/. -n app<br/>
  - <br/>
  - kubectl port-forward service/prometheus-operated  9090 -n monitoring<br/>
  - kubectl port-forward service/stack-grafana  9000:80 -n monitoring<br/>
    admin / prom-operator<br/>
  - <br/><br/>

  Tests:<br/>
  - newman run simple-service/src/test/java/com/example/simpleservice/resources/api_collection.json <br/>
  - ab -p simple-service/src/test/java/com/example/simpleservice/resources/ab.json -T application/json -c 10 -n 500000 http://arch.homework/user <br/>
  - <br/><br/>