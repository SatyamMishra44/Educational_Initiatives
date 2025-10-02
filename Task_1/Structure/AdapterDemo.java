class OldPayment {
    public void makePayment(double amount) { System.out.println("Paid " + amount + " via old API"); }
}

interface Payment { void pay(double amount); }

class PaymentAdapter implements Payment {
    private OldPayment oldPayment = new OldPayment();
    public void pay(double amount) { oldPayment.makePayment(amount); }
}

public class AdapterDemo {
    public static void main(String[] args) {
        Payment payment = new PaymentAdapter();
        payment.pay(250);
    }
}
