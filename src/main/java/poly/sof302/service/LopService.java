package poly.sof302.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.sof302.entities.Lop;
import poly.sof302.repository.ILopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LopService implements ILopService {
    @Autowired
    private ILopRepository lopRepo;

    @Override
    public List<Lop> findAll() {
        return lopRepo.findAll();
    }

    @Override
    public void saveOrUpdate(Lop lop) {
        lopRepo.save(lop);
    }

    @Override
    public Lop findById(Integer id) {
        Optional<Lop> lop = lopRepo.findById(id);
        if (lop.isPresent()) {
            Lop lopOut = lop.get();
            return lopOut;
        } else
            return null;
    }
}
