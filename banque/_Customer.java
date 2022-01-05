package banque;

public class _Customer {
    private int customerID;
    private int transactionTime;
    private int arrivalTime;

    _Customer() {
        this(1, 1, 1);
    }

    _Customer(int customerid, int transactionduration, int arrivaltime) {
        customerID = customerid;
        transactionTime = transactionduration;
        arrivalTime = arrivaltime;
    }

    int getTransactionTime() {
        return transactionTime;
    }

    int getArrivalTime() {
        return arrivalTime;
    }

    int getCustomerID() {
        return customerID;
    }

    public String toString() {
        return "" + customerID + ":" + transactionTime + ":" + arrivalTime;
    }

    public static void main(String[] args) {
        // quick check!
        _Customer mycustomer = new _Customer(20, 30, 40);
        System.out.println("Customer Info:" + mycustomer);
    }

}