insert into POSITION (ID, name, supervisor) values(1, 'Engineering Manager', true);
insert into POSITION (ID, name, supervisor) values(2, 'Engineer', false);
insert into POSITION (ID, name, supervisor) values(3, 'VP of Software', true);


insert into EMPLOYEE (ID, creation_date, first_name, last_name, position_id) values(1, CURRENT_TIMESTAMP() , 'Max', 'Mustermann', 1);
insert into EMPLOYEE (ID, creation_date, first_name, last_name, position_id) values(2, CURRENT_TIMESTAMP() , 'Dev', 'Singh', 2);
insert into EMPLOYEE (ID, creation_date, first_name, last_name, position_id) values(3, CURRENT_TIMESTAMP() , 'Sarah', 'Coding', 2);
insert into EMPLOYEE (ID, creation_date, first_name, last_name, position_id) values(4, CURRENT_TIMESTAMP() , 'Lone', 'Wolf', 2);
insert into EMPLOYEE (ID, creation_date, first_name, last_name, position_id) values(5, CURRENT_TIMESTAMP() , 'Joe', 'Business', 3);
