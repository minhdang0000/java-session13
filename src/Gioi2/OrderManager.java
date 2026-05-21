package Gioi2;

import java.util.ArrayList;

public class OrderManager implements Manage<Order> {
    private ArrayList<Order> list = new ArrayList<>();

    @Override
    public void add(Order item) {
        list.add(item);
    }

    @Override
    public void update(int index, Order item) {
        list.set(index, item);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public void display() {
        for (int i = 0; i < list.size(); i++) {
            Order order = list.get(i);
            System.out.println((i + 1) + ". Mã đơn hàng: " + order.getOrderCode() + ", Tên khách hàng: " + order.getCustomerName());
        }
    }

    public int findIndexByCode(String orderCode) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOrderCode().equalsIgnoreCase(orderCode)) {
                return i;
            }
        }
        return -1;
    }
}
