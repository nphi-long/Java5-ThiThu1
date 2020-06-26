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
public class Sinhvien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer masv;
    private String tensv;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "malop")
    private Lop lop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvien")
    private Collection<Monhoc> monhocs;
}
