import java.util.Scanner;

public class MenuHocSinh {
    public void menu() {
        HamChucNang hamChucNang = new HamChucNang();
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN");
            System.out.println("Chọn chức năng theo số (để tiếp tục");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Sửa sinhVien");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < 0 || number > 8) {
                    System.out.println("Nhập số từ 1-8");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Nhập Chữ Số Từ 1-8");
                continue;
            }
            switch (number) {
                case 1:
                    hamChucNang.hienThi();
                    break;
                case 2:
                    hamChucNang.themSinhVien();
                    break;
                case 3:
                    hamChucNang.suaSinhVien();
                    break;
                case 4:
                    hamChucNang.xoaSinhVien();
                    break;
                case 5:
                    hamChucNang.sapXep();
                    break;
                case 6:
                   hamChucNang.docFile();
                    break;
                case 7:
                    hamChucNang.ghiFile();
                    break;
                case 8:
                    return;
            }
        }
    }
}
