package com.github.anastyn;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.engine.ServiceLifeCycle;

/**
* Listens to the lifecycle events of the service.
**/
public class PurchaseOrderServiceLifecycle  implements ServiceLifeCycle {

	/** Fires when the service is starting up. **/
    @Override
    public void startUp(ConfigurationContext configurationContext, AxisService axisService) {
        System.out.println("PurchaseOrder::startUp");
    }

    /** Fires when the service is shutting down. **/
    @Override
    public void shutDown(ConfigurationContext configurationContext, AxisService axisService) {
        System.out.println("PurchaseOrder::shutDown");
    }
}
