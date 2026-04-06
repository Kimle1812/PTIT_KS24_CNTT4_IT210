package org.example.Exercise05.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {

    @Value("PrisonNow's Dried Chicken Shop")
    private String branchName;

    @Value("08:00 AM")
    private String openingHour;

    public String getBranchName() {
        return branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }
}