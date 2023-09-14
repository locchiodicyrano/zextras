--DROP TABLE IF EXISTS task;
--DROP TABLE IF EXISTS todo;

CREATE TABLE IF NOT EXISTS todo (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(1024) NOT NULL,
    creation_timestamp BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS task (
    id SERIAL NOT NULL PRIMARY KEY,
    todo_id BIGINT NOT NULL,
    description VARCHAR(1024) NOT NULL,
    creation_timestamp BIGINT NOT NULL,
    is_done BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_todo_id
        FOREIGN KEY(todo_id)
        REFERENCES todo(id)
);