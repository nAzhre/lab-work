package com.example.demo7.Controller;

import com.example.demo7.Items;
import com.example.demo7.Repository.Repository;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@ApplicationPath("/")
public class HelloApplication extends Application {
    @EJB
    Repository Repository;
//
//    public List<Items> selectAllItems() {
//        return Repository.selectAllItems();
//    }
}

