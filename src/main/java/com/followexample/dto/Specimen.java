package com.followexample.dto;


import lombok.Data;

public @Data
class Specimen {
    private int plantID;
    private String specimenId;
    private String latitude;
    private String longitude;
    private String description;
}
