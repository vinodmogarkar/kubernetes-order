# Kubernetes Orders/Items/Products
Playing made easy with Spring Boot + MySQL + Kubernetes

## Step 1 - Instalation/Configuration

Install Docker for images.

```
https://docs.docker.com/engine/install/ubuntu/
```

Install Minikube for run cluster local.

```
https://minikube.sigs.k8s.io/docs/start/
```

## Step 2 - Kubernetes management

```
$ minikube start
$ minikube dashboard
```

## Step 3 - Clone and run the project

- clone: 

```
$ git clone https://github.com/thiagohernandes/kubernetes-order
```

- import on Intellij
- run commands each projects: 'playing-products' and 'playing-orders' - folder kubernetes:

```
$ cd kubernetes
$ kubectl apply -f .

```

Happy code ;)

