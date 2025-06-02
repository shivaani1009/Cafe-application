@Entity
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    private String latitude;
    private String longitude;
    @ElementCollection
    private List<String> tags;
}