package com.green.nowon.service.order;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.order.DeliveryInfoDTO;
import com.green.nowon.domain.dto.order.OrderGoodsDTO;

public interface OrderService {

	void deliveryInfoSave(DeliveryInfoDTO dto, String email);

	void orderGoods(OrderGoodsDTO dto, Model model);

	void baseAddress(String email, Model model);

	void addresList(String email, Model model);


}
