	create table category
	(
		id varchar(40) primary key,
		name varchar(100) not null unique,
		description varchar(255)
	);
	create table book
	   (
	  		id varchar(40) primary key,
	  		name varchar(100) not null unique,
	  		author varchar(100) not null,
	  		price double not null,
	 		image varchar(100),
	  		description varchar(255),
	  		category_id varchar(40),
	  		constraint category_id_FK foreign key(category_id) references category(id)
	   );
	create table user
	(
		id varchar(40) primary key,
		username varchar(40) not null unique,
		password varchar(40) not null,
		phone varchar(40) not null,
		cellphone varchar(40) not null,
		email varchar(40) not null,
		address varchar(255) not null
	);


	create table orders
	(
		id varchar(40) primary key,
		ordertime datetime not null,
		price double not null,
		state boolean,
		user_id varchar(40),
		constraint user_id_FK foreign key(user_id) references user(id)
	);
	
	create table orderitem
	(
		id varchar(40) primary key,
		quantity int,
		price double,
		order_id varchar(40),
		book_id varchar(40),
		constraint order_id_FK foreign key(order_id) references orders(id),
		constraint book_id_FK foreign key(book_id) references book(id)
	);