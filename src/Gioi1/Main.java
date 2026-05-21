package Gioi1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InvoiceManager manager = new InvoiceManager();
        Scanner scanner = new Scanner(System.in);
        int autoId = 1;

        while (true) {
            System.out.println("************ MENU QUẢN LÝ HÓA ĐƠN ************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn:");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            if (choice == 1) {
                System.out.println("Nhập mã hóa đơn:");
                String code = scanner.nextLine();
                while (code.trim().isEmpty()) {
                    System.out.println("Vui lòng ko để trống !");
                    System.out.println("Nhập mã hóa đơn:");
                    code = scanner.nextLine();
                }

                double amount;
                while (true) {
                    System.out.println("Nhập số tiền:");
                    try {
                        amount = Double.parseDouble(scanner.nextLine());
                        if (amount >= 0) {
                            break;
                        }
                        System.out.println("Vui lòng nhập số thực >= 0 !");
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số thực >= 0 !");
                    }
                }

                Invoice invoice = new Invoice(autoId++, code, amount);
                manager.add(invoice);
                System.out.println("Hóa đơn đã được thêm thành công.");

            } else if (choice == 2) {
                manager.display();
                System.out.println("Nhập id hóa đơn cần sửa:");
                int id;
                try {
                    id = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    id = -1;
                }

                int index = manager.findIndexById(id);
                if (index == -1) {
                    System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
                } else {
                    System.out.println("Nhập mã hóa đơn mới:");
                    String code = scanner.nextLine();
                    while (code.trim().isEmpty()) {
                        System.out.println("Vui lòng ko để trống !");
                        System.out.println("Nhập mã hóa đơn mới:");
                        code = scanner.nextLine();
                    }

                    double amount;
                    while (true) {
                        System.out.println("Nhập số tiền mới:");
                        try {
                            amount = Double.parseDouble(scanner.nextLine());
                            if (amount >= 0) {
                                break;
                            }
                            System.out.println("Vui lòng nhập số thực >= 0 !");
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số thực >= 0 !");
                        }
                    }

                    Invoice updatedInvoice = new Invoice(id, code, amount);
                    manager.update(index, updatedInvoice);
                    System.out.println("Hóa đơn đã được sửa thành công.");
                }

            } else if (choice == 3) {
                manager.display();
                System.out.println("Nhập id hóa đơn cần xóa:");
                int id;
                try {
                    id = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    id = -1;
                }

                int index = manager.findIndexById(id);
                if (index == -1) {
                    System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
                } else {
                    manager.delete(index);
                    System.out.println("Hóa đơn đã được xoa thành công.");
                }

            } else if (choice == 4) {
                manager.display();
            } else if (choice == 5) {
                break;
            }
        }
    }
}
