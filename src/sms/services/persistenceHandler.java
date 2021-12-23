package sms.services;
import sms.model.Account;

public abstract class persistenceHandler {
    public abstract Boolean checkUser(Account acc);
}
