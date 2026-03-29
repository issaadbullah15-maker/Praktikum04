package Swalayan;

public class Pelanggan {

    private String nama;
    private String noPelanggan;
    private int pin;
    private double saldo;
    private boolean blokir = false;

    public Pelanggan(String nama, String noPelanggan, int pin, double saldo) {
        this.nama = nama;
        this.noPelanggan = noPelanggan;
        this.pin = pin;
        this.saldo = saldo;
    }

    public String getNama() {
        return nama;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isBlokir() {
        return blokir;
    }

    public void setBlokir(boolean blokir) {
        this.blokir = blokir;
    }

    public boolean cekLogin(String no, int pin) {
        return this.noPelanggan.equals(no) && this.pin == pin;
    }

    public void topUp(double jumlah) {
        saldo += jumlah;
        System.out.println("Top up berhasil. Saldo: " + saldo);
    }

    public void beli(double harga) {
        double cashback = hitungCashback(harga);
        double total = harga - cashback;

        if (saldo - total < 10000) {
            System.out.println("Transaksi gagal! Saldo minimal 10000");
        } else {
            saldo = saldo - total;
            saldo = saldo + cashback;
            System.out.println("Transaksi berhasil!");
            System.out.println("Cashback: " + cashback);
            System.out.println("Saldo sekarang: " + saldo);
        }
    }

    private double hitungCashback(double harga) {
        String kode = noPelanggan.substring(0, 2);

        if (kode.equals("38")) { 
            if (harga > 1000000) return harga * 0.05;
            else return 0;

        } else if (kode.equals("56")) { 
            if (harga > 1000000) return harga * 0.07;
            else return harga * 0.02;

        } else if (kode.equals("74")) { 
            if (harga > 1000000) return harga * 0.10;
            else return harga * 0.05;
        }

        return 0;
    }
}