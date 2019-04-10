package sk.itsovy.projectMarket;

import sk.itsovy.projectMarket.bill.Bill;
import sk.itsovy.projectMarket.interfaces.DrafInterface;
import sk.itsovy.projectMarket.interfaces.Pc;
import sk.itsovy.projectMarket.items.Item;
//import sk.itsovy.projectMarket.items.Goods;
import sk.itsovy.projectMarket.items.Fruit;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XML {

    public void createXML(Bill bill) {
        Internet net = new Internet();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element items = doc.createElement("items");
            doc.appendChild(items);

            for (Item item : bill.getList()) {

                Element Item = doc.createElement("item");
                rootItems.appendChild(mainItem);

                Element Name = doc.createElement("Name");
                name.appendChild(doc.createTextNode(Item.getName()));
                Item.appendChild(name);

                Element Price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(String.valueOf(Item.getPrice())));
                Item.appendChild(price);

                Element Amount = doc.createElement("Amount");

                if (item instanceof DrafInterface) {
                    amount.appendChild(doc.createTextNode(String.valueOf(((DrafInterface) item).getVolume())));
                    Item.appendChild(amount);
                } else if (item instanceof Fruit) {
                    amount.appendChild(doc.createTextNode(String.valueOf(((Fruit) item).getWeight())));
                    Item.appendChild(amount);
                } else if (item instanceof Pc) {
                    amount.appendChild(doc.createTextNode(String.valueOf(((Pc) item).getAmount())));
                    Item.appendChild(amount);
                }

            }


            Element totalprice = doc.createElement("TotalPrice");
            items.appendChild(totalprice);

            Element priceUSD = doc.createElement("USD");
            priceUSD.appendChild(doc.createTextNode(net.getFinalToUSD(bill.getFinalPrice())));
            totalprice.appendChild(priceUSD);

            Element priceEUR = doc.createElement("EUR");
            priceEUR.appendChild(doc.createTextNode(String.valueOf(bill.getFinalPrice())));
            totalPrice.appendChild(priceEUR);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("newBill.xml"));
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

    }

}
