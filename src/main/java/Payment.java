public abstract class Payment {
    protected double paymentAmount;
    private String paymentId;
    public abstract void pay(Order someOrder);
    public void printTransferConfirmation(){
        System.out.println("Transfer confirmation for " + paymentId);
        System.out.println("Pay amount " + paymentAmount);
    }

    public Payment() {
        this.paymentId = Double.toString(Math.random());
    }
}
