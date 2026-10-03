package smartgym;

import java.util.Scanner;

public class SmartGym {

    // Method Overloading 1: Mencari berdasarkan Nama
    public static void cariMember(String nama, MemberGym[] daftar, int jumlah) {
        System.out.println("\n--- Hasil Pencarian Nama: " + nama + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Member tidak ditemukan.");
        }
    }

    // Method Overloading 2: Mencari berdasarkan Maksimal Biaya Bulanan
    public static void cariMember(double maxBiaya, MemberGym[] daftar, int jumlah) {
        System.out.printf("\n--- Hasil Pencarian Biaya <= Rp %,.2f ---\n", maxBiaya);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getBiayaBulanan() <= maxBiaya) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada member sesuai batas biaya tersebut.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberGym[] daftarMember = new MemberGym[20];
        int jumlahMember = 0;

        // Inisialisasi 4 Data Awal
        daftarMember[jumlahMember++] = new MemberReguler("MG-01", "Desi Saputri", 200000, 101);
        daftarMember[jumlahMember++] = new MemberReguler("MG-02", "Suci Widia Ningsih", 200000, 102);
        daftarMember[jumlahMember++] = new MemberVIP("MG-03", "Ayu Wardani", 500000, "Coach Rafli");
        daftarMember[jumlahMember++] = new MemberVIP("MG-04", "Muhammad Ramadani", 500000, "Coach Miftah");

        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("            SELAMAT DATANG DI SMARTGYM            ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\n---------------- MENU UTAMA ----------------");
            System.out.println("1. Tambah Member Baru");
            System.out.println("2. Lihat Daftar Member");
            System.out.println("3. Cari Member ");
            System.out.println("4. Hitung Estimasi Pembayaran Member");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1 -> {
                    if (jumlahMember < daftarMember.length) {
                        System.out.println("\n--- Pilih Tipe Member ---");
                        System.out.println("1. Member Reguler");
                        System.out.println("2. Member VIP");
                        System.out.print("Pilihan (1/2): ");
                        int tipe = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan ID Member : ");
                        String id = scanner.nextLine();
                        System.out.print("Masukkan Nama Member: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Biaya Bulanan: ");
                        double biaya = scanner.nextDouble();
                        scanner.nextLine();

                        if (tipe == 1) {
                            System.out.print("Masukkan Nomor Loker: ");
                            int loker = scanner.nextInt();
                            scanner.nextLine();
                            daftarMember[jumlahMember++] = new MemberReguler(id, nama, biaya, loker);
                        } else if (tipe == 2) {
                            System.out.print("Masukkan Nama Personal Trainer: ");
                            String trainer = scanner.nextLine();
                            daftarMember[jumlahMember++] = new MemberVIP(id, nama, biaya, trainer);
                        } else {
                            System.out.println("Pilihan tipe member tidak valid!");
                            break;
                        }
                        System.out.println("Sukses: Data member berhasil ditambahkan!");
                    } else {
                        System.out.println("Kapasitas penyimpanan penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n================================================ DAFTAR MEMBER SMARTGYM ===============================================");
                    if (jumlahMember == 0) {
                        System.out.println("Belum ada data member.");
                    } else {
                        for (int i = 0; i < jumlahMember; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarMember[i].tampilkanInfo();
                        }
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Total Member Terdaftar : " + MemberGym.totalMember);
                    }
                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("\n--- Cari Member  ---");
                    System.out.println("1. Cari Berdasarkan Nama");
                    System.out.println("2. Cari Berdasarkan Batas Maksimal Biaya");
                    System.out.print("Pilih Kriteria (1/2): ");
                    int kriteria = scanner.nextInt();
                    scanner.nextLine();

                    if (kriteria == 1) {
                        System.out.print("Masukkan Nama Member: ");
                        String namaCari = scanner.nextLine();
                        cariMember(namaCari, daftarMember, jumlahMember);
                    } else if (kriteria == 2) {
                        System.out.print("Masukkan Batas Biaya Bulanan Maksimal: ");
                        double maxBiaya = scanner.nextDouble();
                        scanner.nextLine();
                        cariMember(maxBiaya, daftarMember, jumlahMember);
                    } else {
                        System.out.println("Pilihan kriteria tidak valid.");
                    }
                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 4 -> {
                    System.out.println("\n--- Hitung Estimasi Pembayaran Member ---");
                    System.out.print("Masukkan Nomor Urut Member (1-" + jumlahMember + "): ");
                    int idx = scanner.nextInt() - 1;
                    if (idx >= 0 && idx < jumlahMember) {
                        System.out.print("Masukkan Durasi Berlangganan (Bulan): ");
                        int bulan = scanner.nextInt();
                        scanner.nextLine();

                        double total = daftarMember[idx].hitungTotalBayar(bulan);
                        System.out.printf("Total Biaya Member %s selama %d bulan: Rp %,.2f\n", 
                                          daftarMember[idx].getNama(), bulan, total);
                    } else {
                        System.out.println("Nomor urut member tidak valid.");
                    }
                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 5 -> {
                    isRunning = false;
                    System.out.println("\nTerima kasih telah menggunakan layanan SmartGym!");
                }
                default -> System.out.println("Pilihan menu tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}