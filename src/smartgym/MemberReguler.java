package smartgym;

public class MemberReguler extends MemberGym implements DapatLocker {
    private int noLoker;

    public MemberReguler(String idMember, String nama, double biayaBulanan, int noLoker) {
        super(idMember, nama, biayaBulanan);
        this.noLoker = noLoker;
    }

    public int getNoLoker() {
        return noLoker;
    }

    public void setNoLoker(int noLoker) {
        if (noLoker > 0) {
            this.noLoker = noLoker;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Member Reguler] ");
        super.tampilkanInfo();
        System.out.printf("  | No Loker: %d\n", this.noLoker);
    }
    
    @Override
    public void cetakAturanFasilitas() {
        System.out.println("[Aturan]: Akses area fitness umum & kunci loker harian wajib dikembalikan.");
    }
    
    @Override
    public void klaimLocker() {
        System.out.println("[Aksi Locker]: Loker Nomor " + this.noLoker + " berhasil diklaim & dikunci.");
    }
}