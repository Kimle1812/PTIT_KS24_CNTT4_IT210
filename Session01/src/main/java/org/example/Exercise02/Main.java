package org.example.homework02;

public class Main {
    public static void main(String[] args) {
        // Trong Spring, khi khai báo một lớp với annotation @Component mà không chỉ định gì thêm,
        // mặc định Bean đó sẽ có scope là Singleton. Nghĩa là trong toàn bộ ApplicationContext,
        // chỉ tồn tại một instance duy nhất của PlaySession.
        // Nguyên nhân:
        // - Sử dụng Bean sai: sử dụng Singleton cho một đối tượng mà lẽ ra phải được tạo mới ở mỗi phiên chơi
        // - Chưa tách biệt trạng thái: mỗi người chơi cần một PlaySession riêng nhưng trong code lỗi thì đang dùng chung
        // Cách sửa: Đặt scope -> Prototype (@Scope("prototype"))
    }
}