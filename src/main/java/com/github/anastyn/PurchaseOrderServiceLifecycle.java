package com.github.anastyn;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.engine.ServiceLifeCycle;

public class PurchaseOrderServiceLifecycle  implements ServiceLifeCycle {

    @Override
    public void startUp(ConfigurationContext configurationContext, AxisService axisService) {
        System.out.println("PurchaseOrder::startUp");
    }

    @Override
    public void shutDown(ConfigurationContext configurationContext, AxisService axisService) {
        System.out.println("PurchaseOrder::shutDown");
    }
}
