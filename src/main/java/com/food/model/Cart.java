package com.food.model;
import com.food.model.Cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
private Map<Integer,cartitem>items;
public Cart() {
	this.items=new HashMap();
}

public void additem(cartitem item) {
	int itemid=item.getOrderitemid();
	if(items.containsKey(itemid)) {
		cartitem existingItem=items.get(itemid);
		existingItem.setQuantity(existingItem.getQuantity()+1);
	}
	else {
		items.put(itemid, item);
	}
}
public void updateitem(int itemid,int quantity) {
	if(items.containsKey(itemid)) {
		if(quantity<=0) {
			items.remove(itemid);
				
			}
			else {
				items.get(itemid).setQuantity(quantity);
			}
		}
	}
public void removeitem(int itemid) {
    items.remove(itemid);
}

public Map<Integer, cartitem> getItems() {
    return items;
}

public void clear() {
	items.clear();
}

public void updateItem(int itemId, int quantity) {
	if(items.containsKey(itemId)) {
		if(quantity<=0) {
			items.remove(itemId);
				
		}
		else {
			items.get(itemId).setQuantity(quantity);
		}
	}
	
}
}