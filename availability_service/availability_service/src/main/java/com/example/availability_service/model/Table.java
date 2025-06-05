package.com.example.availability_service.model;
import jakarta.persistence.*;

@Entity
public class Table{
    @Id
    private Integer tableId;
    private Boolean isAvailable;
    private Integer seats;
    
    public Table() {
    }

    public Table(Integer tableId, Boolean isAvailable, Integer seats) {
        this.tableId = tableId;
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
