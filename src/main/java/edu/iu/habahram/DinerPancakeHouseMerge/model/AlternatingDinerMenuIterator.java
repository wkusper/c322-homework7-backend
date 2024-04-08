package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        position = Calendar.DAY_OF_WEEK % 2;
    }
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position = position + 2;
        return menuItem;
    }
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}
