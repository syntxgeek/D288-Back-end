package com.example.nathaly.services;

import lombok.Data;
import lombok.NonNull;
@Data
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;
}
