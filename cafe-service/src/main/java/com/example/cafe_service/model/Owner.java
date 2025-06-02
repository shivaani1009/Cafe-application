@Entity
public class Owner{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer cafeId;
}