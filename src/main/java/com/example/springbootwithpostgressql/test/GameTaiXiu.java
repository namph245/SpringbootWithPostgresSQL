package com.example.springbootwithpostgressql.test;

import java.util.Scanner;

public class GameTaiXiu {

    public static void main(String[] args) {

        // tổng số người chơi
        String firstPlayer = "";
        String SecondsPlayer = "";

        // tổng số dư ban đầu của người chơi
        double tongSoDuA = 1000000;
        double tongSoDuB = 1000000;

        Scanner scanner = new Scanner(System.in);
        System.out.println("vui lòng nhập họ tên?");
        String fullName = scanner.nextLine();
        System.out.println("=====================> Chào mừng bạn đã đến với game tài xỉu, chúc bạn chơi game vui vẻ <=====================");
        System.out.println("xin chào: " + fullName + "!");

        System.out.println("nhập số tiền cá cược: ");
        double soTienCaCuoc = scanner.nextDouble();

        if (soTienCaCuoc > tongSoDuA) {
            System.out.println("Thất bại, bạn không thể đặt cược quá số tiền bạn có được vui lòng nạp thêm tiền!");
        }

        System.out.println("bạn chọn Tài hay Xỉu?");

        int tong1 = tungXucXac();
        int tong2 = tungXucXac();

        if (tong1 == 7 || tong1 == 11) {
            System.out.println("chúc mừng! bạn đã thắng cuộc");

        }else if (tong1 == 2 || tong1 == 3 || tong1 == 12){
            System.out.println("thất bại, bạn đã thua");
        }else{
            int tong3 = tungXucXac();
            while (tong3 != tong1 && tong3 != 7) {
                tong3 = tungXucXac();
            }
            if (tong3 == tong1) {
                System.out.println("chúc mừng! bạn đã thắng cuộc");
            }else{
                System.out.println("thất bại, bạn đã thua");
            }
        }

    }

    // tạo hàm tung xúc xắc
    public static int tungXucXac() {

        // 2 con xúc xắc
        int xucxac1 = (int) (Math.random() * 6) + 1;
        int xucxac2 = (int) (Math.random() * 6) + 1;

        int tong = xucxac1 + xucxac2;
        System.out.println("bạn tung được xúc xắc lần thứ nhất là = " + xucxac1);
        System.out.println("bạn tung được xúc xắc lần thứ hai là = " + xucxac2);
        System.out.println("tổng của 2 lần tung là = " + tong);

        return  tong;
    }
}
