package sk.itsovy.projectMarket.main;

import sk.itsovy.projectMarket.Application;
import sk.itsovy.projectMarket.Exception.BillException;

public class Main {

    public static void main(String[] args) throws BillException {

        Application app = Application.getInstance();
        app.Example();

    }

}
