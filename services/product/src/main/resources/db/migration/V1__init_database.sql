create table if not exists category (
    id bigserial not null primary key,
    name varchar(255) not null,
    description varchar(255) not null
);

create table if not exists product (
    id bigserial not null primary key,
    name varchar(255) not null,
    description varchar(255) not null,
    available_quantity double precision not null,
    price numeric(38, 2) not null,
    category_id bigserial
        constraint fk_category references category
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;