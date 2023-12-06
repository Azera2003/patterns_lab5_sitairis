package com.DOMParse.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.DOMParse.Entity.Dish;
import com.DOMParse.Entity.FabricFood;
import com.DOMParse.Entity.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

    public static void main(String[] args) {

        File file = new File("src/main/resources/Food.xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            String rootNode = document.getDocumentElement().getNodeName();
            System.out.println("Root Element : " + rootNode);
            List<Food> foods = getEmployeesData(document);
            Float fullCost = 0.0f;
            int numberFoods = foods.size();
            float mostExpensiveFood = foods.get(0).getCost();
            int indexMostExpensiveFood = 0;
            for (int i =0;i<foods.size();i++) {
                if(foods.get(i).getCost() > mostExpensiveFood){mostExpensiveFood = foods.get(i).getCost();
                    indexMostExpensiveFood = i;
                }
                fullCost += foods.get(i).getCost();
                foods.get(i).showInfo();
            }
            System.out.println("Количество товаров = "+numberFoods+ ", Общая стоимость = "+ fullCost + ", Самый дорогой продукт - "+foods.get(indexMostExpensiveFood).getName());

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    private static List<Food> getEmployeesData(Document document) {

        NodeList list = document.getElementsByTagName("Food");
        int length = list.getLength();
        List<Food> foods = new ArrayList<Food>();
        for (int i = 0; i < length; i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Food fd = getEmployee(element);
                foods.add(fd);
            }
        }

        return foods;
    }

    private static Food getEmployee(Element element) {
        FabricFood fabric = new FabricFood();
        String typeProduct=element.getAttribute("typeProduct");
        String id=element.getAttribute("id");
        String name = getEmployeeDetails(element, "name");
        Float cost = Float.parseFloat(getEmployeeDetails(element, "cost"));
        int timeCook = Integer.parseInt(getEmployeeDetails(element, "timeCook"));
        Food FD = fabric.createFood(typeProduct);
        FD.setId(Integer.parseInt(id));
        FD.setName(name);
        FD.setCost(cost);
        FD.setTimeCook(timeCook);
        if(typeProduct.equals("Dish")){
            int creteriy = Integer.parseInt(getEmployeeDetails(element, "weight"));
            FD.setCriteriy(creteriy);
        }
        else if(typeProduct.equals("Soup")){
            int creteriy = Integer.parseInt(getEmployeeDetails(element, "volume"));
            FD.setCriteriy(creteriy);
        }
        else if(typeProduct.equals("Drink")){
            int creteriy = Integer.parseInt(getEmployeeDetails(element, "percentAlko"));
            FD.setCriteriy(creteriy);
        }
        return FD;
    }

    private static String getEmployeeDetails(Element element, String property) {
        String value = element.getElementsByTagName(property).item(0).getTextContent();
        return value;
    }

}
