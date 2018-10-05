package com.san.mkeiteasy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

public class PropertyInsertScript {

    public static void main(String[] args) {
	main1(args);
    }
    static String jsCode = "var date = new Date(new Date().getTime() + 20*60*1000);\n";
    @SuppressWarnings({ "unchecked", "rawtypes", "serial" })
    public static void main1(String[] args) {
	String json = "db.Properties.insert( [\n";
	Gson gson = new Gson();
	List<String> components = new ArrayList() {
	    {
		//add("AdminWebApp");
		add("MlWebServices");
		add("MlRestServices");
	    }
	};
	Set<String> keys = new HashSet<>();
	BufferedWriter wb = null;
	try (BufferedReader br = new BufferedReader(new FileReader("ABHI.properties"));) {
	    wb = new BufferedWriter(new FileWriter("ABHI.script"));
	    String line = br.readLine();
	    PropertyJson obj = new PropertyJson();
	    while (line != null) {
		if (line.startsWith("#") || "".equals(line.trim())) {
		    line = br.readLine();
		    continue;
		}
		Iterator<String> itr = components.iterator();
		while (itr.hasNext()) {
		    String component = itr.next();
		    String[] kv = line.split("=");
		    String k = kv[0].trim();
		    keys.add(k);
		    String v = "";
		    if (kv.length > 1)
			v = kv[1].trim();
		    obj.setComponent(component);
		    obj.setKey(k);
		    obj.setValue(v);
		    json += gson.toJson(obj);
		    if (itr.hasNext())
			json += ",\n";
			
		}
		line = br.readLine();
		if (line != null && !"".equals(line.trim()))
		    json += ",\n";
	    }
	    json += "\n],{multi:true})";
	    wb.write(jsCode+json.replaceAll("\"\\$date\"", "date"));
	    wb.flush();
	    json = json.replaceAll("\"\\$date\"", "date");
	    System.out.println(jsCode+ json);
	    String keysIn = "[";
	    for(String key : keys){
		keysIn+="\""+key +"\",";
	    }
	    keysIn+="$$]";
	    System.out.println(keysIn.replace(",$$", ""));
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
