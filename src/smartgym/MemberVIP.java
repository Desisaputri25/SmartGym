package smartgym;

public class MemberVIP extends MemberGym implements DapatLocker, DapatPersonalTrainer {
    private String namaTrainer;

    public MemberVIP(String idMember, String nama, double biayaBulanan, String namaTrainer) {
        super(idMember, nama, biayaBulanan);
        setNamaTrainer(namaTrainer);
    }

    public String getNamaTrainer() {
        return namaTrainer;
    }

    public void setNamaTrainer(String namaTrainer) {
        if (namaTrainer != null && !namaTrainer.trim().isEmpty()){
            this.namaTrainer = namaTrainer;
        } else {
        this.namaTrainer = "Belum Ditentukan";
        }
    }

    // Method Overriding
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Member VIP]     ");
        super.tampilkanInfo();
        System.out.printf("  | Trainer: %s\n", this.namaTrainer);
    }

    // Overriding Perhitungan Total Bayar (Diskon 15% jika > 6 bulan)
    @Override
    public double hitungTotalBayar(int jumlahBulan) {
        double total = super.hitungTotalBayar(jumlahBulan);
        if (jumlahBulan > 6) {
            total *= 0.85; // Diskon 15%
        }
        return total;
    }
    
    // Implementasi Abstract Method dari MemberGym
    @Override
    public void cetakAturanFasilitas() {
        System.out.println("  -> [Aturan]: Akses VIP Lounge, saunarium, & prioritas alat tanpa antre.");
    }
    
    // Implementasi Interface DapatLocker
    @Override
    public void klaimLocker() {
        System.out.println("[Aksi Locker]: Loker Eksklusif VIP berpemanas berhasil diaktifkan.");
    }
    
    // Implementasi Interface DapatPersonalTrainer
    @Override
    public void jadwalkanTrainer() {
        System.out.println("[Aksi Trainer]: Sesi latihan privat bersama " + this.namaTrainer + " telah dijadwalkan.");
    }
    
}