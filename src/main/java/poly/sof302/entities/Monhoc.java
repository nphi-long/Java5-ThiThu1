package poly.sof302.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monhoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mamon;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "masv")
    private Sinhvien sinhvien;
    private Double diem;
}
