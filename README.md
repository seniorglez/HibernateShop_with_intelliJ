# HibernateShop with intelliJ

Spin-off of [JEEShop](https://github.com/seniorglez/JEEShop) repo with Hibernate.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

First and foremost, this is a tutorial for Arch-based distro's users, if it is not your case you will need to learn how to install the packages for your distros. The rest of the tutorial is the same.

#### JDK 8 or higher

I hope you did not need help to install this. Anyway [here](https://wiki.archlinux.org/index.php/Java#Installation) is the archwiki page about java. If you are not familiar with JDK8 new features please check this [CheatSheet](https://github.com/BafS/Java8-CheatSheet/blob/master/README.md) out.

In my case I will choose [openJDK11](https://www.archlinux.org/packages/extra/x86_64/jdk11-openjdk/) because is the LTS version of the JDK.

```bash

	sudo pacman -Syu
	
	sudo pacman -S jdk11-openjdk

```
Now we need to set the JAVA_HOME in my case I will set it for all users so I just add this at the end of /etc/profile 

```bash
	
	#JAVA
	
	export JAVA_HOME="/usr/lib/jvm/java-11-openjdk"

	export PATH=$JAVA_HOME/bin:$PATH

```
In case you would prefer to set the JAVA_HOME only for your user just add the same lines on ~/.bash_profile If you want to know more about the bash configuration files please check the [wiki](https://wiki.archlinux.org/index.php/Bash)

After that restart your machine.

```bash

	reboot

```

#### IntelliJ IDEA
Just download InelliJ IDEA Ultimate from [Jet Brains website](https://www.jetbrains.com/es-es/idea/download/#section=linux).
I'm not a huge fan of non-free/opensource IDEs but this is necessary for a head-first development. I'm tryng to learn how to build 
this example with maven so stay tuned if you also didn't want to use non-free software!

#### MariaDB

MariaDB is nowdays the default relational database solution for Arch Linux so it will be my choice.

```bash

	sudo pacman -Syu mariadb mariadb-clients libmariadbclient

	sudo mysql_install_db --user=mysql --basedir=/usr --datadir=/var/lib/mysql

	sudo systemctl start mysqld.service

	sudo systemctl enable mysqld.service
	
```
Now we need to create owr db. First of all we will log into owr mariadb server.

```bash
	sudo mysql -u root

```
So go ahead and create the shop's db and a new user.

```sql

	CREATE DATABASE shop;
	GRANT ALL ON shop.* TO 'shopadmin'@localhost IDENTIFIED BY 'shop';
	FLUSH privileges;
	exit
	
```

We can now login with this new user which have all privileges on that bd.

```bash
	mysql -u shopadmin -p

```

Let's create the tables we need now.

```sql
	
	use shop
	
	CREATE TABLE IF NOT EXISTS customers(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(10) NOT NULL,
	password VARCHAR(20) NOT NULL);
	
	CREATE TABLE IF NOT EXISTS products (
	idProduct INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	description VARCHAR(40) NOT NULL, 
	price FLOAT(7,2) NOT NULL);
	
	CREATE TABLE IF NOT EXISTS bills (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	client_id INT NOT NULL,
	purchase_date DATETIME NOT NULL);
	
	CREATE TABLE IF NOT EXISTS bill_lines(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	bill_id INT NOT NULL,
	product_id INT NOT NULL units,
	INT NOT NULL CHECK( UNITS > 0));
	
```

#### Tomcat9

Tomcat is the server that will allow us to execute owr projet.In order to install Tomcat just download it form [here](https://tomcat.apache.org/download-90.cgi) or use wget.

If you have download the tar.gz version execute this commands to extract it and move it to your home directory.

```bash

	cd ~/Downloads
	
	tar -xvzf apache-tomcat-9.x.xx.tar.gz
	
	mv apache-tomcat-9.x.xx ~/Tomcat	

```

Now we need to change the file permissions under the directory bin to allow Tomcat execution.

```bash

	sudo chmod +x ~/Tomcat/bin/*

```
This Tomcat installation is only for development and testing purposes, so if you want to use Tomcat to deploy your JavaEE application you will need to follow a few more steps that I will add on an md file on the future.




### Running it 

(work in progress)

Now to test that jsp files can run open [this](http://localhost:8080/HibernateShop/testing.jsp).
And to test that servlets also runs open [this](http://localhost:8080/HibernateShop/test).


## Built With

* [IntelliJ](https://www.jetbrains.com/es-es/idea/) - The IDE I used
* [Tomcat](http://tomcat.apache.org/) - The Java Servlet and JavaServer Pages implementation
* [MariaDB](https://mariadb.org/) - The relational database solution

## Contributing

Feel free to fork it and made pull request if I made something wrong but please keep in mind that it is just an example of
Hibernate use on a Java EE web app,


## Authors

* **Diego Dominguez**   <a href="https://twitter.com/DGlez1111" target="_blank">
    <img alt="Twitter: DGlez1111" src="https://img.shields.io/twitter/follow/DGlez1111.svg?style=social" />
  </a>

## License

HibernateShop is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.

HibernateShop is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the [GNU General Public License](LICENSE)
along with HibernateShop. If not, see [https://www.gnu.org/licenses/](https://www.gnu.org/licenses/)

![GPL3 or later](https://www.gnu.org/graphics/gplv3-or-later.png)
