package com.company.management_system.converter;

import com.company.management_system.model.entity.SupplierPo;
import com.company.management_system.model.vo.supplier.SupplierCreateVo;
import com.company.management_system.model.vo.supplier.SupplierUpdateVo;
import com.company.management_system.model.vo.supplier.SupplierVo;

import java.util.ArrayList;
import java.util.List;

import static com.company.management_system.utils.ErrorUtils.checkIfNull;

public class SupplierConverter {

    public static SupplierVo toSupplierVo(SupplierPo po) {
        SupplierVo vo = new SupplierVo();

        vo.setId(po.getSupplierId());
        vo.setSupplierName(po.getSupplierName());
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

    public static List<SupplierVo> toSupplierVos(List<SupplierPo> pos) {
        List<SupplierVo> res = new ArrayList<>();
        for (SupplierPo po : pos) {
            SupplierVo vo = toSupplierVo(po);
            res.add(vo);
        }

        return res;
    }

    public static SupplierPo toSupplierPo(SupplierVo vo) {
        SupplierPo po = new SupplierPo();
        po.setSupplierName(vo.getSupplierName());
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

    public static SupplierPo toSupplierPo(SupplierCreateVo vo) {
        SupplierPo po = new SupplierPo();
        po.setSupplierName(vo.getSupplierName());
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

    public static void updateSupplier(SupplierUpdateVo vo, SupplierPo po) {
        po.setSupplierName(checkIfNull(vo.getSupplierName()) ? po.getSupplierName() : vo.getSupplierName());
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

    public static List<SupplierPo> toSupplierPos(List<SupplierVo> vos) {
        List<SupplierPo> res = new ArrayList<>();
        for (SupplierVo vo : vos) {
            SupplierPo po = toSupplierPo(vo);
            res.add(po);
        }
        return res;
    }

}
