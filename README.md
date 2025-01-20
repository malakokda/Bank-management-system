# Bank-management-system
Java using OOP principles and Jframes for a bank system management the System opens login page that enters username and password and read the data from a text file and if found and related to each other the login successfully then the user goes to home page.
At the home page there are option buttons (add account , modify account,delete account),(transfer,deposit,withdraw),(Search accounts,view transaction history)&log out button. 
To add account the syystem checks the validities for(name,email and phone number)and the rest of the data as the account number, the date of creation and the balance autumatically and add the accounts data to a text file.
To modify user can only modify name,email,phone number and all the data are being checked for validation before entering 
To delete account by entering a true and existed account number with 0 balance the account gets deleted and removed from the text file 
To transfer money add the account numbers to transfer to and from and validate them then check if the account to transfer from is current and the amount is less than 1000 $ a 10 $ fees are also taken 
To deposit enter a true and existed account number and add amount to deposit and make sure the amount is less than 10,000$ per try 
To withdraw enter a true and existed account number and add amount to withdraw and make sure the amount is less than 10,000$ per try and less than teh account balance and if the amount is less than 1000 $ and the acccount type is current 10$ fees are taken 
When view accounts a table with accounts and all their data are displayed with an option to sort them according to (name,date or balance) 
To search enter account name and all the names that has this name in it will appear in a table 
To view transaction history after every transaction a text file with the number of the account created saving all the transaction from this run and all the previous ones and when enter the account number if has transactions they will appear in a table
the log out button takes you back to the login page
at the login page the exit button ends your trial
