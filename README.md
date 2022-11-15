# keycloak

Identity and Access Management

## Custom keycloak

Build de image

```shell
podman build . -t mykeycloak
```

Run de image

```shell
podman run --name mykeycloak -p 8443:8443 \
 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=change_me \
 mykeycloak \
 start --optimized
```

develop mode

```shell
podman run --name mykeycloak -p 8080:8080 \
 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=change_me \
 mykeycloak \
 start-dev
```
