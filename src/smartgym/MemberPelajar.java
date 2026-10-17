package smartgym;

public class MemberPelajar extends MemberGym {
    private String nomorKartuPelajar;

    public MemberPelajar(String idMember, String nama, double biayaBulanan, String nomorKartuPelajar) {
        super(idMember, nama, biayaBulanan);
        setNomorKartuPelajar(nomorKartuPelajar);
    }

    public String getNomorKartuPelajar() {
        return nomorKartuPelajar;
    }

    public void setNomorKartuPelajar(String nomorKartuPelajar) {
        if (nomorKartuPelajar != null && !nomorKartuPelajar.trim().isEmpty()) {
            this.nomorKartuPelajar = nomorKartuPelajar;
        } else {
            this.nomorKartuPelajar = "KP-000000";
        }
    }

    // Method Overriding untuk menampilkan info khusus
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Member Pelajar] ");
        super.tampilkanInfo();
        System.out.printf("  | No Kartu Pelajar: %s\n", this.nomorKartuPelajar);
    }

    // Overriding perhitungan total bayar khusus pelajar (Diskon 20%)
    @Override
    public double hitungTotalBayar(int jumlahBulan) {
        double total = super.hitungTotalBayar(jumlahBulan);
        return total * 0.80; // Diskon khusus pelajar 20%
    }
    
    @Override
    public void cetakAturanFasilitas() {
        System.out.println("[Aturan]: Berlaku pada jam operasional pelajar (08.00 - 17.00 WIB) & wajib sertakan Kartu Pelajar.");
    }
}