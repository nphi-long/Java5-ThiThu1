package poly.sof302.service;

import poly.sof302.entities.Lop;

import java.util.List;

public interface ILopService {
    List<Lop> findAll();
    void saveOrUpdate(Lop lop);
    Lop findById(Integer id);
}
