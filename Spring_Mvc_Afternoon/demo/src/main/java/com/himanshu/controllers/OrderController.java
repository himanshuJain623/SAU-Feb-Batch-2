package com.himanshu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.himanshu.models.Order;
import com.himanshu.models.Item;
import com.himanshu.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;

	// Get All Orders
	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		if (orders.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	// Create Order
	@PostMapping("/placeOrder")
	public ResponseEntity<String> placeOrder(@RequestBody Order order) {
		String orderMsg = orderService.placeOrder(order);
		if (orderMsg == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return new ResponseEntity<>(orderMsg, HttpStatus.CREATED);
	}

	// Add Item to Order
	@PostMapping("/item/add")
	public ResponseEntity<Order> addItemToOrder(@RequestParam int orderId, @RequestBody Item item) {
		Order order = orderService.getOrderById(orderId);
		if (order == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		List<Item> items = order.getItemList();
		items.add(item);
		order.setItemList(items);
		orderService.updateOrders(order);
		return new ResponseEntity<>(order, HttpStatus.CREATED);

	}

	@PutMapping("/item/update")
	public ResponseEntity<Item> updateItem(@RequestParam int orderId, @RequestParam int itemId,
			@RequestBody Item item) {
		Order order = orderService.getOrderById(orderId);
		if (order != null) {
			List<Item> items = order.getItemList();
			int itemIndex = -1;
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getItemId() == itemId) {
					itemIndex = i;
					break;
				}
			}
			if (itemIndex != -1) {
				items.set(itemIndex, item);
				order.setItemList(items);
				orderService.updateOrders(order);
				return new ResponseEntity<>(item, HttpStatus.OK);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems(@RequestParam int orderId) {
		Order order = orderService.getOrderById(orderId);
		if (order == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<>(order.getItemList(), HttpStatus.OK);
	}

	@DeleteMapping("/item/delete")
	public ResponseEntity<String> deleteItem(@RequestParam int orderId, @RequestParam Integer itemId) {
		Order order = orderService.getOrderById(orderId);
		if (order != null) {
			List<Item> items = order.getItemList();
			int index = -1;
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getItemId() == itemId) {
					index = i;
				}
			}
			if (index != -1) {
				items.remove(index);
				order.setItemList(items);
				orderService.updateOrders(order);
				return new ResponseEntity<>("Item Deleted from order successfully", HttpStatus.OK);
			}
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
