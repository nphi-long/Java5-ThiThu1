package poly.sof302.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.sof302.entities.Monhoc;

@Repository
public interface IMonHocRepository extends JpaRepository<Monhoc, Integer> {
}
