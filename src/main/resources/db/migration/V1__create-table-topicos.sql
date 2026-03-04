create table topicos (
    id bigint not null auto_increment,
    titulo varchar(255) not null,
    mensaje text not null,
    created_at timestamp not null default current_timestamp,
    status varchar(50) not null,
    autor varchar(255) not null,
    curso varchar(255) not null,

    primary key (id)
);



    
    
 