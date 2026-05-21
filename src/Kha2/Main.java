package Kha2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Hiển thị MENU chuẩn theo mẫu của đề bài
            System.out.println("**************** MENU QUẢN LÝ ĐIỂM DANH ****************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhập id sinh viên : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập tên sinh viên:");
                    String name = scanner.nextLine();

                    Student newStudent = new Student(id, name);
                    manager.add(newStudent);
                    System.out.println("Sinh viên đã được thêm thành công.");
                    break;

                case 2:
                    manager.display();
                    System.out.println("Nhập id sinh viên cần sửa:");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();

                    int indexUpdate = manager.findIndexById(idUpdate);
                    if (indexUpdate != -1) {
                        System.out.println("Nhập tên mới sinh viên:");
                        String newName = scanner.nextLine();

                        Student updatedStudent = new Student(idUpdate, newName);
                        manager.update(indexUpdate, updatedStudent);
                        System.out.println("Sinh viên đã được sửa thành công.");
                    } else {
                        System.out.println("Không tìm thấy sinh viên có ID này.");
                    }
                    break;

                case 3:
                    manager.display();
                    System.out.println("Nhập id sinh viên cần xóa:");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();

                    int indexDelete = manager.findIndexById(idDelete);
                    if (indexDelete != -1) {
                        manager.delete(indexDelete);
                        System.out.println("Đã xóa thành công sinh viên !");
                    } else {
                        System.out.println("Không tìm thấy sinh viên có ID này.");
                    }
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại (1-5)!");
            }
            System.out.println();
        } while (choice != 5);

        scanner.close();
    }
}
