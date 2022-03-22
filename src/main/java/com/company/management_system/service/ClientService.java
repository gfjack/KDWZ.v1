package com.company.management_system.service;

import com.company.management_system.model.vo.client.ClientCreateVo;
import com.company.management_system.model.vo.client.ClientUpdateVo;
import com.company.management_system.model.vo.client.ClientVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ClientService {

    void export(HttpServletResponse response);

    ClientVo create(ClientCreateVo clientVo);

    ClientVo getClientByName(String clientName);

    ClientVo getClientById(Long clientId);

    List<ClientVo> getAll();

    void deleteByName(String clientName);

    void deleteById(Long clientId);

    ClientVo update(ClientUpdateVo clientUpdateVo, Long clientId);

}
