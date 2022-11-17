# keycloak

Identity and Access Management

## Custom keycloak

Build

```shell
docker compose build
```

Run

```shell
docker compose up
```

Stop en remove de deployment

```shell
docker-compose down
```

To delete the network, containers, and volumes when you stop the cluster, specify the -v option

```shell
docker-compose down -v
```

Inloggen op ```http://0.0.0.0:8080/``` met de gebruikersnaam/pass "ictu":"ictu"