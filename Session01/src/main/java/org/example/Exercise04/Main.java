package org.example.homework04;

public class Main {
    public static void main(String[] args) {
        // - Constructor Injection:
        //      + Tính rõ ràng: Rõ ràng (bắt buộc phải có dependency khi khởi tạo)
        //      + Khả năng kiểm thử: Dễ hơn
        //      + Immutable: Dependency là final, không thể thay đổi sau khi khởi tạo
        //      + Khả năng phát hiện lỗi: Nếu thiếu dependency → lỗi ngay khi compile/run
        //      + Bối cảnh mạng SMS đứt: Có thể dễ dàng mock SmsSender trong test để giả lập lỗi mạng
        // - Field Injection:
        //      + Tính rõ ràng: Ít rõ ràng hơn, dependency được tiêm ngầm
        //      + Khả năng kiểm thử: Khó hơn, phải dùng Reflection hoặc Spring context
        //      + Immutable: Có thể thay đổi bằng setter hoặc reflection
        //      + Khả năng phát hiện lỗi: Nếu thiếu dependency → dễ bị NullPointerException runtime
        //      + Bối cảnh mạng SMS đứt: Khó mock hơn, phải phụ thuộc vào Spring context
    }
}