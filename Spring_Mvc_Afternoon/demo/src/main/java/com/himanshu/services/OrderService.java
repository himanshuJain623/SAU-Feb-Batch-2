package com.himanshu.services;

import org.springframework.stereotype.Service;
import com.himanshu.models.Order;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
	private List<Order> orders = new ArrayList<>();

	public String placeOrder(Order order) {
		try {
			orders.add(order);
			return "Order placed Successfully";
		} catch (Exception e) {
			return null;
		}
	}

	public List<Order> getAllOrders() {
		return orders;
	}

	public Order getOrderById(Integer id) {
		for (Order order : orders) {
			if (order.getOrderId() == id) {
				return order;
			}
		}
		return null;
	}

	public void updateOrders(Order order) {
		List<Order> orders = getAllOrders();
		int index = -1;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderId() == order.getOrderId()) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			orders.set(index, order);
		}
	}
}
