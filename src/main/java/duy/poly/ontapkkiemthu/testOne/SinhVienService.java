package duy.poly.ontapkkiemthu.testOne;

public class SinhVienService {
    public void suaSinhVien(SinhVien sv, String tenMoi, int tuoiMoi, float diemMoi, int kyMoi, String chuyenNganhMoi) {
        if (sv == null || tenMoi == null || chuyenNganhMoi == null || tenMoi.isEmpty() || chuyenNganhMoi.isEmpty()) {
            throw new IllegalArgumentException("Thông tin không hợp lệ");
        }
        if (tuoiMoi < 18 || tuoiMoi > 30 || diemMoi < 0.0f || diemMoi > 10.0f || kyMoi < 1 || kyMoi > 8) {
            throw new IllegalArgumentException("Dữ liệu nhập vào không hợp lệ");
        }
        sv.ten = tenMoi;
        sv.tuoi = tuoiMoi;
        sv.diemTrungBinh = diemMoi;
        sv.kyHoc = kyMoi;
        sv.chuyenNganh = chuyenNganhMoi;
    }

}