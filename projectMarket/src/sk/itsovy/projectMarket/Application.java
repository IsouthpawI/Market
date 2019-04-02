package sk.itsovy.projectMarket;

import org.jetbrains.annotations.Contract;
import sk.itsovy.projectMarket.Exception.BillException;
import sk.itsovy.projectMarket.bill.Bill;
import sk.itsovy.projectMarket.items.*;
import sk.itsovy.projectMarket.main.Internet;

public class Application {

    private static Application app = new Application();

    private Application(){

    }

    public static Application getInstance(){
        return app;
    }

    public void Example() throws BillException {

        Internet net = new Internet();
        net.getRequest();

        Bill bill = new Bill();

        int count = bill.getCount();

//        int count = bill.getCount();

//        bill.print();

        Bottle milk = new Bottle("Milk 2.7%",0.69,3);
        Food apple = new Fruit("Apple",0.47,80,275);
        Item Cola = new Draft("Cola",0.75,true,0.5);
        Item beer = new Bottle("Beer",2.35,true,2);

        bill.addItem(milk);
        bill.addItem(apple);
        bill.addItem(Cola);
        bill.addItem(beer);
        bill.removeItem(beer);

        System.out.println(count);

        bill.print();
        System.out.println("\n");
        System.out.println(bill.getFinalPrice());
        System.out.println(net.getFinalToUSD(bill.getFinalPrice()));

    }

}
