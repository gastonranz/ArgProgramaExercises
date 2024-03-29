package Class5and7;

import Class5and7.Discount.DescuentoPorcentajeConTope;
import Class5and7.Discount.Discount;
import Class5and7.Discount.FixedDiscount;
import Class5and7.Discount.PercentDiscount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\Gastón\\Documents\\Exercise5.txt";
        Path inFile = Paths.get(inputPath);

        List<Product> productList = new ArrayList<>();
        List<ItemCarrito> itemCarritoList = new ArrayList<>();
        Double price = 0d;
        Double discount = 0d;
        int count = 0;

        try {
            if(!Files.exists(inFile)) Files.createFile(inFile);
            List<String> fileLines = Files.readAllLines(inFile);
            Integer[] quantity = new Integer[fileLines.size()];

            String strNum;
            String name = null;

            if(fileLines.size() < 4) {
                for(String text : fileLines) {

                    if(!text.isEmpty() && text.matches("^[a-zA-Z_]+$")) {
                        System.out.println("Type the price of " + text + " item:");
                        strNum = Main.getText();
                        if(strNum.matches("^[0-9.]+$")) price =  Double.parseDouble(strNum);

                        System.out.println("Type the " + text + " code item:");
                        name = Main.getText();

                        System.out.println("Now please, type the " + text + " quantity item:");
                        strNum = Main.getText();
                        if(strNum.matches("^[0-9]+$")) quantity[count] = Integer.parseInt(strNum);
                    }

                    productList.add(new Product(text, price, name));
                    count++;
                }

                count = 0;

                for(Product product : productList) {
                    itemCarritoList.add(new ItemCarrito(product, quantity[count]));
                    count++;
                }

                Carrito carrito = new Carrito(itemCarritoList);
                carrito.getPrice();
                System.out.println("--------");

                if(args.length == 1) {
                    if(args[0].matches("%") || args[0].matches("d")) {
                        strNum = Main.getText();
                        if(strNum.matches("^[0-9.]+$")) discount = Double.parseDouble(strNum);
                    } else {
                        System.out.println("Please, type \"d\" to get a Fixed Discount value or type \"%\" to get " +
                                "a Percent Discount value");
                    }
                } else {
                    System.out.println("Please, type the discount for all the items:");
                    strNum = Main.getText();
                    if(strNum.matches("^[0-9.]+$")) discount = Double.parseDouble(strNum);
                }

                Main.getDiscount(carrito, discount);
            } else {
                for(String text : fileLines) {
                    System.out.println((count + 1) + " " + text);
                    count++;
                }
                System.out.println("Carrito out of limit -> " + fileLines.size() + " total items.\nPlease, just add 3 or less items!");
            }

        } catch(IOException e) {
            System.out.println("There's a problem to localize \"Exercise5.txt\" file");
        }
        /*
        Product prod1 = new Product("WhiteBoard", 90.0, "sjw28a928a");
        Product prod2 = new Product("BackPack", 40.0, "laksjdf2234klj2k3");
        Product prod3 = new Product("SuitCase", 120.0, "234k2l2l34kl234");

        ItemCarrito item1 = new ItemCarrito(prod1, 1);
        ItemCarrito item2 = new ItemCarrito(prod2, 3);
        ItemCarrito item3 = new ItemCarrito(prod3, 12);

        List<ItemCarrito> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        itemList1.add(item2);
        itemList1.add(item3);

        Carrito carrito1 = new Carrito(itemList1);
        carrito1.getPrice();
        System.out.println("-----");

        Double discount = 20d;

        Discount.getDiscount(carrito1, discount);

        Product prod4 = new Product("WhiteBoard", 100.0, "sjw28a928a");
        Product prod5 = new Product("BackPack", 450.0, "laksjdf2234klj2k3");

        ItemCarrito item4 = new ItemCarrito(prod4, 1);
        ItemCarrito item5 = new ItemCarrito(prod5, 3);

        List<ItemCarrito> itemList2 = new ArrayList<>();
        itemList2.add(item4);
        itemList2.add(item5);

        Carrito carrito2 = new Carrito(itemList2);
        carrito2.getPrice();
        System.out.println("-----");

        Discount.getDiscount(carrito2, 30d);
        */
    }

    private static void getDiscount(Carrito carrito, Double discount) {
        if(carrito.getItemsCarrito().size() < 4) {
            boolean nullValue = false;
            List<ItemCarrito> itemsCarrito = carrito.getItemsCarrito();
            Double itemDiscount;
            Double totalPriceWithDiscount = 0d;
            Double totalValues = 0d;
            Double totalDiscount = 0d;

            for(ItemCarrito item : itemsCarrito) {
                Double productPrice = item.getProductPrice() * item.getQuantity();
                itemDiscount = Main.getDescuentoPorcentajeConTopeValue(discount, item.getProductPrice(), item.getQuantity());
                if(itemDiscount == null) {
                    nullValue = true;
                    break;
                }
                itemDiscount = itemDiscount - (item.getProductPrice() * item.getQuantity()) + (Main.getFixedDiscountValue(item, discount) * 2);
                //itemDiscount = Main.getFixedDiscountValue(item, discount);
                Double tPWDCheck = Main.getDescuentoPorcentajeConTopeValue(discount, item.getProductPrice(), item.getQuantity());
                if(tPWDCheck != null) totalPriceWithDiscount += tPWDCheck;
                //totalPriceWithDiscount += Main.getPercentDiscountValue(discount, item.getProductPrice(), item.getQuantity());
                //totalPriceWithDiscount += (item.getProductPrice() * item.getQuantity()) - Main.getDiscountValue(item, discount);
                totalValues += productPrice;
                totalDiscount += itemDiscount;
                //totalDiscount += Main.getFixedDiscountValue(item, discount);

                System.out.println("Item " + item.getProduct().getName() + " - Unit value: $" + item.getProductPrice() +
                        " - Total value: $" + productPrice + " - Discount: $" + itemDiscount + " - Quantity: " +
                        item.getQuantity() + " products");
            }

            if(!nullValue) {
                System.out.println("-------------------\nTotal value: $" + totalValues + " - Total discount: $" +
                        totalDiscount + "\nFinal price: $" + totalPriceWithDiscount);
            }
        } else {
            System.out.println("The carrito is out of limit! Please, just add 3 items!");
        }
    }

    private static Double getFixedDiscountValue(ItemCarrito item, Double discount) {
        Discount fixedDiscount = new FixedDiscount();
        fixedDiscount.setValue(discount);

        Double productDiscount = fixedDiscount.getFinalValue(item.getProductPrice()); //I get percent value of one product
        return productDiscount * item.getQuantity(); //I get percent of one product * product quantity
        //return ((item.getProductPrice() * item.getQuantity()) * discount) / 100;
    }

    private static Double getPercentDiscountValue(Double discount, Double productPrice, Integer quantity) {
        Discount percentDiscount = new PercentDiscount();
        percentDiscount.setValue(discount);

        return percentDiscount.getFinalValue(productPrice, quantity);
    }

    private static Double getDescuentoPorcentajeConTopeValue(Double discount, Double productPrice, Integer quantity) {
        Discount descuentoPorcentajeConTope = new DescuentoPorcentajeConTope();
        descuentoPorcentajeConTope.setValue(discount);

        return descuentoPorcentajeConTope.getFinalValue(productPrice, quantity);
    }

    private static String getText() throws IOException {
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(keyboard);
        return buffer.readLine();
    }
}
