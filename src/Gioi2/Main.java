package Gioi2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**************** MENU QUẢN LÝ ĐƠN HÀNG ****************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn:");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            if (choice == 1) {
                String orderCode;
                while (true) {
                    System.out.println("Nhập mã đơn hàng:");
                    orderCode = scanner.nextLine();
                    if (orderCode.trim().isEmpty()) {
                        System.out.println("\nVui lòng ko để trống !");
                    } else {
                        break;
                    }
                }
                System.out.println("Nhập tên khách hàng:");
                String customerName = scanner.nextLine();
                manager.add(new Order(orderCode, customerName));
                System.out.println("Đơn hàng đã được thêm thành công.");
            } else if (choice == 2) {
                manager.display();
                System.out.println("Nhập mã đơn hàng cần sửa:");
                String orderCode = scanner.nextLine();
                int index = manager.findIndexByCode(orderCode);
                if (index != -1) {
                    System.out.println("Nhập tên khách hàng mới:");
                    String newName = scanner.nextLine();
                    manager.update(index, new Order(orderCode, newName));
                    System.out.println("Đơn hàng đã được sửa thành công.");
                }
            } else if (choice == 3) {
                manager.display();
                System.out.println("Nhập mã đơn hàng cần xóa:");
                String orderCode = scanner.nextLine();
                int index = manager.findIndexByCode(orderCode);
                if (index != -1) {
                    manager.delete(index);
                    System.out.println("Đơn hàng đã được xóa thành công.");
                }
            } else if (choice == 4) {
                manager.display();
            } else if (choice == 5) {
                break;
            }
        }
        scanner.close();
    }
}
