package systemdesign.solidprinciple;

//Open for extension and closed for modification as class is already live and can impact the whole product
public class BOpenClosedPrinciple {
    public static void main(String[] args) {

    }
}

class Invoice {
    private String invoiceNumber;
    private String customerName;
}

class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        System.out.println("Saving to DB....");
    }

    public void saveToFile() {
        System.out.println("Saving to file....");
    }
}

// Let's use OCP to fix above as we added saveToFile later on based on requirement which can break existing code if there is errors
interface BaseInvoice {
    public void save();
}

class DatabaseInvoiceDao implements BaseInvoice {
    @Override
    public void save() {

    }
}

class FileInvoiceDao implements BaseInvoice {
    @Override
    public void save() {

    }
}
