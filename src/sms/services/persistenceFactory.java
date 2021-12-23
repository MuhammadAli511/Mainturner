package sms.services;

public class persistenceFactory {
    public persistenceHandler service;
    public persistenceHandler createPersistenceHandler(String servName){
        if (service == null)
        {
            /*if (servName.equals("MySQL")){
                service = new MySqlHandler();
            }*/
            if (servName.equals("File") == true) {
                service = new fileHandler();
            }
        }
        return service;
    }
}
