package com.jp.system.design.logistics;

import java.util.Date;
import java.util.List;

public class Order {

	private int orderId;
	private Date orderDate;
	private OrderStatus orderStatus;
	private OrderPriority orderPriority;
	private List<Item> items;
	private Address deliveryAddress;
	private User user;
	
	
	
}
