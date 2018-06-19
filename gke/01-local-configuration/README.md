# Steps

* eval $(minikube docker-env)
* mvn clean package docker:build
* kubectl apply -f deployment/

