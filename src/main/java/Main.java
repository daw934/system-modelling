import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean q = false;
        while (!q) {
            System.out.println("1. Add new Order \n2. Check your orders \n3. Pay for orders \n4. quit");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1:
                    addNewOrder();
                    break;
                case 2:
                    checkOrders();
                    break;
                case 3:
                    pay();
                    break;
                case 4:
                    q = true;
                    break;
            }
        }
    }

    private static void pay() {
        checkOrders();
        System.out.println("Choose the position \n");
        int position = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.println("1. Credit \n2. BankTransfer\n3. Cash \n4. quit");
        int number = scanner.nextInt();
        scanner.nextLine();
        switch (number) {
            case 1:
                payWithCredit(position);
                break;
            case 2:
                payWithBankTranfer(position);
                break;
            case 3:
                payWithCache(position);
        }
    }

    private static void payWithCache(int position) {
        Cash cash = new Cash();
        payForOrder(position, cash);

    }

    private static void payWithBankTranfer(int position) {
        BankTransfer bankTransfer = new BankTransfer("BankAccount", "Transfer");
        payForOrder(position, bankTransfer);

    }

    private static void payWithCredit(int position) {
        byte b = (byte) (Math.random() * 100);
        Credit bank = new Credit(b, "Bank", 14F);
        payForOrder(position, bank);
    }

    private static void payForOrder(int position, Payment bank) {
        Order order = orders.get(position);
        order.pay(bank);
        System.out.println("Do you need electronic confirmation? Y/N");
        String elect = scanner.nextLine();
        if (elect.equals("Y")) {
            System.out.println("provide the Email");
            String email = scanner.nextLine();
            order.setElectronicConfirmation(email);
        }
        order.printTransferConfirmation(bank);
    }

    private static void checkOrders() {
        for (int i = 0; i < orders.size(); i++) {
            int position = i + 1;
            System.out.println("Position = " + position + " " + orders.toString());
        }
    }

    private static void addNewOrder() {
        Order order = new Order("1");
        boolean q = false;
        while (!q) {
            System.out.println("1. add new Item \n2. end");
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1:
                    addNewItem(order);
                    break;
                case 2:
                    q = true;
                    break;
            }
        }
        orders.add(order);
    }

    private static void addNewItem(Order order) {
        System.out.println("Item Name");
        String name = scanner.nextLine();
        System.out.println("UnitPrize");
        String unitPrize = scanner.nextLine();
        System.out.println("vat");
        int vat = scanner.nextInt();
        System.out.println("quantity");
        scanner.nextLine();
        String quanity = scanner.nextLine();
        OrderPosition orderPosition = new OrderPosition(name, Float.parseFloat(unitPrize), vat, Float.parseFloat(quanity));
        order.orderItemAdd(orderPosition);
        System.out.println("The item was added");
    }
}
