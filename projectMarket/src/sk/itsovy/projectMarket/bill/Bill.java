package sk.itsovy.projectMarket.bill;

import sk.itsovy.projectMarket.Application;
import sk.itsovy.projectMarket.Exception.BillException;
import sk.itsovy.projectMarket.interfaces.DrafInterface;
import sk.itsovy.projectMarket.interfaces.Pc;
import sk.itsovy.projectMarket.items.Fruit;
import sk.itsovy.projectMarket.items.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static sk.itsovy.projectMarket.main.Global.MAXITEMS;

public class Bill{

    public int count;
    public boolean open;
    private List<Item> list;

    public Bill() throws IOException {
        this.list = new ArrayList<>();
        this.open = true;
    }


    public void addItem(Item item) throws BillException {

        if(!open){
            throw new BillException("Cant add more items");
        }

        list.add(item);
        if(item!=null) {
            if (getCount() == MAXITEMS) {
                String message = "Bill is full, max is" + MAXITEMS + "items";
                throw new BillException(message);
            }
        }
    }

    public ArrayList<Item> getBill(){
        return (ArrayList<Item>) list;
    }

    public void removeItem(Item item){

        if(list.contains(item)) {
            list.remove(item);
            count--;
        }

    }

    public double getFinalPrice(){
        double total=0;
        if(getCount()==0){
            return 0;
        }
        else
        {
            for(Item item: list){
                total = total + item.getTotalPrice();
            }
        }

        return total;
    }

    public int getCount(){
        return this.list.size();
    }

    public void print() {
        if (count == 0) {
            System.out.println("Nothing to print. Bill is empty!");
        }
        else {
            for (Item item : list) {
                if (item instanceof DrafInterface) {
                    System.out.println(item.getName() + " " + ((DrafInterface) item).getVolume() + " ");
                    System.out.println(item.getPrice() + " " + item.getTotalPrice());
                }
                else if(item instanceof Fruit){
                    System.out.println(item.getName() + " " + ((Fruit) item).getWeight() + " ");
                    System.out.println(item.getPrice() + " " + item.getTotalPrice());
                }
                else if(item instanceof Pc) {
                    System.out.println(item.getName() + " " + ((Pc) item).getAmount() + " ");
                    System.out.println(item.getPrice() + " " + item.getTotalPrice());
                }
            }
        }
    }

    public List<Item> getList() {
        return list;
    }

    public void billEnd(){}

    public String dateFormat(){

        return date;
    }

}
