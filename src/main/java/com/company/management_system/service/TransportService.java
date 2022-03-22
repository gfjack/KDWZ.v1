package com.company.management_system.service;

import com.company.management_system.model.vo.transport.TransportCreateVo;
import com.company.management_system.model.vo.transport.TransportUpdateVo;
import com.company.management_system.model.vo.transport.TransportVo;

import java.util.List;

public interface TransportService {

    TransportVo create(TransportCreateVo transportCreateVo);

    TransportVo getByName(String transportName);

    TransportVo getById(Long transportId);

    List<TransportVo> getAll();

    TransportVo update(TransportUpdateVo transportUpdateVo, Long transportId);

    void deleteByName(String transportName);

    void deleteById(Long transportId);

}
