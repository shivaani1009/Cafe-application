package com.example.availability_service.mapper;
import com.example.availability_service.model.Table;
import com.example.availability_service.dto.TableDto;

public class TableMapper{
    private TableMapper(){

    }

    public static TableDto toDto(Table table){
        TableDto tableDto = new TableDto();
        tableDto.setTableId(table.getTableId());
        tableDto.setIsAvailable(table.getIsAvailable());
        tableDto.setSeats(table.getSeats());
        return tableDto;
    }

    public static Table toEntity(TableDto tableDto){
        Table table = new Table();
        table.setTableId(tableDto.getTableId());
        table.setIsAvailable(tableDto.getIsAvailable());
        table.setSeats(tableDto.getSeats());
        return table;
    }

}

