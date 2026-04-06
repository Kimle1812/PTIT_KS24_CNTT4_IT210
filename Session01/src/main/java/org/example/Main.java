package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Bean - đọc cấu hình java Class bean
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfiguration.class
                );

        // Lấy bean ra như nào?
        Person fullstack = (Person) context.getBean("fullstack");
        System.out.println(fullstack);
    }
}=
