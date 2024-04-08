package edu.iu.habahram.DinerPancakeHouseMerge.repository;



import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class MergerRepository {


    public  List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    private MenuItemRecord createMenuItemRecord(MenuItem menuItem) {
        return new MenuItemRecord(
                menuItem.getName(),
                menuItem.getDescription(),
                menuItem.isVegetarian(),
                menuItem.getPrice()
        );
    }

    public List<MenuItemRecord> getVeg() {
        MenuComponent allMenus = new Menu("ALL VEG MENUS", "All vegetarian combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> vegetarianItems = new ArrayList<>();
        CompositeIterator iterator = new CompositeIterator(allMenus.createIterator());

        while (iterator.hasNext()) {

            MenuComponent menuComponentss = iterator.next();
            Iterator<MenuComponent> menuComponentIterator = menuComponentss.createIterator();
            while(menuComponentIterator.hasNext()){
                MenuComponent x = menuComponentIterator.next();
            if (x.isVegetarian()) {
//
                MenuItemRecord menuItemRecord = new MenuItemRecord(
                        x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()
                );
                vegetarianItems.add(menuItemRecord);
            }}
        }
        return vegetarianItems;
    }

    public List<MenuItemRecord> getBreakfast() {
        MenuComponent PancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        PancakeHouseMenu.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        List<MenuItemRecord> breakfastItemMenu = new ArrayList<>();
        CompositeIterator iterator = new CompositeIterator(PancakeHouseMenu.createIterator());
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            Iterator<MenuComponent> menuComponentIterator = menuComponent.createIterator();
            while (menuComponentIterator.hasNext()) {
                MenuComponent x = menuComponentIterator.next();
                MenuItemRecord menuItemRecord = new MenuItemRecord(
                        x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()
                );
                breakfastItemMenu.add(menuItemRecord);
            }

        }
        return breakfastItemMenu;
    }

    public List<MenuItemRecord> getLunch() {
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        dinerMenu.add(new DinerMenu("DINER MENU", "Lunch"));
        List<MenuItemRecord> lunchItemMenu = new ArrayList<>();
        CompositeIterator iterator1 = new CompositeIterator(dinerMenu.createIterator());

        while (iterator1.hasNext()) {
            MenuComponent menuComponent = iterator1.next();
            Iterator<MenuComponent> menuComponentIterator = menuComponent.createIterator();
            while (menuComponentIterator.hasNext()) {
                MenuComponent x = menuComponentIterator.next();
                MenuItemRecord menuItemRecord = new MenuItemRecord(
                        x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()
                );
                lunchItemMenu.add(menuItemRecord);
            }

        }
        return lunchItemMenu;
    }



    public List<MenuItemRecord> getSupper() {
        MenuComponent dinnerMenu = new Menu("CAFE MENU", "Dinner");
        dinnerMenu.add(new CafeMenu("CAFE MENU", "Dinner"));
        List<MenuItemRecord> dinnerItemMenu = new ArrayList<>();
        CompositeIterator iterator1 = new CompositeIterator(dinnerMenu.createIterator());

        while (iterator1.hasNext()) {
            MenuComponent menuComponent = iterator1.next();
            Iterator<MenuComponent> menuComponentIterator = menuComponent.createIterator();
            while (menuComponentIterator.hasNext()) {
                MenuComponent x = menuComponentIterator.next();
                MenuItemRecord menuItemRecord = new MenuItemRecord(
                        x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()
                );
                dinnerItemMenu.add(menuItemRecord);
            }

        }
        return dinnerItemMenu;
    }


}
