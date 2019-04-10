package sk.itsovy.projectMarket.main;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Internet {

    public String getRequest()
    {
        String rslt="";

        String url_str = "http://data.fixer.io/api/latest?access_key=4cf9ee2eceb1b4300feac36f86691dcb";
        try {

            URL url = new URL(url_str);

            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            jsonobj = jsonobj.getAsJsonObject("rates");

            rslt = jsonobj.get("USD").getAsString();
            System.out.println(rslt);

        }catch (Exception e){
            e.printStackTrace();
        }
        return rslt;
    }

    public String getFinalToUSD(double price){

        String usdS = getRequest();

        double usd = Double.valueOf(usdS);
        double rslt = price*usd;

        return String.valueOf(rslt);
    }
}
