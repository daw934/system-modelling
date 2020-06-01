import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDate executionDate;
    private boolean orderStatus;
    private String orderId;
    private List<OrderPosition> orderPosition;
    private boolean electronicConfirmation;
    private String email;

    public double orderValue() {
        return orderPosition.stream()
                .map(OrderPosition::grossValueCalculate)
                .reduce(0.0, Double::sum);
    }

    public double taxValue() {
        return orderPosition.stream()
                .map(OrderPosition::TAXCalculate)
                .reduce(Double.NaN, Double::sum);
    }

    public boolean pay(Payment somePayment) {
        somePayment.pay(this);
        orderStatus = true;
        executionDate = LocalDate.now();
        return orderStatus;
    }

    public void printTransferConfirmation(Payment somePayment) {
        somePayment.printTransferConfirmation();
        if (electronicConfirmation) {
            new Email(email).printTransferConfirmation();
        } else {
            new Printer().printTransferConfirmation();
        }
    }

    public boolean orderItemAdd(OrderPosition orderPositionItem) {
        return orderPosition.add(orderPositionItem);
    }

    public void setElectronicConfirmation(String email) {
        electronicConfirmation = true;
        this.email = email;
    }

    public Order(String orderId) {
        this.orderStatus = false;
        this.orderId = orderId;
        this.orderPosition = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderStatus=" + orderStatus +
                ", orderId='" + orderId + '\'' +
                ", orderPosition=" + orderPosition +
                '}';
    }
}
