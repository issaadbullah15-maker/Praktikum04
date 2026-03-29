package Swalayan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Pelanggan[] data = {
            new Pelanggan("Fardhan", "3812345678", 1234, 100000),
            new Pelanggan("Rod", "5612345678", 1234, 10000000),
            new Pelanggan("Issa", "7412345678", 1234, 1000000000)
        };

        int percobaan = 0;
        Pelanggan aktif = null;

        while (percobaan < 3 && aktif == null) {

            System.out.print("Masukkan No Pelanggan: ");
            String no = input.nextLine();

            System.out.print("Masukkan PIN: ");
            int pin = input.nextInt();
            input.nextLine(); 

            for (Pelanggan p : data) {
                if (p.cekLogin(no, pin)) {
                    aktif = p;
                    break;
                }
            }

            if (aktif == null) {
                percobaan++;
                System.out.println("Login salah!");

                if (percobaan == 3) {
                    System.out.println("Akun diblokir!");
                }
            }
        }

        if (aktif != null) {

            System.out.println("Login berhasil! Selamat datang " + aktif.getNama());

            System.out.println("1. Top Up");
            System.out.println("2. Pembelian");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();

            if (pilih == 1) {
                System.out.print("Jumlah top up: ");
                double t = input.nextDouble();
                aktif.topUp(t);

            } else if (pilih == 2) {
                System.out.print("Harga barang: ");
                double h = input.nextDouble();
                aktif.beli(h);
            }
        }
    }
}