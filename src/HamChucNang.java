import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HamChucNang {
    Scanner scanner = new Scanner(System.in);
    ReadAndWrite readAndWrite = new ReadAndWrite();
    File file = new File("D:\\Codegym\\ThucHanh\\Case_2_bai_thi\\src\\File_Doc.CSV");
    ArrayList<SinhVien> sinhViens = readAndWrite.read(file);

    public void hienThi() {
        for (int i = 0; i < sinhViens.size(); i++) {
            System.out.println(sinhViens.get(i).toString());
        }
    }

    public int checkMaSV(int maSV) {
        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getMaSV() == maSV) {
                return i;
            }
        }
        return -1;
    }

    public SinhVien taoSinhVien() {
        int maSv;
        String hoTen;
        int tuoi;
        String gioiTinh;
        String diaCHi;
        int diemTrungBinh;

        while (true) {
            try {
                System.out.println("Nhập ma sinh vien :");
                maSv = Integer.parseInt(scanner.nextLine());
                int index = checkMaSV(maSv);
                if (index == -1) {
                    break;
                }

            } catch (Exception e) {
                System.err.println("Ma sinh vien phải là một số nguyên");
                continue;
            }
            System.err.println("Ma Sinh Vien đã tồn tại!");
        }
        System.out.println("Nhập tên Sinh Vien: ");
        hoTen = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Nhập tuoi");
                tuoi = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("nhap so tuoi nguyen");
                continue;
            }
            break;
        }

        while (true) {
            try {
                System.out.println("Nhập gioi tinh");
                gioiTinh = (scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Gioi tinh la nam / nu / khac");
                continue;
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Nhập số dia chi");
                diaCHi = scanner.nextLine();
            } catch (Exception e) {
                System.err.println("nhap lai dia chi");
                continue;
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Nhập DIem trung binh");
                diemTrungBinh = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Số lượng là số nguyên, không được chứa chữ");
                continue;
            }
            break;
        }
        SinhVien sinhVien1 = new SinhVien(maSv, hoTen, tuoi, gioiTinh, diaCHi, diemTrungBinh);
        System.out.println(sinhVien1);
        return sinhVien1;
    }

    public void themSinhVien() {
        sinhViens.add(taoSinhVien());
        readAndWrite.write(file, sinhViens);
    }

    public void suaSinhVien() {
        int maSinhVien;
        while (true) {
            try {
                System.out.println("Nhập ma sinh vien muốn sửa: ");
                maSinhVien = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("ma sinh vien là số nguyên, không chứa chữ cái");
            }
        }
        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getMaSV() == maSinhVien) {
                sinhViens.set(i, taoSinhVien());
                return;
            }
        }
        System.err.println("Không tồn tại ma sinh vien này");
    }

    public void xoaSinhVien() {
        int maSinhVien = 0;
        while (true) {
            try {
                System.out.println("Nhập ma sinh vien muốn xoa: ");
                maSinhVien = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("ma sinh vien là số nguyên, không chứa chữ cái");
            }
            break;
        }
        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getMaSV() == maSinhVien) {
                sinhViens.remove(i);
                break;
            }
        }
    }

    public void sapXep() {
        int choice = 3;
        System.out.println("1. Diem tang dần");
        System.out.println("2. Diem giam dần");
        System.out.println("3. Thoat");
        System.out.println("Nhập số để lựa chọn: ");
        do {
            if (choice > 3) {
                System.err.println("Chỉ chọn 1 or 2 or 3");
            }
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice > 3);
        Collections.sort(sinhViens);
        switch (choice) {
            case 1:
                for (SinhVien pt : sinhViens) {
                    System.out.println(pt);
                }
                break;
            case 2:
                for (int i = sinhViens.size() - 1; i >= 0; i--) {
                    System.out.println(sinhViens.get(i));
                }
                break;
            case 3:
                return;
        }
    }
}

