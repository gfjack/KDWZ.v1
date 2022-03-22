package com.company.management_system.service.Impl;

import com.company.management_system.constants.ErrorType;
import com.company.management_system.exception.ClientException;
import com.company.management_system.model.entity.ClientPo;
import com.company.management_system.model.vo.client.ClientCreateVo;
import com.company.management_system.model.vo.client.ClientUpdateVo;
import com.company.management_system.model.vo.client.ClientVo;
import com.company.management_system.repository.ClientRepository;
import com.company.management_system.service.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.management_system.constants.ErrorType.CLIENT_ALREADY_EXISTS;
import static com.company.management_system.constants.ErrorType.CLIENT_NOT_EXISTS;
import static com.company.management_system.converter.ClientConverter.*;
import static com.company.management_system.utils.ExcelUtils.export2File;

@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    private ClientRepository clientRepository;


    private ClientPo getOne(String clientName) {
        try {
            List<ClientPo> res = clientRepository.findByClientName(clientName);
            return res.get(0);
        } catch (Exception e) {
            throw new ClientException(CLIENT_NOT_EXISTS);
        }
    }

    private ClientPo getOne(Long clientId) {
        ClientPo clientPo = clientRepository.findByClientId(clientId);
        if (null == clientPo) {
            throw new ClientException(CLIENT_NOT_EXISTS);
        }
        return clientPo;
    }

    @Override
    public void export(HttpServletResponse response) {

        export2File(response, "客户表", "客户信息", ClientPo.class, clientRepository.findAll());

    }


    @Override
    public ClientVo create(ClientCreateVo clientVo) {
        if (clientRepository.existsByClientName(clientVo.getClientName())) {
            throw new ClientException(CLIENT_ALREADY_EXISTS);
        }
        ClientPo clientPo = toClientPo(clientVo);
        clientRepository.save(clientPo);
        return toClientVo(clientPo);
    }

    @Override
    public ClientVo getClientByName(String clientName) {
        ClientPo clientPo = getOne(clientName);

        return toClientVo(clientPo);
    }

    @Override
    public ClientVo getClientById(Long clientId) {
        ClientPo clientPo = getOne(clientId);

        return toClientVo(clientPo);
    }

    @Override
    public List<ClientVo> getAll() {
        List<ClientPo> all = clientRepository.findAll();
        return toClientVos(all);
    }

    @Override
    public void deleteByName(String clientName) {
        ClientPo po = getOne(clientName);
        try {
            clientRepository.delete(po);
        } catch (Exception e) {
            throw new ClientException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long clientId) {
        ClientPo po = getOne(clientId);
        try {
            clientRepository.delete(po);
        } catch (Exception e) {
            throw new ClientException(e.getMessage());
        }
    }

    @Override
    public ClientVo update(ClientUpdateVo clientUpdateVo, Long clientId) {
        ClientPo po = getOne(clientId);
        updateClient(po, clientUpdateVo);
        clientRepository.save(po);
        return toClientVo(po);
    }
}
