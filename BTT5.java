import java.util.ArrayList;
import java.util.Scanner;
public class BTT5 {
    private static final Scanner sc = new Scanner(System.in);
    // BTT6 - Bai 1: Mang so luong cua 5 cuon sach.
    private static final int[] soLuong = new int[5];
    // BTT6 - Bai 2: Danh sach ma sach dung ArrayList<String>.
    private static final ArrayList<String> maSach = new ArrayList<>();
    // BTT5, BTT6 - Bai 3, Bai 4: Moi chuoi luu ma, ten, so luong va don gia cua mot sach.
    private static final ArrayList<String> danhSachSach = new ArrayList<>();
    public static void main(String[] args) {
        int chon;
        do {
            //BTT5 - Bai 3, BTT6 - Bai 4: Menu lap den khi chon thoat.
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.println("9. BTT6 - Bai 1: Mang so luong 5 cuon sach");
            System.out.println("10. BTT6 - Bai 2: Quan ly ma sach");
            System.out.println("11. BTT5 - Mo menu bai 1 den bai 4");
            chon = nhapSoNguyen("Chon: ");
            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timTheoMa();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 7:
                    tinhTongGiaTri();
                    break;
                case 8:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                case 9:
                    thucHienBai1();
                    break;
                case 10:
                    menuBai2();
                    break;
                case 11:
                    menuBTT5();
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 8);
    }

    // BTT5 - Bai 3: Menu lap den khi chon thoat.
    private static void menuBTT5() {
        int chon;
        do {
            System.out.println("\n===== BTT5 =====");
            System.out.println("1. Nhap n sach");
            System.out.println("2. Tinh tong so luong va tong gia tri sach");
            System.out.println("3. Tim sach theo ma");
            System.out.println("4. Thoat menu BTT5");
            chon = nhapSoNguyen("Chon: ");
            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    tinhTongSoLuong();
                    tinhTongGiaTri();
                    break;
                case 3:
                    timTheoMa();
                    break;
                case 4:
                    System.out.println("Da thoat menu BTT5.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 4);
    }

    // BTT6 - Bai 1: Nhap va xu ly so luong cua 5 cuon sach.
    private static void thucHienBai1() {
        System.out.println("\nBTT6 - BAI 1: NHAP SO LUONG 5 CUON SACH");
        for (int i = 0; i < soLuong.length; i++) {
            soLuong[i] = nhapSoNguyenKhongAm("So luong sach thu " + (i + 1) + ": ");
        }

        long tong = 0;
        int lonNhat = soLuong[0];
        System.out.print("So luong 5 cuon sach: ");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print(soLuong[i]);
            if (i < soLuong.length - 1) {
                System.out.print(", ");
            }
            tong += soLuong[i];
            if (soLuong[i] > lonNhat) {
                lonNhat = soLuong[i];
            }
        }
        System.out.println();
        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + lonNhat);
    }

    // BTT6 - Bai 2: Menu them, hien thi, tim va xoa ma sach.
    private static void menuBai2() {
        int chon;
        do {
            System.out.println("\nBTT6 - BAI 2: QUAN LY MA SACH");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("5. Quay lai menu chinh");
            chon = nhapSoNguyen("Chon: ");
            switch (chon) {
                case 1:
                    themMaSach();
                    break;
                case 2:
                    hienThiMaSach();
                    break;
                case 3:
                    timMaSach();
                    break;
                case 4:
                    xoaMaSach();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 5);
    }

    private static void themMaSach() {
        String ma = nhapChuoiBatBuoc("Nhap ma sach can them: ");
        if (timViTriMaSach(ma) >= 0) {
            System.out.println("Ma sach da ton tai.");
            return;
        }
        maSach.add(ma);
        System.out.println("Da them ma sach.");
    }

    private static void hienThiMaSach() {
        if (maSach.isEmpty()) {
            System.out.println("Danh sach ma sach dang trong.");
            return;
        }
        for (int i = 0; i < maSach.size(); i++) {
            System.out.println((i + 1) + ". " + maSach.get(i));
        }
    }

    private static void timMaSach() {
        String ma = nhapChuoi("Nhap ma sach can tim: ");
        int viTri = timViTriMaSach(ma);
        if (viTri < 0) {
            System.out.println("Khong tim thay ma sach " + ma);
        } else {
            System.out.println("Tim thay ma sach " + maSach.get(viTri));
        }
    }

    private static void xoaMaSach() {
        String ma = nhapChuoi("Nhap ma sach can xoa: ");
        int viTri = timViTriMaSach(ma);
        if (viTri < 0) {
            System.out.println("Khong tim thay ma sach " + ma);
            return;
        }
        String maDaXoa = maSach.remove(viTri);
        System.out.println("Da xoa ma sach " + maDaXoa);
    }

    private static int timViTriMaSach(String ma) {
        for (int i = 0; i < maSach.size(); i++) {
            if (maSach.get(i).equalsIgnoreCase(ma.trim())) {
                return i;
            }
        }
        return -1;
    }

    // BTT5 - Bai 1: Nhap n sach bang vong lap.
    private static void themSach() {
        int n;
        do {
            n = nhapSoNguyen("Nhap so sach can them: ");
            if (n <= 0) {
                System.out.println("So sach phai lon hon 0.");
            }
        } while (n <= 0);

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap sach thu " + (i + 1) + ":");
            themMotSach();
        }
    }

    // BTT6 - Bai 3: Them mot sach vao ArrayList<String>.
    private static void themMotSach() {
        String ma;
        while (true) {
            ma = nhapThongTinSach("Ma sach: ");
            if (ma.isEmpty()) {
                System.out.println("Ma sach khong duoc de trong.");
            } else if (timSach(ma) != null) {
                System.out.println("Ma sach da ton tai.");
            } else {
                break;
            }
        }

        String ten = nhapThongTinSach("Ten sach: ");
        int soLuong = nhapSoNguyenKhongAm("So luong: ");
        double donGia = nhapSoThucKhongAm("Don gia: ");
        danhSachSach.add(maHoaSach(new Sach(ma, ten, soLuong, donGia)));
        System.out.println("Da them sach.");
    }

    // BTT6(bai 3): Hien thi danh sach sach.
    private static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        for (String thongTinSach : danhSachSach) {
            inSach(giaiMaSach(thongTinSach));
        }
    }

    // BTT5: Tim sach theo ma; BTT6(bai 3): Tim sach trong ArrayList.
    private static void timTheoMa() {
        String ma = nhapChuoi("Nhap ma sach can tim: ");
        Sach sach = timSach(ma);
        if (sach == null) {
            System.out.println("Khong tim thay sach co ma " + ma);
        } else {
            inSach(sach);
        }
    }

    // BTT6(bai 3): Xoa sach theo ma.
    private static void xoaSach() {
        String ma = nhapChuoi("Nhap ma sach can xoa: ");
        int viTri = timViTriSach(ma);
        if (viTri < 0) {
            System.out.println("Khong tim thay sach co ma " + ma);
            return;
        }
        Sach sach = giaiMaSach(danhSachSach.remove(viTri));
        System.out.println("Da xoa sach co ma " + sach.ma);
    }

    // BTT6(bai 3): Sua thong tin sach theo ma.
    private static void suaSach() {
        String ma = nhapChuoi("Nhap ma sach can sua: ");
        int viTri = timViTriSach(ma);
        if (viTri < 0) {
            System.out.println("Khong tim thay sach co ma " + ma);
            return;
        }

        Sach sach = giaiMaSach(danhSachSach.get(viTri));
        System.out.println("Nhap thong tin moi:");
        sach.ten = nhapThongTinSach("Ten sach: ");
        sach.soLuong = nhapSoNguyenKhongAm("So luong: ");
        sach.donGia = nhapSoThucKhongAm("Don gia: ");
        danhSachSach.set(viTri, maHoaSach(sach));
        System.out.println("Da cap nhat sach.");
    }

    // BTT5 - Bai 2, BTT6 - Bai 4: Tinh tong so luong sach.
    private static void tinhTongSoLuong() {
        long tongSoLuong = 0;
        for (String thongTinSach : danhSachSach) {
            Sach sach = giaiMaSach(thongTinSach);
            tongSoLuong += sach.soLuong;
        }
        System.out.println("Tong so luong sach: " + tongSoLuong);
    }

    // BTT5 - Bai 2, BTT6 - Bai 4: Tinh tong gia tri sach.
    private static void tinhTongGiaTri() {
        double tongGiaTri = 0;
        for (String thongTinSach : danhSachSach) {
            Sach sach = giaiMaSach(thongTinSach);
            tongGiaTri += sach.soLuong * sach.donGia;
        }
        System.out.printf("Tong gia tri sach: %.2f%n", tongGiaTri);
    }

    // BTT5, BTT6(bai 3): Ham dung chung tim sach trong ArrayList theo ma.
    private static Sach timSach(String ma) {
        int viTri = timViTriSach(ma);
        return viTri < 0 ? null : giaiMaSach(danhSachSach.get(viTri));
    }

    private static int timViTriSach(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            Sach sach = giaiMaSach(danhSachSach.get(i));
            if (sach.ma.equalsIgnoreCase(ma.trim())) {
                return i;
            }
        }
        return -1;
    }

    private static String maHoaSach(Sach sach) {
        return sach.ma + ";" + sach.ten + ";" + sach.soLuong + ";" + sach.donGia;
    }

    private static Sach giaiMaSach(String thongTinSach) {
        String[] thongTin = thongTinSach.split(";", -1);
        String ma = thongTin[0];
        String ten = thongTin[1];
        int soLuong = Integer.parseInt(thongTin[2]);
        double donGia = Double.parseDouble(thongTin[3]);
        return new Sach(ma, ten, soLuong, donGia);
    }

    // BTT5, BTT6(bai 3): In thong tin mot cuon sach.
    private static void inSach(Sach sach) {
        System.out.printf(
            "Ma: %s | Ten: %s | So luong: %d | Don gia: %.2f | Thanh tien: %.2f%n",
            sach.ma, sach.ten, sach.soLuong, sach.donGia,
            sach.soLuong * sach.donGia
        );
    }

    // BTT5, BTT6(bai 3, bai 4): Cac ham nhap va kiem tra du lieu dung chung.
    private static String nhapChuoi(String thongBao) {
        System.out.print(thongBao);
        return sc.nextLine().trim();
    }

    private static String nhapChuoiBatBuoc(String thongBao) {
        String giaTri;
        do {
            giaTri = nhapChuoi(thongBao);
            if (giaTri.isEmpty()) {
                System.out.println("Thong tin khong duoc de trong.");
            }
        } while (giaTri.isEmpty());
        return giaTri;
    }

    private static String nhapThongTinSach(String thongBao) {
        while (true) {
            String giaTri = nhapChuoiBatBuoc(thongBao);
            if (!giaTri.contains(";")) {
                return giaTri;
            }
            System.out.println("Thong tin sach khong duoc chua dau cham phay.");
        }
    }

    private static int nhapSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le.");
            }
        }
    }

    private static int nhapSoNguyenKhongAm(String thongBao) {
        int giaTri;
        do {
            giaTri = nhapSoNguyen(thongBao);
            if (giaTri < 0) {
                System.out.println("Gia tri khong duoc am.");
            }
        } while (giaTri < 0);
        return giaTri;
    }

    private static double nhapSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                double giaTri = Double.parseDouble(sc.nextLine().trim());
                if (Double.isNaN(giaTri) || Double.isInfinite(giaTri)) {
                    System.out.println("Vui long nhap so hop le.");
                    continue;
                }
                return giaTri;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }
    }

    private static double nhapSoThucKhongAm(String thongBao) {
        double giaTri;
        do {
            giaTri = nhapSoThuc(thongBao);
            if (giaTri < 0) {
                System.out.println("Gia tri khong duoc am.");
            }
        } while (giaTri < 0);
        return giaTri;
    }

    // BTT5, BTT6(bai 3, bai 4): Lop mo ta thong tin cua mot cuon sach.
    private static class Sach {
        String ma;
        String ten;
        int soLuong;
        double donGia;
        Sach(String ma, String ten, int soLuong, double donGia) {
            this.ma = ma;
            this.ten = ten;
            this.soLuong = soLuong;
            this.donGia = donGia;
        }
    }
}