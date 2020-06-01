public class Email implements Inote {
    private String email;
    public void printTransferConfirmation() {
        System.out.println("transfer Confirm " + email);
    }

    public Email(String email) {
        this.email = email;
    }
}
