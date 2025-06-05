package com.example.availability_service.dto;

public class TableDto{
    private Integer id;
    private Boolean isAvailable;
    private Integer seats;    

    public TableDto(Integer id, Boolean isAvailable, Integer seats) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.seats = seats;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getSeats() {
        return seats;
    }   
    
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

}