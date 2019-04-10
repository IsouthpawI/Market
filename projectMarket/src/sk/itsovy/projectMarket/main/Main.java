package sk.itsovy.projectMarket.main;

import sk.itsovy.projectMarket.Application;
import sk.itsovy.projectMarket.Exception.BillException;

import java.sql.SQLException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws BillException, IOException, SQLException, {

        Application app = Application.getInstance();
        app.Example();

    }

}
