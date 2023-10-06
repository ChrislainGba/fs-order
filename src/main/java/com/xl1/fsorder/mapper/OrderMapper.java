package com.xl1.fsorder.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.xl1.fsorder.dto.OrderDTO;
import com.xl1.fsorder.entity.Order;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);

}