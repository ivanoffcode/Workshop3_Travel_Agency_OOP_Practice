package com.company.oop.agency.models.enums;

public enum VehicleType {
    LAND, AIR, SEA;

    @Override
    public String toString() {
        switch (this) {
            case LAND:
                return "LAND";
            case AIR:
                return "AIR";
            case SEA:
                return "SEA";
            default:
                throw new IllegalArgumentException("Invalid Vehicle type. Vehicle type can be: Land, Air or Sea.");
        }
    }
}
