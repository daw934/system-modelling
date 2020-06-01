public class BankTransfer extends Payment {
    private String bankAccount;
    private String transferTitle;

    public BankTransfer(String bankAccount, String transferTitle) {
        super();
        this.bankAccount = bankAccount;
        this.transferTitle = transferTitle;
    }

    public void pay(Order someOrder) {
        paymentAmount = someOrder.orderValue();
    }
}
