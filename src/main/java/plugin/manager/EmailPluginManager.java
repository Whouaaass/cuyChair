package plugin.manager;

import co.edu.unicauca.cuychair.common.notificationPlugin.IEmailPlugin;
import plugin.simple.java.mail.SimpleJava;

public class EmailPluginManager {

    private static EmailPluginManager instance;

    private EmailPluginManager(){

    }

    public static EmailPluginManager getInstance(){
        EmailPluginManager m=new EmailPluginManager();
        return m;
    }

    public IEmailPlugin getDeliveryPlugin(){
        IEmailPlugin plugin=new SimpleJava();
        return plugin;
    }

}
