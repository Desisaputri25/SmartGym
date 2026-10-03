package smartgym;

public class MemberGym {
    private String idMember;
    private String nama;
    private double biayaBulanan;

    // Variable static untuk counter total objek
    public static int totalMember = 0;

    // Constructor 'this'
    public MemberGym(String idMember, String nama, double biayaBulanan) {
        this.idMember = idMember;
        this.nama = nama;
        setBiayaBulanan(biayaBulanan); 
        totalMember++;
    }

    // Getter dan Setter dengan validasi
    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getBiayaBulanan() {
        return biayaBulanan;
    }

    public void setBiayaBulanan(double biayaBulanan) {
        if (biayaBulanan > 0) {
            this.biayaBulanan = biayaBulanan;
        } else {
            System.out.println("[Peringatan] Biaya bulanan harus > 0. Diset ke default Rp 150.000.");
            this.biayaBulanan = 150000;
        }
    }

    // Method Induk (Akan di-override oleh Subclass)
    public void tampilkanInfo() {
        System.out.printf("ID: %-6s | Nama: %-20s | Biaya/Bulan: Rp %,.2f", 
                          this.idMember, this.nama, this.biayaBulanan);
    }

    public double hitungTotalBayar(int jumlahBulan) {
        return this.biayaBulanan * jumlahBulan;
    }
}