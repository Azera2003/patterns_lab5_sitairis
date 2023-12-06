package com.DOMParse;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.DOMParse.Entity.Dish;
import com.DOMParse.Entity.FabricFood;
import com.DOMParse.Entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class WriteXML {

    public static void main(String[] args) throws IOException {

        BufferedReader input = null;

        try {
            DishBuilder db = new DishBuilderImpl();
            Dish d1 = db.setCost(2.1f).setName("Параходов").builder();
            input = new BufferedReader(new InputStreamReader(System.in));
            File file = new File("src/main/resources/Food.xml");
            FabricFood fabric = new FabricFood();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("Foods");
            document.appendChild(root);
            System.out.println("Введите количество еды которое хотите добавить: ");
            int count = Integer.parseInt(input.readLine());
            String name = null,type_product = null;
            Float cost = 0.0f;
            int timeCook = 0,choise = 0,creteriy = 0;
            Element element = null;
            for (int i = 1; i <= count; i++) {
                System.out.println("******* Еда : " + i + " ********");
                System.out.println("Введите тип продукта(1 - Горячее,2 - Суп,3 - Напиток): ");
                choise = Integer.parseInt(input.readLine());
                System.out.println("Введите название : ");
                name = input.readLine();
                System.out.println("Введите цену: ");
                cost = Float.parseFloat(input.readLine());
                System.out.println("Введите время приготовления: ");
                timeCook = Integer.parseInt(input.readLine());

                if(choise == 1)type_product = "Dish";
                else if(choise == 2)type_product = "Soup";
                else if(choise == 3)type_product = "Drink";

                Food concreteFood = fabric.createFood(type_product);
                concreteFood.setName(name);
                concreteFood.setCost(cost);
                concreteFood.setTimeCook(timeCook);
                if(choise == 1){type_product = "Dish";
                System.out.println("Введите массу блюда: ");
                    creteriy = Integer.parseInt(input.readLine());
                }
                else if(choise == 2){type_product = "Soup";
                    System.out.println("Введите объём супа: ");
                    creteriy = Integer.parseInt(input.readLine());
                }
                else if(choise == 3){type_product = "Drink";
                    System.out.println("Введите содержание спирта: ");
                    creteriy = Integer.parseInt(input.readLine());
                }
                concreteFood.setCriteriy(creteriy);
                element = getEmployeeNode(concreteFood, i, document);
                root.appendChild(element);
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            System.out.println("Данные успешно добавлены");

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }

    }

    private static Element getEmployeeNode(Food concreteFood, int id, Document document) {

        Element element = document.createElement("Food");
        element.setAttribute("id", String.valueOf(id));
        element.setAttribute("typeProduct", concreteFood.getTypeProduct());
        Element name = getPropertyNode("name", document, concreteFood.getName());
        element.appendChild(name);
        Element cost = getPropertyNode("cost", document,concreteFood.getCost().toString());
        element.appendChild(cost);
        Element timeCook = getPropertyNode("timeCook", document,String.valueOf(concreteFood.getTimeCook()));
        element.appendChild(timeCook);
        String type = concreteFood.getTypeProduct();
        if(type.equals("Dish")){
            Element weight = getPropertyNode("weight", document,String.valueOf(concreteFood.getCreteriy()));
            element.appendChild(weight);
        }
        if(type.equals("Soup")){
            Element volume = getPropertyNode("volume", document,String.valueOf(concreteFood.getCreteriy()));
            element.appendChild(volume);
        }
        if(type.equals("Drink")){
            Element percentAlko = getPropertyNode("percentAlko", document,String.valueOf(concreteFood.getCreteriy()));
            element.appendChild(percentAlko);
        }
        return element;
    }

    private static Element getPropertyNode(String property, Document document,String value) {

        Element element = document.createElement(property);
        element.setTextContent(value);
        return element;
    }

}

