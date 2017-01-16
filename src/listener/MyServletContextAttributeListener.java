package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae) {
    	System.out.println("attributeAdded");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae) {
    	System.out.println("attributeRemoved");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae) {
    	System.out.println("attributeReplaced");
    }
}
