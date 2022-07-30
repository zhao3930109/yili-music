create table user_role(
    user_id varchar (32) not null comment "用户ID",
    role_id varchar (32) not null comment "角色ID",
    constraint c_user_id foreign key (user_id) references  user (id),
    constraint c_role_id foreign key (role_id) references role (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '用户角色表';