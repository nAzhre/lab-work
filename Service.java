package com.example.demo7.Service;


import com.example.demo7.Items;
import com.example.demo7.Repository.Repository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class Service {
    @EJB
    Repository repository;

    public String addItems(Items items) throws SQLException, ClassNotFoundException {
        return Repository.addItems(items);
    }

    public List<Items> getAllItems()throws SQLException, ClassNotFoundException {
        return Repository.getAllItems();
    }

    public String updateItemsById(Items items) throws SQLException, ClassNotFoundException {
        return Repository.updateItemsById(items);
    }


    public String deleteItemsById(Items items) throws SQLException, ClassNotFoundException {
        return Repository.deleteItemsById(items);
    }
}

