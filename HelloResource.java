package com.example.demo7.Controller;

import com.example.demo7.Items;
import com.example.demo7.Service.Service;
import com.example.demo7.Student;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/hello-world")
public class HelloResource {
    @EJB
    Service service;

    @GET
    @Produces("application/json")
    public String hello() {
        return "Hello!";
    }

    @GET
    @Path("/getAllItems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Items> getAllItems()throws SQLException, ClassNotFoundException {
        return service.getAllItems();
    }

    @PUT
    @Path("/updateItemsById")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateItemsById(Items items)throws SQLException, ClassNotFoundException {
        service.updateItemsById(items);
        return "Product info with this id was updated";
    }

    @POST
    @Path("/addItems")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addItems(@Valid Items items)throws SQLException, ClassNotFoundException {
        service.addItems(items);
        return "Product added";
    }

    @DELETE
    @Path("/deleteItemsById")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteItemsById(Items items)throws SQLException, ClassNotFoundException {
        service.deleteItemsById(items);
        return "Product info with this id was deleted";
    }

}

