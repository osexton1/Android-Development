package com.example.munsterrugby;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PlayersFromXML {

    private Player [] players;
    private Context context;

    public PlayersFromXML(Context context) {

        this.context = context;

        // Open a stream to the XML file + a docBuilder + doc
        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmlDoc = null;

        try {
            stream = this.context.getResources().openRawResource(R.raw.players);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);
        }
        catch(Exception e){}

        // Slice xmlDoc to NodeLists
        NodeList nameList = xmlDoc.getElementsByTagName("name");
        NodeList positionList = xmlDoc.getElementsByTagName("position");
        NodeList capsList = xmlDoc.getElementsByTagName("caps");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList pointsList = xmlDoc.getElementsByTagName("points");
        NodeList honoursList = xmlDoc.getElementsByTagName("honours");
        NodeList urlList = xmlDoc.getElementsByTagName("url");


        // Make players
        players = new Player[nameList.getLength()];
        for (int i = 0; i < players.length; i++) {
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String position = positionList.item(i).getFirstChild().getNodeValue();
            String caps = capsList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String points = pointsList.item(i).getFirstChild().getNodeValue();
            String honours = honoursList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();

            players[i] = new Player(name, position, caps, image, points, honours, url);
        }
    }

    public int getLength() {
        return players.length;
    }

    public Player getPerson(int index) {
        return players[index];
    }

    public Player [] getPlayers() { return players; }

    public String [] getNames() {
        String [] names = new String[getLength()];
        for (int i = 0; i < getLength(); i++) {
            names[i] = getPerson(i).getName();
        }
        return names;
    }
}
