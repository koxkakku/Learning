insert into user_detail(user_id,birth_date,user_name)
values(1001,current_date(), 'sharad');

insert into user_detail(user_id,birth_date,user_name)
values(1002,current_date(), 'saurav');

insert into user_detail(user_id,birth_date,user_name)
values(1003,current_date(), 'sayan');

insert into user_detail(user_id,birth_date,user_name)
values(1004,current_date(), 'saswat');

insert into user_post(post_id,description,user_user_id)
values(1001,'My dummy post', 1001);
insert into user_post(post_id,description,user_user_id)
values(1002,'I am learning Spring boot', 1001);

insert into user_post(post_id,description,user_user_id)
values(1003,'I am Saurav', 1002);
insert into user_post(post_id,description,user_user_id)
values(1004,'I am learning JPA', 1002);

insert into user_post(post_id,description,user_user_id)
values(1005,'I am Sayan', 1003);
insert into user_post(post_id,description,user_user_id)
values(1006,'I am learning AWS', 1003);

insert into user_post(post_id,description,user_user_id)
values(1007,'I am Saswat', 1004);
insert into user_post(post_id,description,user_user_id)
values(1008,'I am learning DevOps', 1004);

