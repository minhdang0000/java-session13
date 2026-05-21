package Kha1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Person> persons = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("************ MENU QUẢN LÝ NGƯỜI DÙNG ************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            switch(choice){
                case 1:{
                    System.out.print("Nhập tên người dùng: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập email người dùng: ");
                    String email = sc.nextLine();
                    System.out.print("Nhập số điện thoại người dùng: ");
                    String phone = sc.nextLine();
                    persons.add(new Person(name, email, phone));
                    System.out.println("Người dùng đã được thêm thành công.\n");
                    break;
                }
                case 2:{
                    System.out.print("Nhập email người dùng để xóa: ");
                    String emailToDelete = sc.nextLine().trim();
                    boolean isRemoved = false;
                    for (Person p : persons) {
                        if (p.getEmail().equalsIgnoreCase(emailToDelete)) {
                            persons.remove(p);
                            isRemoved = true;
                            break;
                        }
                    }
                    if (isRemoved) {
                        System.out.println("Người dùng đã được xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy người dùng có email này.\n");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Danh sách người dùng:");
                    if (persons.isEmpty()) {
                        System.out.println("(Danh sách hiện đang trống)");
                    } else {
                        for (Person p : persons) {
                            System.out.println(p);
                        }
                        System.out.println();
                    }
                    break;
                }
                case 4:{
                    System.out.println("Đã thoát chương trình.");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
                    break;
                }
            }
            choice = Integer.parseInt(sc.nextLine());
        }while (choice != 4);
    }
}
