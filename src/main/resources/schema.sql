create table example.employee
(
    id         bigint auto_increment
        primary key,
    name       varchar(255) null,
    department varchar(255) null,
    salary     double       null
);
