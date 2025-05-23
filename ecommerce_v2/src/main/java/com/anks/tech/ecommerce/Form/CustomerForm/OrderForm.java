package com.anks.tech.ecommerce.Form.CustomerForm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {

    private int customersId;
    private String status;
    private Date orderDate;
    private double totalPrice;
    private String paymentMethod;
    private List<OrderDetailForm> orderDetailForms;

}
