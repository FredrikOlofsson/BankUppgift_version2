package bankuppgiften;

import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataHolder {
    private ArrayList<Account> databaseAccounts;
    private XmlMagic xml;
    
    public DataHolder(){
        databaseAccounts = new ArrayList<>();
 //todo if there is a xml file, retrieve data from it.       
    }
    /////////////////////////////////////////////////////////////
            
    public final void addAccount(Account newAccount){
        this.databaseAccounts.add(newAccount);
    }     
    public Account getAccount (int accountNumber){
        for(Account currentAccount : databaseAccounts){
            if(currentAccount.getAccountNumber() == accountNumber){
                return currentAccount;
            }
        }
        return null; //TODO Change to throw exception!
    }
    public boolean authenticateUser(int userAccountNumber, String userPIN){
        Account userAccount = getAccount(userAccountNumber);
        if(userAccount != null){
            return userAccount.validatePIN(userPIN);
        } else return false;
    }
    public double getAvailableBalance(int userAccountNumber){
        return getAccount(userAccountNumber).getAvailableBalance();
    }
    public double getTotalBalance(int userAccountNumber){
        return getAccount(userAccountNumber).getTotalBalance();
    }
    public void credit(int userAccountNumber, double amount){
        getAccount(userAccountNumber).credit(amount);
    }
    public void debit(int userAccountNumber, double amount){
        getAccount(userAccountNumber).debit(amount);
    }    
    
    public void packToXML() throws JAXBException{
        this.xml = new XmlMagic(this.databaseAccounts);
        xml.pack("Accounts");
    }
    public void unPackToXML() throws JAXBException{
        xml.unpack("Accounts");
        this.databaseAccounts = (ArrayList<Account>) xml.getObject();
    }
    
}
