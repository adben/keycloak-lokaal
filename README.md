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


## Exporteren realms
_In_ de betreffende docker container run het volgende command:
```bash
mkdir -p /tmp/export
/opt/keycloak/bin/kc.sh export --dir /opt/keycloak/data/import --users realm_file
```

Na de git push check status van het image op https://quay.io/repository/adolfobenedetti/keycloak?tab=builds

Meer info check ```https://quay.io/tutorial/```

## Template in openshift

```shell
oc process -f https://raw.githubusercontent.com/adben/keycloak-lokaal/main/keycloak.yaml \
  -p KEYCLOAK_IMAGE=quay.io/adolfobenedetti/keycloak:latest \
  -p KEYCLOAK_ADMIN=adminXX \
  -p KEYCLOAK_ADMIN_PASSWORD=adminXX \
  -p NAMESPACE=keycloak | oc create -f -

```
