package com.example.availability_service.controller;

import com.example.availability_service.service.TableService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cafes/{cafeId}")
public class TableController {
    private final TableService tableService;

    //constructor
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/{tableId}")
    public CompletableFuture<TableDto> getTableById(@PathVariable Integer cafeId, @PathVariable Integer tableId) {
        return tableService.getTableById(cafeId, tableId)
                .thenApply(tableDto -> {
                    if (tableDto != null) {
                        return tableDto;
                    } else {
                        throw new ResourceNotFoundException("Table not found");
                    }
                });
    }

    @PostMapping
    public CompletableFuture<Void> saveTable(@PathVariable Integer cafeId, @PathVariable Integer tableId, @RequestBody TableDto tableDto){
        return tableService.saveTable(cafeId, tableId, tableDto)
                .thenAccept(aVoid -> {
                    if (aVoid) {
                        System.out.println("Table saved successfully");
                    }
                    else {
                        throw new RuntimeException("Failed to save table");
                    }
                });
    }
    @DeleteMapping("/{tableId}")
    public CompletableFuture<Void> deleteTable(@PathVariable Integer cafeId, @PathVariable Integer tableId) {
        return tableService.deleteTable(cafeId, tableId)
                .thenAccept(aVoid -> {
                    if (aVoid) {
                        System.out.println("Table deleted successfully");
                    } else {
                        throw new RuntimeException("Failed to delete table");
                    }
                });
    }
    @PostMapping("/addTables")
    public CompletableFuture<Void> addTables(@PathVariable Integer cafeId,  @RequestBody Map<Integer, TableDto> tablesData){
        return tableSerivice.addTables(cafeId, tablesData)
                .thenAccept(aVoid -> {
                    if (aVoid){
                        System.out.println("Tables added successfully");
                    }else{
                        throw new RuntimeException("Failed to add tables");
                    }
                });
    }


}