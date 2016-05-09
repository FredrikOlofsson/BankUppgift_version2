package bankuppgiften;

import javax.xml.bind.JAXBException;

public class BankUppgiften {
    public static void main(String[] args) throws JAXBException {
        CashMachine machine  = new CashMachine();
        machine.run();
    }    
}
        
        
/*
    username: "123"
    Password: "pin"
*/