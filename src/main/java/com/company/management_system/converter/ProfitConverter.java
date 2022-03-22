package com.company.management_system.converter;

import com.company.management_system.model.entity.ProfitPo;
import com.company.management_system.model.vo.profit.ProfitVo;

public class ProfitConverter {

    public static ProfitVo toProfitVo(ProfitPo po) {
        ProfitVo vo = new ProfitVo();
        vo.setOrderNum(po.getOrderNum());
        vo.setDate(po.getDate());
        vo.setClient(po.getClient());
        vo.setSalePrice(po.getSalePrice());
        vo.setSuppliers(po.getSuppliers());
        vo.setPurchasePrice(po.getPurchasePrice());
        vo.setTransport(po.getTransport());
        vo.setTransportationFee(po.getTransportationFee());
        vo.setOtherFee(po.getOtherFee());
        vo.setProfits(po.getProfits());
        vo.setIsDone(po.getIsDone());
        vo.setNotes(po.getNotes());

        return vo;
    }

}
