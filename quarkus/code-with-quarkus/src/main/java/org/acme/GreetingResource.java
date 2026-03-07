package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    private static final List<MyEntity> db = new ArrayList<>();
    private static final AtomicLong counter = new AtomicLong();

    static {
        db.add(new MyEntity(1L, "Alice"));
        db.add(new MyEntity(2L, "Bob"));
    }

    // GET ALL
    @GET
    public List<MyEntity> getAll() {
        return db;
    }

    // GET BY ID
    @GET
    @Path("/{id}")
    public MyEntity getById(@PathParam("id") Long id) {
        return db.stream()
            .filter(e -> e.id.equals(id))
            .findFirst()
            .orElseThrow(NotFoundException::new);
    }

    // CREATE
    @POST
    public MyEntity create(MyEntity entity) {
        entity.id = counter.incrementAndGet();
        db.add(entity);
        return entity;
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public MyEntity update(@PathParam("id") Long id, MyEntity updated) {

        MyEntity entity = db.stream()
            .filter(e -> e.id.equals(id))
            .findFirst()
            .orElseThrow(NotFoundException::new);

        entity.name = updated.name;

        return entity;
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {

        boolean removed = db.removeIf(e -> e.id.equals(id));

        if (!removed) {
            throw new NotFoundException();
        }

        return Response.noContent().build();
    }
}
