package com.xl1.fsorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xl1.fsorder.dto.OrderDTO;
import com.xl1.fsorder.dto.OrderDTOFromFE;
import com.xl1.fsorder.dto.UserDTO;
import com.xl1.fsorder.entity.Order;
import com.xl1.fsorder.mapper.OrderMapper;
import com.xl1.fsorder.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;



    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Long newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO );
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Long userId) {
       return restTemplate.getForObject("http://USERDETAILS-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
}
