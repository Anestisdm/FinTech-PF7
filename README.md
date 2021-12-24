---
<p align="center">
<img src="https://user-images.githubusercontent.com/72802400/147275465-1f5697db-9a94-41ce-ae6b-adb3ba692b73.png" width="300" height="75" align="center"><img src="https://user-images.githubusercontent.com/72802400/147275444-8cb56c06-df1d-45cf-ac0f-3979f0c866f4.png" width="400" height="75" align="center">
</p>

---
<br/>

# Digital Wallet

### 1 - What is this?
This is a simplified technical system that accepts payment requests, directly to an account or through digital e-wallet. The requests are placed in a queue, different for each payment method, where they are dispatched by the appropriate services to validate the request and execute the transaction once all details have been confirmed as valid.

### 2 - Who can use this system?  
This system can be used by people that have an account on the Advanced Bank Central, or ABC. All transactions, either payments on account or payments through digital e-wallet, can be only between accounts of ABC.

### 3 - Technologies used  
* Java
* Spring Framework
* RabbitMQ
* Docker
* Postman

### 4 - How it works?

**Workstation Specifications**
- Windows 10 or Linux or MacOS, 64 bit
- RAM, 8GB required, 16GB preferable
- 128 GB Storage (SSD would be preferrable)
- 4 Core CPU

**Steps to run the application**

1. Install and set up docker
2. Run the following command from CMD "docker container run -p 15672:15672 -p 5672:5672 -d rabbitmq:3-management"
3. Install Postman
4. Clone this repository to Intellij
5. Install its depedencies via its maven
6. Run the Edge application from Intellij 
7. Go to Postman and send two post request as following for creating Queues in the RabbitMQ<br />

Post -> http://localhost:8080/api/feeder<br />
<img src="https://user-images.githubusercontent.com/72802400/147349518-f6a6902d-29a6-45e3-bdf3-71d7cb989280.png" width="600" height="200"><img src="https://user-images.githubusercontent.com/72802400/147349905-36447b99-c03a-48c3-8647-f5be13938606.png" width="600" height="300">


Post -> http://localhost:8080/api/feeder<br />
<img src="https://user-images.githubusercontent.com/72802400/147349518-f6a6902d-29a6-45e3-bdf3-71d7cb989280.png" width="600" height="200"><img src="https://user-images.githubusercontent.com/72802400/147350054-b6f80c12-5822-4df0-a9fa-e8a48881e1b9.png" width="600" height="300">

8. Run the Integration application from Intellij 
9. At this point you can start the transactions using posts like the above
10. In the case you want to check the balance of the accounts sent a get request from postman or browser like the following

Get -> http://localhost:8080/api/accounts<br />
<img src="https://user-images.githubusercontent.com/72802400/147350401-2aef3773-037e-4a41-9863-b9777993e50b.png" width="600" height="200">

### 5 - User support?  
For help or referring an issue, you can contact with the development team at these e-mails: adimou@athtech.gr and pvavalos@athtech.gr.
	
---
