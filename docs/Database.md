
`docker exec -it postgres bash`

`psql -U simplishop`

`\c postgres`

`INSERT INTO roles(name) VALUES ('USER'); INSERT INTO roles(name) VALUES ('ADMIN'); SELECT * FROM roles;`
