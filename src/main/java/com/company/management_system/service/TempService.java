package com.company.management_system.service;


import com.company.management_system.repository.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TempService {

    @Resource
    private ClientRepository clientRepository;
    @Resource
    private OrderDetailsRepository orderDetailsRepository;
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private SupplierRepository supplierRepository;
    @Resource
    private TransportRepository transportRepository;

    public void deleteAll() {
        clientRepository.deleteAll();
        orderDetailsRepository.deleteAll();
        orderRepository.deleteAll();
        supplierRepository.deleteAll();
        transportRepository.deleteAll();
    }

}
