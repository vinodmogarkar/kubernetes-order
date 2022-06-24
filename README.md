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


INSERT INTO products ( id, name , price) VALUES (1, 'Product 1', 10 );
INSERT INTO products ( id, name , price) VALUES (2, 'Product 2', 20 );
INSERT INTO products ( id, name , price) VALUES (3, 'Product 3', 30 );
INSERT INTO products ( id, name , price) VALUES (4, 'Product 4', 40 );
INSERT INTO products ( id, name , price) VALUES (5, 'Product 5', 50 );
INSERT INTO products ( id, name , price) VALUES (6, 'Product 6', 60 );
INSERT INTO products ( id, name , price) VALUES (7, 'Product 7', 70 );

INSERT INTO orders ( id, amount , date_time) VALUES (1, 10, '1910-10-10 10:10:10' );
INSERT INTO orders ( id, amount , date_time) VALUES (2, 20, '1920-2-20 10:10:10' );
INSERT INTO orders ( id, amount , date_time) VALUES (3, 30, '1930-3-30 10:10:10' );
INSERT INTO orders ( id, amount , date_time) VALUES (4, 40, '1940-4-4 10:10:10' );
INSERT INTO orders ( id, amount , date_time) VALUES (5, 50, '1950-5-5 10:10:10' );
INSERT INTO orders ( id, amount , date_time) VALUES (6, 60, '1960-6-6 10:10:10' );
INSERT INTO orders ( id, amount , date_time) VALUES (7, 70, '1970-7-7 10:10:10' );

INSERT INTO order_items ( id, id_order , id_product, quantity ) VALUES (1, 1, 1, 10 );
INSERT INTO order_items ( id, id_order , id_product, quantity ) VALUES (2, 2, 2, 20 );
INSERT INTO order_items ( id, id_order , id_product, quantity ) VALUES (3, 3, 3, 30 );
INSERT INTO order_items ( id, id_order , id_product, quantity ) VALUES (4, 4, 4, 40 );
INSERT INTO order_items ( id, id_order , id_product, quantity ) VALUES (5, 5, 5, 50 );
INSERT INTO order_items ( id, id_order , id_product, quantity ) VALUES (6, 6, 6, 60 );
INSERT INTO order_items ( id, id_order , id_product, quantity ) VALUES (7, 7, 7, 70 );

select * from products ;
select * from orders ;
select * from order_items ;

```

## Step 4 - Clone and run the project

- clone dev: 

```

$ git clone https://github.com/thiagohernandes/kubernetes-order
            
```

- import on STS
- run commands each projects: 'playing-products' and 'playing-orders' - folder kubernetes:

```
$ cd kubernetes
$ kubectl apply -f .

```



Few useful commands 

```
$ kubectl describe pod <pod name>

After Deployment of microserivce , access to it as 
http://kwoker2:nodeport/path/{id}
http://172.42.42.102:30020/api/products/3


How to see exception / errors in logs once application is deployed on kubernetes pod
$ kubectl logs deployment/<deployment name>
$ kubectl logs deployment/playing-products

```
