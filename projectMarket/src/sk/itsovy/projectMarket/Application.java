package sk.itsovy.projectMarket;

import sk.itsovy.projectMarket.Exception.BillException;
import sk.itsovy.projectMarket.bill.Bill;
import sk.itsovy.projectMarket.items.*;

import static sk.itsovy.projectMarket.items.Category.School;

public class Application {

    public void Example() throws BillException {

        Bill bill = new Bill();

        int count = bill.getCount();

        bill.print();

        Bottle milk = new Bottle("Milk 2.7%",0.69,3);
        Food apple = new Fruit("Apple",0.47,80,275);
        Item Cola = new Draft("Cola",0.75,true,0.5);
        Item beer = new Bottle("Beer",2.35,true,2);

        bill.addItem(milk);
        bill.addItem(apple);
        bill.addItem(Cola);
        bill.addItem(beer);

        bill.removeItem(beer);

        bill.print();

    }

}
