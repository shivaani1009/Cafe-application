package com.example.availability_service.repository;

//add or update a table in a cafe
public CompletableFuture<Void> save(Integer cafeId, Integer tableId, Boolean isAvailable, Integer seats){
    CompletableFuture<Void> future = new CompletableFuture<>();
    DatabaseReference tableRef = dbRef.child(cafeId.toString()).child("tables").child(tableId.toString());
    Map<String,Object> tableData = new HashMap<>();
    tableData.put("Available", isAvailable);
    tableData.put("seats", seats);
    tableRef.setValue(tableData, (error, ref) -> {
        if (error != null) {
            future.completeExceptionally(error.toException());
        } else {
            future.complete(null);
        }

    });

    return future;
}
//find a table
public CompletableFuture<Table> findById(Integer cafeId, Integer tableId) {
    CompletableFuture<Table> future = new CompletableFuture<>();
    DatabaseReference tableRef = dbRef.child(cafeId.toString()).child("tables").child(tableId.toString());
    
    tableRef.get().addOnCompleteListener(task -> {
        if (task.isSuccessful()) {
            DataSnapshot snapshot = task.getResult();
            if (snapshot.exists()) {
                Table table = snapshot.getValue(Table.class);
                future.complete(table);
            } else {
                future.complete(null);
            }
        } else {
            future.completeExceptionally(task.getException());
        }
    });

    return future;
}
//remove a table
public CompletableFuture<Void> delete(Integer cafeId, Integer tableId) {
    CompletableFuture<Void> future = new CompletableFuture<>();
    DatabaseReference tableRef = dbRef.child(cafeId.toString()).child("tables").child(tableId.toString());
    
    tableRef.removeValue().addOnCompleteListener(task -> {
        if (task.isSuccessful()) {
            future.complete(null);
        } else {
            future.completeExceptionally(task.getException());
        }
    });

    return future;
}

//add multiple tables at once for a new cafe
public CompletableFuture<Void> addTables(Integer cafeId, Map<Integer, Table> tablesData){
    CompletableFuture<Void> future = new CompletableFuture<>();
    for (Map.Entry<Integer, Table> entry : tablesData.entrySet()) {
        Integer tableId = entry.getKey();
        Table table = entry.getValue();
        
        DatabaseReference tableRef = dbRef.child(cafeId.toString()).child("tables").child(tableId.toString());
        Map<String, Object> tableData = new HashMap<>();
        tableData.put("Available", table.getIsAvailable());
        tableData.put("seats", table.getSeats());
        
        tableRef.setValue(tableData, (error, ref) -> {
            if (error != null) {
                future.completeExceptionally(error.toException());
            }
        });
    }
    return future;
}