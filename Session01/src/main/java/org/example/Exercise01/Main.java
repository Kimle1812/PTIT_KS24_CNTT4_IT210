package org.example.Exercise01;

public class Main {
    public static void main(String[] args) {
        // Đoạn code trên bị sai vì đang vi phạm IoC, gắn chặt phụ thuộc khiến lớp RechargeService bị ràng
        // buộc cứng với PaymentGateway
        // -> Sửa lại (Tiêm DI qua constructor)
        public class RechargeService {
            private PaymentGateway gateway;

           public RechargeService(PaymentGateway gateway) {
               this.gateway = gateway;
            }
            public void processRecharge(String username, double amount) {
                gateway.pay(amount);
                System.out.println("Nạp " + amount + " cho " + username);
            }
        }
    }
}