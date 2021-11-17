//package com.example.demo7;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Provider
//public class MyExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
//
//    @Override
//    public Response toResponse(ConstraintViolationException e) {
//        List<ValidationError> errors = e.getConstraintViolations().stream()
////                .map(this::toValidationError).collect(Collectors.toList());
//
//        return Response.status(Response.Status.BAD_REQUEST).entity(errors).type(MediaType.APPLICATION_JSON).build();
//    }
//
//}
