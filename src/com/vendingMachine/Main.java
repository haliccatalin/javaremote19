package com.vendingMachine;

import com.cedarsoftware.util.io.JsonObject;
import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Vending Machine application requirements
 * Requirements
 * Implement a traditional vending machine which:
 * <p>
 * -Allow user to select products - the menu is displayed in console.
 * -Allow user to select what coins to insert - menu is displayed in console.
 * -Allow user to take refund by canceling the request.
 * -Return selected product and remaining change if any.
 * -The state of the vending machine is saved in a file on the disk - a json file.
 * -Vending Machine has the product menu configurable - new products can be added in the json file.
 * Vending Machine is configurable on what coins it accepts - new coins can be added in the json file.
 * <p>
 * For guidance you can check the code from this repository to see how these requirements were implemented.
 **/
public class Main {
    private static List<Product> productList;
    private static List<Coin> coinList;
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner scannerText = new Scanner(System.in);

    public static void main(String[] args) {
        setupProduct();
        mainMenu();
        Product product = choseAProduct();
        coinMenu();
        int coinValue = chooseAPaymentMethod();

        System.out.println("Do you want to cancel the order?(Y/N)");
        String response = scannerText.nextLine();
        System.out.println(response);
        if (response.equalsIgnoreCase("Y")) {
            mainMenu();
        } else {
            if (coinValue >= product.getPrice()) {
                int diff = product.getPrice() - coinValue;
                System.out.println(product);
                System.out.println("Rest: " + diff);
            } else {
                System.out.println("Not enough money");
            }
            saveProductToJson();
        }


    }

    public static List<Product> fromJSONListStackOverflow(String json) {
        Map<String, Object> args = new HashMap<>();
        args.put(JsonReader.USE_MAPS, true);
        //folosind jsonReader pentru a transforma variabila json din text in lista de obiecte
        JsonReader jsonReader = new JsonReader();
        List<Product> result = new ArrayList<>();
        Object[] array = (Object[])JsonReader.jsonToJava(json, args);
        for (int i=0; i<array.length; i++) {
            //fiecare element din lista este tranformat intr-un map
            //se adauga proprietatea @type cu valoarea com.vendingMachine.Product
            //pentru a sti ca acel element este corespondentul clasei product
            ((Map)array[i]).put("@type", "com.vendingMachine.Product");
            //map-ul de mai sus se transforma in obiectul product
            Product product =(Product) jsonReader.jsonObjectsToJava((JsonObject) array[i]);
            //se adauga in result obiectul obtinut
            result.add(product);
        }

        return result;
    }

    private static void saveProductToJson() {
        Map<String,Object> option=new HashMap<>();
        option.put(JsonWriter.PRETTY_PRINT,true);
        option.put(JsonWriter.TYPE,false);
        String product=JsonWriter.objectToJson(productList,option);
        try {
            Files.write(Paths.get("Product.json"), Arrays.asList(product));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setupProduct() {
        productList = new ArrayList<>();
        //productList.add(new Product("Chocolate", 12));
        //productList.add(new Product("Soda", 2));
        //productList.add(new Product("Gum", 1));
        try {
            List<String> stringList=Files.readAllLines(Paths.get("Product.json"));
            String result=stringList.stream()
                    .reduce("",(currentValue,element)->
                            currentValue+element);
            productList=fromJSONListStackOverflow(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void setupCoin(){
        coinList=new ArrayList<>();
        try {
            List<String> stringList=Files.readAllLines(Paths.get("Coin.json"));
            String result=stringList.stream()
                    .reduce("",(currentValue,element)->
                            currentValue+element);
            Map<String, Object> args = new HashMap<>();
            args.put(JsonReader.USE_MAPS, true);
            //folosind jsonReader pentru a transforma variabila json din text in lista de obiecte
            JsonReader jsonReader = new JsonReader();
            Object[] array = (Object[])JsonReader.jsonToJava(result, args);
            for (int i=0; i<array.length; i++) {
                //fiecare element din lista este tranformat intr-un map
                //se adauga proprietatea @type cu valoarea com.vendingMachine
                //pentru a sti ca acel element este corespondentul clasei coin
                ((Map)array[i]).put("@type", "com.vendingMachine.Coin");
                //map-ul de mai sus se transforma in obiectul product
                Coin coin =(Coin) jsonReader.jsonObjectsToJava((JsonObject) array[i]);
                //se adauga in result obiectul obtinut
                coinList.add(coin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void coinMenu() {
        setupCoin();
        System.out.println("Please select coin");
        for (Coin coin : coinList) {
            System.out.println(coin.getId() + " - " + coin.getTitle());
        }
    }

    public static void mainMenu() {
        int i = 1;
        System.out.println("Menu");
        for (Product product : productList) {
            System.out.println(i + " - " + product);
            i++;
        }
        System.out.println("Select an option");
    }

    public static Product choseAProduct() {
        int userOption = scanner.nextInt();
        Product product = null;
        switch (userOption) {
            case 1:
                System.out.println(productList.get(0).getTitle());
                product = productList.get(0);
                break;
            case 2:
                System.out.println(productList.get(1).getTitle());
                product = productList.get(1);
                break;
            case 3:
                System.out.println(productList.get(2).getTitle());
                product = productList.get(2);
                break;
            default:
                System.out.println("Option selected is not valid");
        }
        return product;
    }

    public static int chooseAPaymentMethod() {
        int userOption = scanner.nextInt();
        return coinList.stream().filter((coin -> coin.getId()==userOption)).mapToInt(Coin::getValue).sum();
    }
}
