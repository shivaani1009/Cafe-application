package com.example.availability_service.service;

import com.example.availability_service.dto.TableDto;
import com.example.availability_service.repository.TableRepository;
import org.springframework.stereotype.Service;
@Service
public class TableService {

    private final TableRepository tableRepository;

    // Constructor injection
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public CompletableFuture<TableDto> getTableById(Integer cafeId ,Integer tableId) {
        return tableRepository.findById(cafeId, tableId)
                .thenApply(table -> {
                    if (table != null) {
                        return new TableDto(table.getId(), table.getAvailable(), table.getSeats());
                    } else {
                        return null; // or throw an exception if preferred
                    }
                });
    }

    public CompletableFuture<Void> saveTable(Integer cafeId, Integer tableId, TableDto tableDto) {
        return tableRepository.save(cafeId, tableId, tableDto.getIsAvailable(), tableDto.getSeats());
    }
    public CompletableFuture<Void> deleteTable(Integer cafeId, Integer tableId) {
        return tableRepository.delete(cafeId, tableId);
    }
    public CompletableFuture<Void> addTables(Integer cafeId, Map<Integer, TableDto> tablesData){
        Map<Integer, Table> tableEntities = new HashMap<>();
        for (Map.Entry<Integer, TableDto> entry : tablesData.entrySet()){
            TableDto tableDto = entry.getValue();
            tableEntities.put(entry.getKey(), new Table (tableDto.getTableId(), tableDto.getIsAvailable(), tableDto.getSeats()));
        }
        return tableRepository.addTables(cafeId, tableEntities);
    }
}