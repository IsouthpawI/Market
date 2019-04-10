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
import java.io.IOException;
import org.json.simple.parser.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void print() throws IOException, ParseException {
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
        if (open == true) {
            System.out.println("You can add the item");
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("'Date: 'yyyy.MM.dd 'Time: 'HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(date);
        }
    }

    public void itemUpdate(Item newItem,Item oldItem){

        if(newItem instanceof DrafInterface){
            double rslt = ((DrafInterface) newItem).getVolume() + ((DrafInterface) oldItem).getVolume();
            ((DrafInterface) newItem).setVolume(rslt);

        }else if(newItem instanceof Fruit){
            double rslt = ((Fruit) newItem).getWeight() + ((Fruit) oldItem).getWeight();
            ((Fruit) newItem).setWeight(rslt);

        }else if(newItem instanceof Pc){
            int rslt = ((Pc) newItem).getAmount() + ((Pc) oldItem).getAmount();
            ((Pc) newItem).setAmount(rslt);
        }

    }

    public List<Item> getList() {

        return list;
    }

    public void billEnd(){}

}
