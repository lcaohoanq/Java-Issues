package com.lcaohoanq.fundamental.exam;

public class CarManager {

    public static void main(String[] args) {
        String urlBrand = "D:\\PIED\\JAVA\\Java Project\\17-Van-PE-12-3-2022\\src\\input\\brands.txt";
        String urlCar = "D:\\PIED\\JAVA\\Java Project\\17-Van-PE-12-3-2022\\src\\input\\cars.txt";

        BrandList bl = new BrandList();
        bl.loadFromFile(urlBrand);

        CarList cl = new CarList(bl);
        cl.loadFromFile(urlCar);

        //dựng menu 
        Menu menu = new Menu("PRO192: Assignment VanTTN");
        menu.addNewOption("List all Brands");
        menu.addNewOption("Add a new brand");
        menu.addNewOption("Search a brand based on its ID");
        menu.addNewOption("Update a brand");
        menu.addNewOption("Save brands to the file, named brands.txt");
        menu.addNewOption("List all cars in ascending order of brand names");
        menu.addNewOption("List cars based on a part of an input brand name");
        menu.addNewOption("Add a car");
        menu.addNewOption("Remove a car based on its ID");
        menu.addNewOption("Update a car based on its ID");
        menu.addNewOption("Save cars to file, named cars.txt ");

        int choice;
        while (true) {
            menu.print();
            choice = menu.getChoice();
            switch (choice) {
                case 1: {
                    bl.listBrands();
                    break;
                }
                case 2: {
                    bl.addBrand();
                    break;
                }
                case 3: {
                    //lúc nãy chỉ có hàm thô searchId
                    //nên build thêm hàm này
                    bl.searchBrand();
                    break;
                }
                case 4: {
                    bl.updateBrand();
                    break;
                }
                case 5: {
                    bl.saveToFile(urlBrand);
                    break;
                }
                case 6: {
                    cl.listCars();
                    break;
                }
                case 7: {
                    cl.printBaseBrandName();
                    break;
                }
                case 8: {
                    cl.addCar();
                    break;
                }
                case 9: {
                    cl.removeCar();
                    break;
                }
                case 10: {
                    cl.updateCar();
                    break;
                }
                case 11: {
                    cl.saveToFile(urlCar);
                    break;
                }
            }
        }
    }
}
