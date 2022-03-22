package com.company.management_system.service.Impl;

import com.company.management_system.exception.TransportException;
import com.company.management_system.model.entity.TransportationPo;
import com.company.management_system.model.vo.transport.TransportCreateVo;
import com.company.management_system.model.vo.transport.TransportUpdateVo;
import com.company.management_system.model.vo.transport.TransportVo;
import com.company.management_system.repository.TransportRepository;
import com.company.management_system.service.TransportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.company.management_system.constants.ErrorType.TRANSPORT_ALREADY_EXISTS;
import static com.company.management_system.constants.ErrorType.TRANSPORT_NOT_EXISTS;
import static com.company.management_system.converter.TransportConverter.*;

@Service
public class TransportServiceImpl implements TransportService {

    @Resource
    private TransportRepository transportRepository;

    public TransportationPo getOne(String transportName) {
        try {
            List<TransportationPo> pos = transportRepository.findByTransportName(transportName);
            return pos.get(0);
        } catch (Exception e) {
            throw new TransportException(TRANSPORT_NOT_EXISTS);
        }
    }

    public TransportationPo getOne(Long transportId) {
        TransportationPo po = transportRepository.findByTransportId(transportId);
        if (null == po) {
            throw new TransportException(TRANSPORT_NOT_EXISTS);
        }

        return po;
    }

    @Override
    public TransportVo create(TransportCreateVo transportCreateVo) {
        if (transportRepository.existsByTransportName(transportCreateVo.getTransportName())) {
            throw new TransportException(TRANSPORT_ALREADY_EXISTS);
        }
        TransportationPo po = toTransportPo(transportCreateVo);
        transportRepository.save(po);
        return toTransportVo(po);
    }

    @Override
    public TransportVo getByName(String transportName) {
        return toTransportVo(getOne(transportName));
    }

    @Override
    public TransportVo getById(Long transportId) {
        return toTransportVo(getOne(transportId));
    }

    @Override
    public List<TransportVo> getAll() {
        return toTransportVos(transportRepository.findAll());
    }

    @Override
    public TransportVo update(TransportUpdateVo transportUpdateVo, Long transportId) {
        TransportationPo po = getOne(transportId);
        updateTransport(transportUpdateVo, po);
        transportRepository.save(po);
        return toTransportVo(po);
    }

    @Override
    public void deleteByName(String transportName) {
        TransportationPo po = getOne(transportName);
        try {
            transportRepository.delete(po);
        } catch (Exception e) {
            throw new TransportException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long transportId) {
        TransportationPo po = getOne(transportId);
        try {
            transportRepository.delete(po);
        } catch (Exception e) {
            throw new TransportException(e.getMessage());
        }
    }

}
