package com.px.device.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class AirportDto {
    private String domain;
    private int type;
    private int sub_type;
    private String device_secret;
    private String nonce;
    private String thing_version;
    private List<SubDevices> sub_devices;

}
