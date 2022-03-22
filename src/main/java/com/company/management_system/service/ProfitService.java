package com.company.management_system.service;

import com.company.management_system.model.vo.profit.ProfitFilterVo;
import com.company.management_system.model.vo.profit.ProfitVo;

public interface ProfitService {

    ProfitVo query(ProfitFilterVo profitFilterVo);

    ProfitVo create(String orderNum);

}
