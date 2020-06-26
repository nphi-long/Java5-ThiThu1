package poly.sof302.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import poly.sof302.entities.Lop;
import poly.sof302.entities.Monhoc;
import poly.sof302.entities.Sinhvien;
import poly.sof302.model.DiemTBLop;
import poly.sof302.model.DiemTBSinhVien;
import poly.sof302.service.ILopService;
import poly.sof302.service.ISinhVienService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ILopService lopService;
    @Autowired
    private ISinhVienService svService;

    @GetMapping(value = {"", "/", "/lop"})
    public String home(ModelMap model) {
        List<Lop> lopList = lopService.findAll();
        model.addAttribute("lopList", lopList);
        model.addAttribute("lop", new Lop());
        return "Lop";
    }

    @PostMapping("/add")
    public String addLop(@ModelAttribute("lop") Lop lop) {
        lopService.saveOrUpdate(lop);
        return "redirect:/lop";
    }

    @GetMapping("/lop/{id}")
    public String sinhVienPage(@PathVariable("id") Integer id, ModelMap model) {
        Lop lop = lopService.findById(id);
        model.addAttribute("lop", lop.getTenlop()); // Lấy tên lớp

        int dem;
        double diem;

        List<DiemTBSinhVien> diemTBList = new ArrayList<DiemTBSinhVien>();
        for (Sinhvien sv : lop.getSinhviens()) {
            dem = 0;
            diem = 0;
            for (Monhoc mh : sv.getMonhocs()) {
                diem += mh.getDiem();
                dem++;
            }
            DiemTBSinhVien diemTB = new DiemTBSinhVien();
            diemTB.setDiem(diem / dem);
            diemTB.setSv(sv);
            diemTBList.add(diemTB);
        }
        model.addAttribute("diemTB", diemTBList);
        return "SinhVien";
    }

    @GetMapping("/detail/{id}")
    public String diemChiTiet(@PathVariable("id") Integer id, ModelMap model) {
        Sinhvien sv = svService.findById(id);
        List<Monhoc> monhocList = (List<Monhoc>) sv.getMonhocs();
        model.addAttribute("tenSV", sv.getTensv());
        model.addAttribute("monHocList", monhocList);
        return "DiemChiTiet";
    }
}
