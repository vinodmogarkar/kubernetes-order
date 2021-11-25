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

## Step 3 - Creation Database

- Use any dababase IDE to create a MySQL named: "dbproducts". So, run the script bellow: 


```
CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `amount` double DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `order_items` (
  `id` bigint(20) NOT NULL,
  `id_order` bigint(20) DEFAULT NULL,
  `id_product` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_items_FK` (`id_product`),
  CONSTRAINT `order_items_product_FK` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`),
  CONSTRAINT `order_items_order_FK` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

```

## Step 4 - Clone and run the project

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

