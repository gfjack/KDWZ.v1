package com.company.management_system.converter;

import com.company.management_system.model.entity.TransportationPo;
import com.company.management_system.model.vo.transport.TransportCreateVo;
import com.company.management_system.model.vo.transport.TransportUpdateVo;
import com.company.management_system.model.vo.transport.TransportVo;

import java.util.ArrayList;
import java.util.List;

import static com.company.management_system.utils.ErrorUtils.checkIfNull;

public class TransportConverter {

    public static TransportVo toTransportVo(TransportationPo po) {
        TransportVo vo = new TransportVo();

        vo.setId(po.getTransportId());
        vo.setTransportName(po.getTransportName());
        vo.setTaxNumber(po.getTaxNumber());
        vo.setBank(po.getBank());
        vo.setBankNum(po.getBankNum());
        vo.setBankAccountNum(po.getBankAccountNum());
        vo.setRegisterAddr(po.getRegisterAddr());
        vo.setContactAddr(po.getContactAddr());
        vo.setContact(po.getContact());
        vo.setContactNum(po.getContactNum());
        vo.setEmail(po.getEmail());

        return vo;
    }

    public static List<TransportVo> toTransportVos(List<TransportationPo> pos) {
        List<TransportVo> vos = new ArrayList<>();
        for (TransportationPo po : pos) {
            TransportVo vo = toTransportVo(po);
            vos.add(vo);
        }

        return vos;
    }

    public static TransportationPo toTransportPo(TransportVo vo) {
        TransportationPo po = new TransportationPo();

        po.setTransportName(vo.getTransportName());
        po.setTaxNumber(vo.getTaxNumber());
        po.setBank(vo.getBank());
        po.setBankNum(vo.getBankNum());
        po.setBankAccountNum(vo.getBankAccountNum());
        po.setRegisterAddr(vo.getRegisterAddr());
        po.setContactAddr(vo.getContactAddr());
        po.setContact(vo.getContact());
        po.setContactNum(vo.getContactNum());
        po.setEmail(vo.getEmail());

        return po;
    }

    public static TransportationPo toTransportPo(TransportCreateVo vo) {
        TransportationPo po = new TransportationPo();

        po.setTransportName(vo.getTransportName());
        po.setTaxNumber(vo.getTaxNumber());
        po.setBank(vo.getBank());
        po.setBankNum(vo.getBankNum());
        po.setBankAccountNum(vo.getBankAccountNum());
        po.setRegisterAddr(vo.getRegisterAddr());
        po.setContactAddr(vo.getContactAddr());
        po.setContact(vo.getContact());
        po.setContactNum(vo.getContactNum());
        po.setEmail(vo.getEmail());

        return po;
    }

    public static void updateTransport(TransportUpdateVo vo, TransportationPo po) {
        po.setTransportName(checkIfNull(vo.getTransportName()) ? po.getTransportName() : vo.getTransportName());
        po.setTaxNumber(checkIfNull(vo.getTaxNumber()) ? po.getTaxNumber() : vo.getTaxNumber());
        po.setBank(checkIfNull(vo.getBank()) ? po.getBank() : vo.getBank());
        po.setBankNum(checkIfNull(vo.getBankNum()) ? po.getBankNum() : vo.getBankNum());
        po.setBankAccountNum(checkIfNull(vo.getBankAccountNum()) ? po.getBankAccountNum() : vo.getBankAccountNum());
        po.setRegisterAddr(checkIfNull(vo.getRegisterAddr()) ? po.getRegisterAddr() : vo.getRegisterAddr());
        po.setContactAddr(checkIfNull(vo.getContactAddr()) ? po.getContactAddr() : po.getContactAddr());
        po.setContact(checkIfNull(vo.getContact()) ? po.getContact() : vo.getContact());
        po.setContactNum(checkIfNull(vo.getContactNum()) ? po.getContactNum() : vo.getContactNum());
        po.setEmail(checkIfNull(vo.getEmail()) ? po.getEmail() : vo.getEmail());
    }

}
