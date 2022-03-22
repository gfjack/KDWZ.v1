package com.company.management_system.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    CLIENT_NOT_EXISTS(HttpStatus.NOT_FOUND, "客户不存在"),
    ORDER_NOT_EXISTS(HttpStatus.NOT_FOUND,"订单不存在"),
    ORDER_DETAIL_NOT_EXISTS(HttpStatus.NOT_FOUND,"详细订单不存在"),
    SUPPLIER_NOT_EXISTS(HttpStatus.NOT_FOUND,"供应商不存在"),
    TRANSPORT_NOT_EXISTS(HttpStatus.NOT_FOUND,"运输不存在"),

    CLIENT_ALREADY_EXISTS(HttpStatus.NOT_FOUND, "客户已经存在"),
    ORDER_ALREADY_EXISTS(HttpStatus.NOT_FOUND,"订单已经存在"),
    SUPPLIER_ALREADY_EXISTS(HttpStatus.NOT_FOUND,"供应商已经存在"),
    TRANSPORT_ALREADY_EXISTS(HttpStatus.NOT_FOUND,"运输已经存在"),

    REQUEST_PARAMS_ERROR(HttpStatus.BAD_REQUEST, "请求参数错误");

    private final HttpStatus status;
    private final String message;


}
