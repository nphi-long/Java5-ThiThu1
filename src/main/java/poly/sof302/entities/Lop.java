package poly.sof302.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer malop;
    private String tenlop;
    @OneToMany(mappedBy = "lop", cascade = CascadeType.ALL)
    private Collection<Sinhvien> sinhviens;
}
