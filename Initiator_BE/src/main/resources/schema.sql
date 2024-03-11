create table USERS(
  userId int not null AUTO_INCREMENT,
  firstName varchar(100) not null,
  lastName varchar(100) not null,
  profileId varchar(100) null,
  PRIMARY KEY ( userId )
);