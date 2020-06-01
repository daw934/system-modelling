public class Credit extends Payment {
    private byte loanPaymentNumber;
    private String bank;
    private float annualEquivalentRate;

    public void pay(Order someOrder) {
        paymentAmount = someOrder.orderValue() * annualEquivalentRate;
    }

    public Credit(byte loanPaymentNumber, String bank, float annualEquivalentRate) {
        super();
        this.loanPaymentNumber = loanPaymentNumber;
        this.bank = bank;
        this.annualEquivalentRate = annualEquivalentRate;
    }
}
