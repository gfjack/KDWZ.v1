package com.company.management_system.converter;

import com.company.management_system.model.entity.ClientPo;
import com.company.management_system.model.vo.client.ClientCreateVo;
import com.company.management_system.model.vo.client.ClientUpdateVo;
import com.company.management_system.model.vo.client.ClientVo;

import java.util.ArrayList;
import java.util.List;

import static com.company.management_system.utils.ErrorUtils.checkIfNull;

public class ClientConverter {

    public static ClientVo toClientVo(ClientPo clientPo) {
        ClientVo clientVo = new ClientVo();

        clientVo.setId(clientPo.getClientId());
        clientVo.setClientName(clientPo.getClientName());
        clientVo.setTaxNumber(clientPo.getTaxNumber());
        clientVo.setBank(clientPo.getBank());
        clientVo.setBankNum(clientPo.getBanNum());
        clientVo.setBankAccountNum(clientPo.getBankAccountNum());
        clientVo.setRegisterAddr(clientPo.getRegisterAddr());
        clientVo.setContactAddr(clientPo.getContactAddr());
        clientVo.setContact(clientPo.getContact());
        clientVo.setContactNum(clientPo.getContactNum());
        clientVo.setEmail(clientPo.getEmail());

        return clientVo;
    }

    public static List<ClientVo> toClientVos(List<ClientPo> clientPos) {
        List<ClientVo> res = new ArrayList<>();
        for (ClientPo po : clientPos) {
            ClientVo clientVo = toClientVo(po);
            res.add(clientVo);
        }

        return res;
    }

    public static ClientPo toClientPo(ClientVo clientVo) {
        ClientPo po = new ClientPo();
        po.setClientName(clientVo.getClientName());
        po.setTaxNumber(clientVo.getTaxNumber());
        po.setBank(clientVo.getBank());
        po.setBanNum(clientVo.getBankNum());
        po.setBankAccountNum(clientVo.getBankAccountNum());
        po.setRegisterAddr(clientVo.getRegisterAddr());
        po.setContactAddr(clientVo.getContactAddr());
        po.setContact(clientVo.getContact());
        po.setContactNum(clientVo.getContactNum());
        po.setEmail(clientVo.getEmail());

        return po;
    }

    public static ClientPo toClientPo(ClientCreateVo clientVo) {
        ClientPo po = new ClientPo();
        po.setClientName(clientVo.getClientName());
        po.setTaxNumber(clientVo.getTaxNumber());
        po.setBank(clientVo.getBank());
        po.setBanNum(clientVo.getBankNum());
        po.setBankAccountNum(clientVo.getBankAccountNum());
        po.setRegisterAddr(clientVo.getRegisterAddr());
        po.setContactAddr(clientVo.getContactAddr());
        po.setContact(clientVo.getContact());
        po.setContactNum(clientVo.getContactNum());
        po.setEmail(clientVo.getEmail());

        return po;
    }

    public static void updateClient(ClientPo po, ClientUpdateVo vo) {
        po.setClientName(checkIfNull(vo.getClientName()) ? po.getClientName() : vo.getClientName());
        po.setTaxNumber(checkIfNull(vo.getTaxNumber()) ? po.getTaxNumber() : vo.getTaxNumber());
        po.setBank(checkIfNull(vo.getBank()) ? po.getBank() : vo.getBank());
        po.setBanNum(checkIfNull(vo.getBankNum()) ? po.getBanNum() : vo.getBankNum());
        po.setBankAccountNum(checkIfNull(vo.getBankAccountNum()) ? po.getBankAccountNum() : vo.getBankAccountNum());
        po.setRegisterAddr(checkIfNull(vo.getRegisterAddr()) ? po.getRegisterAddr() : vo.getRegisterAddr());
        po.setContactAddr(checkIfNull(vo.getContactAddr()) ? po.getContactAddr() : vo.getContactAddr());
        po.setContact(checkIfNull(vo.getContact()) ? po.getContact() : vo.getContact());
        po.setContactNum(checkIfNull(vo.getContactNum()) ? po.getContactNum() : vo.getContactNum());
        po.setEmail(checkIfNull(vo.getEmail()) ? po.getEmail() : vo.getEmail());
    }
    


}
