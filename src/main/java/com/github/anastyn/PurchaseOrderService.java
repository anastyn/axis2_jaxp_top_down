package com.github.anastyn;

import com.github.anastyn.schema.PurchaseOrderRequest;
import com.github.anastyn.schema.PurchaseOrderResponse;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

public class PurchaseOrderService implements PurchaseOrderServiceSkeletonInterface {

    // It is save to cache a validator instance
    private static final Validator beanValidator;

    static {
        beanValidator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public PurchaseOrderResponse purchaseOrder(PurchaseOrderRequest purchaseOrderRequest) {
        System.out.println("Request: " + purchaseOrderRequest);
        PurchaseOrderResponse response = new PurchaseOrderResponse();

        Set<ConstraintViolation<PurchaseOrderRequest>> constraints = beanValidator.validate(purchaseOrderRequest);
        if (constraints.isEmpty()) {
            response.setStatus("Success");
        } else {
            StringBuilder errors = new StringBuilder();
            for (Iterator<ConstraintViolation<PurchaseOrderRequest>> iterator = constraints.iterator(); iterator.hasNext(); ) {
                ConstraintViolation<PurchaseOrderRequest> constraint = iterator.next();
                System.err.println("Property " + constraint.getPropertyPath() + " " + constraint.getMessage());
                errors.append(constraint.getPropertyPath());
                if (iterator.hasNext()) errors.append(", ");
            }
            response.setStatus("Invalid values: " + errors.toString());
        }
        System.out.println("Sending response: " + response);
        return response;
    }

}
