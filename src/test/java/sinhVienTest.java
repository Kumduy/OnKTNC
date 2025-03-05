import duy.poly.ontapkkiemthu.testOne.SinhVien;
import duy.poly.ontapkkiemthu.testOne.SinhVienService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class sinhVienTest {
    private SinhVienService sinhVienService;
    private SinhVien sinhVien;
    @BeforeEach
    void SetUp()
    {
        sinhVienService = new SinhVienService();
        sinhVien = new SinhVien("SV001", "Nguyen Van A", 20, 7.5f, 3, "CNTT");
    }

    @Test
    public void testSuaSinhVien_HopLe() {
        SinhVien sv = new SinhVien("SV001", "Nguyen Van A", 20, 7.5f, 3, "CNTT");
        sinhVienService.suaSinhVien(sv, "Le Van B", 21, 8.0f, 4, "Kinh tế");
        Assertions.assertEquals("Le Van B", sv.getTen());
        Assertions.assertEquals(21, sv.getTuoi());
        Assertions.assertEquals(8.0f, sv.getDiemTrungBinh());
        Assertions.assertEquals(4, sv.getKyHoc());
        Assertions.assertEquals("Kinh tế", sv.getChuyenNganh());
    }

    @Test
    public void testSuaSinhVien_TenRong() {
        SinhVien sv = new SinhVien("SV002", "Nguyen Van C", 22, 6.5f, 5, "Kỹ thuật");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                sinhVienService.suaSinhVien(sv, "", 22, 6.5f, 5, "Kỹ thuật"));
    }

    @Test
    public void testSuaSinhVien_TuoiNgoaiKhoang() {
        SinhVien sv = new SinhVien("SV003", "Nguyen Van D", 19, 9.0f, 2, "Cơ khí");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                sinhVienService.suaSinhVien(sv, "Tran Van E", 17, 9.0f, 2, "Cơ khí"));
    }

    @Test
    public void testSuaSinhVien_DiemTrungBinhNgoaiKhoang() {
        SinhVien sv = new SinhVien("SV004", "Nguyen Van F", 23, 5.0f, 6, "Y học");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                sinhVienService.suaSinhVien(sv, "Tran Van G", 23, 10.5f, 6, "Y học"));
    }

    @Test
    public void testSuaSinhVien_KyHocNgoaiKhoang() {
        SinhVien sv = new SinhVien("SV005", "Nguyen Van H", 25, 7.2f, 3, "Xây dựng");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                sinhVienService.suaSinhVien(sv, "Tran Van I", 25, 7.2f, 13, "Xây dựng"));
    }

    @Test
    public void testSuaSinhVien_ChuyenNganhRong() {
        SinhVien sv = new SinhVien("SV006", "Nguyen Van J", 26, 7.0f, 8, "Nông nghiệp");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                sinhVienService.suaSinhVien(sv, "Le Van K", 26, 7.0f, 8, ""));
    }

    @Test
    public void testSuaSinhVien_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                sinhVienService.suaSinhVien(null, "Le Van L", 27, 7.5f, 4, "Điện tử"));
    }
}
