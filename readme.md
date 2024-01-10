This project helps to keep track of the transactions for the Kirana store.
Once the project is in running phase, swagger URl - http://localhost:8080/swagger-ui.html

The project has 2 APIs,  
1. To record the transaction for the Kirana store which accepts the currency(USD/INR) of the transaction, Amount, mobileNumber of the user and the TransactionType(Cr/DR).
2. To get the transactions of the user, identified by the mobileNumber. It has a filter of date, where the user can select for which timeZone the transactions needs to be fetched(fromDate and toDate) and currency(INR/USD) in which, the transactions needs to be fetched.