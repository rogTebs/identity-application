CREATE TABLE person
(
    id               UUID    NOT NULL,
    created_by       VARCHAR(255),
    last_modified_by VARCHAR(255),
    created_date     TIMESTAMP WITHOUT TIME ZONE,
    last_modify_date TIMESTAMP WITHOUT TIME ZONE,
    version          INTEGER NOT NULL,
    username         VARCHAR(255),
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    email            VARCHAR(255),
    password         VARCHAR(255),
    active           BOOLEAN NOT NULL,
    state            VARCHAR(255),
    timezone_iana    VARCHAR(255),
    CONSTRAINT pk_person PRIMARY KEY (id)
);