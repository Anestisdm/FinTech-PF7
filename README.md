---
<img src="https://user-images.githubusercontent.com/72802400/147275444-8cb56c06-df1d-45cf-ac0f-3979f0c866f4.png" width="400" height="75"><img src="https://user-images.githubusercontent.com/72802400/147275465-1f5697db-9a94-41ce-ae6b-adb3ba692b73.png" width="300" height="75">
---
# Digital Wallet

1 - What is this?
        This is a simplified technical system that accepts payment requests, directly to an account or through digital e-wallet. The requests are placed in a queue, different for each payment method, where they are dispatched by the appropriate services to validate
 	the request and execute the transaction once all details have been confirmed as valid.

2 - Who can use this system?
        This system can be used by people that have an account on the Advanced Bank Central, or ABC. All transactions, either payments on account or payments through digital e-wallet, can be only between accounts of ABC.

3a - How it works?
        For achieving a payment with his system the user should have an IDE that can run Java files, the software "Docker" with "RabbitMq" and the software "Postman".
        While Docker is running, the user needs to run the "Edge.java" file in the IDE. Then, he should send a request with post method through "Postman", mentioning all the details needed for the transaction. After the request is sent, the user has to run the file "Integration.java". 
	Then, the system checks the validation and, if everything is valid, the transaction is completed.
	
3b - Workstation specifications

- Windows 10 or Linux or MacOS, 64 bit
- RAM, 8GB required, 16GB preferable
- 128 GB Storage (SSD would be preferrable)
- 4 Core CPU
    
4 - What details does the user need to provide?

The details must be written in a json format. For a payment to an account the user needs to give the following information:

        "cid": ,
        "creditorName": ,
        "creditorIBAN": ,
        "debtorName": ,
        "debtorIBAN": ,
        "paymentAmount": ,
        "valuerDate": ,
        "paymentCurrency": "EUR",
        "feeAmount": ,
        "feeCurrency": "EUR"

For a payment through a digital e-wallet the user must provide the following:

        "cid": ,
        "creditorName": ,
        "creditorIBAN": ,
        "debtorName": ,
        "debtorIBAN": ,
        "paymentAmount": ,
        "valuerDate": ,
        "paymentCurrency": "EUR",

5 - User support?
	For help or referring an issue, you can contact with the development team at these e-mails: adimou@athtech.gr and pvavalos@athtech.gr.
	
---
