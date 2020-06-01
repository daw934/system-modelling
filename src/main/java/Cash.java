public class Cash extends Payment {
    public void pay(Order someOrder) {
        paymentAmount = someOrder.orderValue();
    }
}