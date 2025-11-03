# Capitec Fraud Rule Engine Service

A system that processes categorized transaction events and flags potential fraud. Apply a set of fraud rules per transaction based on different criteria and then store them in a data store and allows the retrieval of this data via an API.

### Build the Project

Clean the project and build a .jar file

```
	mvn clean install
```

 - Run the project in docker
 
 - You need docker engine(https://docs.docker.com/engine/install/) installed on your local machine to run the project as a quick start.

```
	1. docker build -t capitec-fraud-rule-engine-service .
	
	2. docker compose up
```

### Testing the service

You can either use Postman/Chrome Talend API tester/SOAPui or any other tool you prefer to test the service.
Paste the below URL into your browser and use the test data below.

```
	http://localhost:8080/swagger-ui/index.html
```

#### Create a new Transaction

#####	*ENDPOINT :* 
	
```
	
	{
	  "category": "test Transaction",
	  "amount": 0.1,
	  "sourceAccount": "Cheque",
	  "destinationAccount": "12345678",
	  "timestamp": "2025-10-31T12:20:23.142Z"
	}
```


##### TRACES
View traces of all your transactions and logs on Jaeger UI using the below URL.

 - *http://localhost:16686/search*

## Author
- [Tebogo Bareetseng](https://github.com/tebogobar)
- Email : tebogobar@gmail.com
- Cell : 0682433564


