package nl.logius.security.keycloak.authorization;

import com.google.common.collect.ImmutableMap;
import org.jboss.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Path("/api/users")
public class UsersResource {

    @Inject
    Logger log;

    @Context
    SecurityContext securityContext;

    @Context
    UriInfo uriInfo;

    @GET
    @Path("/me")
    //TODO udpate dependency @NoCache
    public Map<String, Object> me() {
        log.infof("### Accessing %s", uriInfo.getPath());
        // Note in order to have role information in the token, you need to add the microprofile-jwt scope
        // to the token to populate the groups claim with the realm roles.
        // securityContext.isUserInRole("admin");
        //  jwt.getClaim("preferred_username");
        return ImmutableMap.of("securityContext principal ", securityContext.getUserPrincipal(),
                "datetime", Instant.now());
    }

    @GET
    @RolesAllowed("iam") // require 'iam' present in groups claim list
    @Path("/claims")
    public Object claims(
            @QueryParam("issuer") String issuer,
            @QueryParam("clientId") String clientId,
            @QueryParam("userId") String userId,
            @QueryParam("username") String username) {
        log.infof("### Generating dynamic claims for user. issuer=%s client_id=%s user_id=%s username=%s",
                issuer, clientId, userId, username);
        return Map.of("acme", Map.of("roles", List.of(clientId + "_user")));
    }
}