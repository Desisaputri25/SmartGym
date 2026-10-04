package smartgym;

public class MemberVIP extends MemberGym {
    private String namaTrainer;

    // Constructor dengan keyword 'super' dan 'this'
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
        System.out.printf(" | Trainer: %s\n", this.namaTrainer);
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
}