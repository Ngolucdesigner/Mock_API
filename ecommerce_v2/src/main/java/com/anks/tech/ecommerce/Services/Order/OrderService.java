package com.anks.tech.ecommerce.Services.Order;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService implements IOrderService {



}
