Kubectl cheat sheet: https://kubernetes.io/docs/reference/kubectl/cheatsheet/

Run container in pod manually:
```
k run simple-node-service --image=antifragilesoftware/simple-node-service --port=8080 --generator=run/v1
```

Create a Load Balancer service to reach your pod:

```
kubectl expose rc simple-node-service --type=LoadBalancer --name simple-node-service-http
```