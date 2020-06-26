package poly.sof302.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.sof302.entities.Sinhvien;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiemTB {
    private Sinhvien sv;
    private Double diem;
}
