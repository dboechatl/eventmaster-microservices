
package com.eventmaster;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/orders")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class OrderResource {

    @Inject
    @Channel("orders")
    Emitter<String> emitter;

    @POST
    @RolesAllowed("user")
    public String create(String orderId) {
        emitter.send(orderId);
        return "ORDER_CREATED:" + orderId;
    }
}
