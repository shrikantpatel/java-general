package com.shri.general.java17;

public class Using_Record {
    public static void main(String[] args) {

        VehicleRecord vr = new VehicleRecord("gas", "combustion engine");
        System.out.println("Vehicle record object -> " + vr);
    }
}
record VehicleRecord(String code, String engineType) {
}
