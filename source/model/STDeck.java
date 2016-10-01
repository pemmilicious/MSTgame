package model;

import xmlwise.Plist;
import xmlwise.XmlParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class STDeck {
    public static ArrayList<Card> createDeck() {
        try {
            Map<String, Object> properties = Plist.load("source/model/MstCards_151021.plist");
            Object cardObject = properties.get("cards");
            ArrayList arrayList = (ArrayList) cardObject;
            ArrayList<Card> arrayOfCards = new ArrayList<Card>();

            //Separating each objects and storing it in Item class
            for (int i = 0; i < arrayList.size(); i++) {
                HashMap individual = (HashMap) arrayList.get(i);

                Card item = new Card();

                if (individual.get("chemistry") != null) {
                    item.setChemistry(individual.get("chemistry").toString());
                }
                if (individual.get("fileName") != null) {
                    item.setFileName(individual.get("fileName").toString());
                }
                if (individual.get("imageName") != null) {
                    item.setImageName(individual.get("imageName").toString());
                }
                if (individual.get("economic_value") != null) {
                    item.setEconomic_value(individual.get("economic_value").toString());
                }
                if (individual.get("crystal_system") != null) {
                    item.setCrystal_system(individual.get("crystal_system").toString());
                }
                if (individual.get("specific_gravity") != null) {
                    item.setSpecific_gravity(individual.get("specific_gravity").toString());
                }
                if (individual.get("classification") != null) {
                    item.setClassification(individual.get("classification").toString());
                }
                if (individual.get("title") != null) {
                    item.setTitle(individual.get("title").toString());
                }
                if (individual.get("card_type") != null) {
                    item.setCard_type(individual.get("card_type").toString());
                }
                if (individual.get("hardness") != null) {
                    item.setHardness(individual.get("hardness").toString());
                }
                if (individual.get("cleavage") != null) {
                    item.setCleavage(individual.get("cleavage").toString());
                }
                if (individual.get("crustal_abundance") != null) {
                    item.setCrustal_abundance(individual.get("crustal_abundance").toString());
                }
                if (individual.get("subtitle") != null) {
                    item.setSubtitle(individual.get("subtitle").toString());
                }

                //setting occurance value, array
                if (individual.get("occurrence") != null) {
                    List occuranceArrayList = (List) individual.get("occurrence");
                    String[] occuranceArray = (String[]) occuranceArrayList.toArray(new String[occuranceArrayList.size()]);
                    item.setOccurrence(occuranceArray);
                }

                arrayOfCards.add(item);
            }
            return arrayOfCards;


        } catch (XmlParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } // loads the (nested) properties.
        return null;
    }
}
