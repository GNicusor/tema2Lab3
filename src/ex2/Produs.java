//Pe fiecare linie se află: denumirea produsului, preţul (număr real)
//cantitatea (număr întreg), data expirării (LocalDate).

package ex2;

import java.time.LocalDate;

public class Produs {
    private String denumire;
    private int pret, cantitate;
    private LocalDate data_expirari;
    private float incasari = 0;
    public Produs(String denumire, int pret, int cantitate, LocalDate data_expirari) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirari = data_expirari;
    }

    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isAfter(data_expirari);
    }
    public String getDenumire() {
        return denumire;
    }

    public int getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public LocalDate getData_expirari() {
        return data_expirari;
    }

    //sethers
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setData_expirari(LocalDate data_expirari) {
        this.data_expirari = data_expirari;
    }

    public void Selling(int nr) {
        if (this.cantitate - nr > 0) {
            this.cantitate = this.cantitate - nr;
            incasari = incasari + pret;
        } else {
            System.out.println("Nu se poate realiza tranzactia , cantitate insuficienta");
        }
        ;
    }

    public void afisare(){
        System.out.println("Denumirea:" + denumire);
        System.out.println("Pret:" + pret);
        System.out.println("Cantitate:" + cantitate);
        System.out.println("Data_expirari:" + data_expirari);
    }
}
