package poly.sof302.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.sof302.entities.Sinhvien;

@Repository
public interface ISinhVienRepository extends JpaRepository<Sinhvien, Integer> {

}
