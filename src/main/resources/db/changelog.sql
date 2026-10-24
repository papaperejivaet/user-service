--liquibase formatted sql

--changeset papaperejivaet:init_schema
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS audit_log;

CREATE TABLE users
(
    id                UUID PRIMARY KEY,

    email             VARCHAR(255) NOT NULL UNIQUE,
    username          VARCHAR(100) NOT NULL UNIQUE,

    first_name        VARCHAR(100),
    last_name         VARCHAR(100),

    phone_number      VARCHAR(30)  NOT NULL UNIQUE,

    avatar_url        TEXT,

    position          VARCHAR(150),

    department        VARCHAR(150),

    is_active         BOOLEAN      NOT NULL DEFAULT TRUE,
    is_email_verified BOOLEAN      NOT NULL DEFAULT FALSE,

    last_login_at     TIMESTAMP,

    created_at        TIMESTAMP    NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMP    NOT NULL DEFAULT NOW(),

    deleted_at        TIMESTAMP
);

CREATE INDEX idx_users_email
    ON users (email);

CREATE INDEX idx_users_username
    ON users (username);

CREATE INDEX idx_users_department
    ON users (department);

CREATE INDEX idx_users_active
    ON users (is_active);

CREATE INDEX idx_users_deleted_at
    ON users (deleted_at);

CREATE TABLE roles
(
    id          BIGSERIAL PRIMARY KEY,

    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT,

    created_at  TIMESTAMP   NOT NULL DEFAULT NOW()
);


CREATE TABLE user_roles
(
    user_id     UUID      NOT NULL,
    role_id     BIGINT  NOT NULL,

    assigned_at TIMESTAMP NOT NULL DEFAULT NOW(),

    assigned_by UUID,

    PRIMARY KEY (user_id, role_id),

    CONSTRAINT fk_user_roles_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_user_roles_role
        FOREIGN KEY (role_id)
            REFERENCES roles (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_user_roles_assigned_by
        FOREIGN KEY (assigned_by)
            REFERENCES users (id)
            ON DELETE SET NULL
);

CREATE TABLE audit_log
(
    id          BIGSERIAL PRIMARY KEY,

    user_id     UUID,

    action      VARCHAR(100) NOT NULL,

    entity_type VARCHAR(100) NOT NULL,

    entity_id   VARCHAR(100),

    details     JSONB,

    ip_address  VARCHAR(100),

    user_agent  TEXT,

    created_at  TIMESTAMP    NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_audit_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE SET NULL
);

CREATE INDEX idx_audit_log_user_id
    ON audit_log(user_id);

CREATE INDEX idx_audit_log_action
    ON audit_log(action);

CREATE INDEX idx_audit_log_entity_type
    ON audit_log(entity_type);

CREATE INDEX idx_audit_log_created_at
    ON audit_log(created_at);