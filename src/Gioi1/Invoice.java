package Gioi1;

public class Invoice {
    private int id;
    private String code;
    private double amount;

    public Invoice(int id, String code, double amount) {
        this.id = id;
        this.code = code;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ID : " + id + " , Mã hóa đơn: " + code + ", Số tiền: " + amount;
    }
}
