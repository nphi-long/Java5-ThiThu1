package poly.sof302.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.sof302.entities.Lop;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiemTBLop {
    private Lop lop;
    private Double diem;
}
