package poly.sof302.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.sof302.entities.Sinhvien;
import poly.sof302.repository.ISinhVienRepository;

import java.util.Optional;

@Service
public class SinhVienService implements ISinhVienService{
    @Autowired
    ISinhVienRepository svRepo;

    @Override
    public Sinhvien findById(Integer id) {
        Optional<Sinhvien> sv = svRepo.findById(id);
        if(sv.isPresent()){
            Sinhvien svOut = sv.get();
            return svOut;
        }
        return null;
    }
}
