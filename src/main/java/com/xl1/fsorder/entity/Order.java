package com.xl1.fsorder.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.xl1.fsorder.dto.FoodItemsDTO;
import com.xl1.fsorder.dto.Restaurant;
import com.xl1.fsorder.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Document(collection = "order")
public class Order {
    private Long orderId;
    private List<FoodItemsDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;

}