CREATE TABLE
    users
    (
        id serial,
        username CHARACTER VARYING(32) NOT NULL,
        name CHARACTER VARYING(64) NOT NULL,
        UNIQUE (id)
    );