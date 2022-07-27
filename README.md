<p align="center">
<img src="To_README\logo.png"/>
</p>

# Description:
The Simple-Chat-Project have the intention of make a Java aplication where is present a chat where you can send messages and change the currently user, the aplicattion will store the user messages in a database with MySQL as DBMS, the goal of this project is to put in pratice my Java and MySQL knowledge.

# Status:
<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=Finished&color=GREEN&style=for-the-badge"/>

# :hammer: project features:

- `Create account`: The user can create a new account.
- `Login and Logout`: The user can log in and log out of their account, and can also switch to another account. 
- `Send Message`: The user can send a message that other users can see.
- `Delete message`: The user can delete the messages he sent.

# Application demo:

Application demo video: https://youtu.be/IPUrDh095Tc

<p align="center">
<img src="To_README\SimpleChat.gif"/>
</p>

# Open and Run:

Install the Connector/J of MySQL:

- Download the connector zip in this link: https://dev.mysql.com/downloads/connector/j/
- Extract the files
- Open the project with your IDE(Apache NetBeans IDE 12.6 recommended)
- Open the project properties and go to Libraries
- Click in the "+" in Classpath and open the .jar file that you extracted

Import the database in your PC:

- Open your MySQL Workbench and login your connection
- In the navigator panel click in Administration
- In MANAGEMENT click in Data import/Restore
- Open the folder of your project in Simple-Chat-Project/Documents/
- Move the Database.sql to a folder of your choice
- In MySQL Workbench open the folder you put the Database.sql
- Select the option Import from Self-Contained File
- Click Start Import

Config the database in the project:

- Open the project with your IDE(Apache NetBeans IDE 12.6 recommended)
- Open the sorce packages folder(SimpleChatJava/src in the project folder)
- Open the package br.com.chat.models.DAO(br/com/chat/models/DAO in the project folder)
- Open the DataSource.java file
- In the createConnection method, change the following variables: `username`, `hostname`, `port`, `password` and `database` according to your database.

