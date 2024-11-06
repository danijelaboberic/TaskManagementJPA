
create table db_role
(
	idrole int auto_increment
		primary key,
	name varchar(256) null
)
charset=utf8;

create table db_user
(
	idUser int auto_increment
		primary key,
	username varchar(256) null,
	password varchar(1024) null,
	name varchar(256) null,
	idRole int null,
	constraint user_role_idrole_fk
		foreign key (idRole) references db_role (idrole)
)
charset=utf8;

create table db_project
(
	idProject int auto_increment
		primary key,
	title varchar(256) null,
	description text null,
	idLeader int null,
	constraint project_user_idUser_fk
		foreign key (idLeader) references db_user (idUser)
)
charset=utf8;

create table db_picture
(
	idPicture int auto_increment
		primary key,
	path varchar(1024) null,
	picture longblob null,
	idProject int null,
	constraint picture_project_idProject_fk
		foreign key (idProject) references db_project (idProject)
)
charset=utf8;

create table db_task
(
	idTask int auto_increment
		primary key,
	description text null,
	startDate timestamp null,
	endDate timestamp null,
	status varchar(256) null,
	idProject int null,
	constraint task_project_idProject_fk
		foreign key (idProject) references db_project (idProject)
)
charset=utf8;

create table db_assigned
(
	idAssigned int auto_increment
		primary key,
	idTask int null,
	idUser int null,
	constraint assigned_task_idTask_fkdd
		foreign key (idTask) references db_task (idTask),
	constraint assigned_user_idUser_fkk
		foreign key (idUser) references db_user (idUser)
)
charset=utf8;

