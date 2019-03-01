# MICROSERVICES USING SPRING
* The application aims at creating 3 microservices that commincate via queues.
* Rabbitmq is used to facilitate queueing.
* Configure 2 exchanges in rabbitmq as configured and also shown in screenshots.
* Architecture diagram for the functionality is added for reference.
* Spring netflix framework is used.
* Eureka is used for client discovery.
* Configuration server is used so that all the microservices fetch the configurations from centralized place.
* All services are dummy implementations and do not interact with any database. These only print to console as of now.
* We set up exchanges at rabbitmq level to send events. Exchanges can forward message to multiple queues so that multiple consumers can consume same message.
* Zul is the gateway used to access the services that are hidden so that any instance of service can be picked up.
* To run on windows, go to the target directory of each application and run command from cmd : java -jar <name of snapshot jar>
* To run inside docker use command: docker-compose up

#### MICROSERVICES
1. OrderService
	* Recieves request from frontend : /order/add	(POSTRequest)
	* Send ORDER_REQUEST_RECEIVED
	* Recieves STOCK_UPDATE_RECIEVED and places order
	* Displays all orders with status: /order/all
	
2. Tracking Service
	* Reads ORDER_REQUEST_RECEIVED,STOCK_UPDATE_RECIEVED with timestamp and stores
	
3. Inventory Service
	* Reads ORDER_REQUEST_RECEIVED and reaises corresponding STOCK_UPDATE_RECIEVED

#### Userful links:
* https://dreamix.eu/blog/java/building-microservices-with-netflix-oss-apache-kafka-and-spring-boot
* https://cmatskas.com/getting-started-with-rabbitmq-on-windows