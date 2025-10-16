package com.example.availability_service.dto;
import com.example.availability_service.model.Table;
public class TableDto{
    private Integer tableId;
    private Boolean isAvailable;
    private Integer seats;    

    public TableDto(Integer tableId, Boolean isAvailable, Integer seats) {
        this.tableId = tableId;
        this.isAvailable = isAvailable;
        this.seats = seats;
    }

    public TableDto(){}

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