package smartgym;

public class MemberGym {
    private String idMember;
    private String nama;
    private double biayaBulanan;

    // Variable static untuk counter total objek
    public static int totalMember = 0;

    // Constructor 'this'
    public MemberGym(String idMember, String nama, double biayaBulanan) {
        setIdMember(idMember);
        setNama(nama);
        setBiayaBulanan(biayaBulanan); 
        totalMember++;
    }

    // Getter dan Setter dengan validasi
    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        if (idMember != null && !idMember.trim().isEmpty()){
            this.idMember = idMember;
        } else{
            this.idMember = "MG-000";
        }
    }
        

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
    } else{
            this.nama = "Tanpa Nama";
        }
    }

    public double getBiayaBulanan() {
        return biayaBulanan;
    }

    public void setBiayaBulanan(double biayaBulanan) {
        if (biayaBulanan > 0) {
            this.biayaBulanan = biayaBulanan;
        } else {
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