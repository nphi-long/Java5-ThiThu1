package poly.sof302.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.sof302.entities.Monhoc;
import poly.sof302.repository.IMonHocRepository;

import java.util.Optional;

@Service
public class MonHocService implements IMonHocService{
    @Autowired
    IMonHocRepository monHocRepo;

    @Override
    public Monhoc findById(Integer id) {
        Optional<Monhoc> monHoc = monHocRepo.findById(id);
        if(monHoc.isPresent()){
            Monhoc monHocOut = monHoc.get();
            return monHocOut;
        }
        return null;
    }
}
