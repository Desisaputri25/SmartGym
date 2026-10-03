package smartgym;

public class MemberReguler extends MemberGym {
    private int noLoker;

    // Constructor dengan keyword 'super' dan 'this'
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

    // Method Overriding
    @Override
    public void tampilkanInfo() {
        System.out.printf("[Member Reguler] ");
        super.tampilkanInfo();
        System.out.printf(" | No Loker: %d\n", this.noLoker);
    }
}
