package com.example.availability_service.controller;

import java.util.concurrent.CompletableFuture;
import com.example.availability_service.service.TableService;
import org.springframework.web.bind.annotation.*;
import com.example.availability_service.dto.TableDto;
import com.example.availability_service.exceptions.ResourceNotFoundException;
import java.util.Map;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@RestController
@RequestMapping("/v1/cafes/{cafeId}")
public class TableController {

    private final TableService tableService;

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

    @PostMapping("/addTable")
    public CompletableFuture<Void> saveTable(@PathVariable Integer cafeId, @RequestBody TableDto tableDto){
        return tableService.saveTable(cafeId, tableDto)
                .thenAccept(aVoid -> System.out.println("Table saved successfully"));
    }

    @DeleteMapping("/{tableId}")
    public CompletableFuture<Void> deleteTable(@PathVariable Integer cafeId, @PathVariable Integer tableId) {
        return tableService.deleteTable(cafeId, tableId)
                .thenAccept(aVoid -> System.out.println("Table deleted successfully"));
    }

    @PostMapping("/addTables")
    public CompletableFuture<Void> addTables(@PathVariable Integer cafeId,  @RequestBody Map<Integer, TableDto> tablesData){
        return tableService.addTables(cafeId, tablesData)
                .thenAccept(aVoid -> System.out.println("Tables added successfully"));
    }

    @GetMapping("/test-firebase")
    public String testFirebaseConnectivity(){
        try{
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("test-node");
            ref.setValueAsync("Hello from SpringBoot!");
            return "Firebase Write Initiated!";
        }catch(Exception e){
            e.printStackTrace();
            return "Firebase write failed!!"+e.getMessage();
        }
    }
}
