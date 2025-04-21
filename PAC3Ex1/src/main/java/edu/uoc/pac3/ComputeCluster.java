package edu.uoc.pac3;

import java.time.LocalDate;

public class ComputeCluster {
    // Constants
    public static final String INVALID_NAME = "[ERROR] The name cannot be null and has to start with 'cluster-' followed by a number";
    public static final String INVALID_NUM_NODES = "[ERROR] The number of nodes has to be greater or equal to 4";
    public static final String INVALID_NUM_GPUS = "[ERROR] The number of GPUs cannot be negative or zero";
    public static final String INVALID_RAM_CAPACITY = "[ERROR] The RAM capacity has to be greater or equal to 16 GB";
    public static final String INVALID_MAINTENANCE_DATE = "[ERROR] The next maintenance date cannot be null or in the past";

    // Minimum and maximum values
    private static final int MIN_NUM_NODES = 4;
    private static final int MIN_NUM_GPUS = 1;
    private static final double MIN_RAM_CAPACITY = 16.0;

    // Attributes
    private String name;
    private int numNodes;
    private int numGPUs;
    private double ramCapacity;
    private LocalDate nextMaintenanceDate;
    private boolean isGPUEnabled;

    // Constructor
    public ComputeCluster(String name, int numNodes, int numGPUs, double ramCapacity, LocalDate nextMaintenanceDate, boolean isGPUEnabled) {
        setName(name);
        setNumNodes(numNodes);
        setNumGPUs(numGPUs);
        setRamCapacity(ramCapacity);
        setNextMaintenanceDate(nextMaintenanceDate);
        setGPUEnabled(isGPUEnabled);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public int getNumGPUs() {
        return numGPUs;
    }

    public double getRamCapacity() {
        return ramCapacity;
    }

    public LocalDate getNextMaintenanceDate() {
        return nextMaintenanceDate;
    }

    public boolean isGPUEnabled() {
        return isGPUEnabled;
    }

    // Setters
    private void setName(String name) {
        if (name == null || !name.matches("^cluster-\\d+$")) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setNumNodes(int numNodes) {
        if (numNodes < MIN_NUM_NODES) {
            throw new IllegalArgumentException(INVALID_NUM_NODES);
        }
        this.numNodes = numNodes;
    }

    private void setNumGPUs(int numGPUs) {
        if (numGPUs < MIN_NUM_GPUS) {
            throw new IllegalArgumentException(INVALID_NUM_GPUS);
        }
        this.numGPUs = numGPUs;
    }

    private void setRamCapacity(double ramCapacity) {
        if (ramCapacity < MIN_RAM_CAPACITY) {
            throw new IllegalArgumentException(INVALID_RAM_CAPACITY);
        }
        this.ramCapacity = ramCapacity;
    }

    private void setNextMaintenanceDate(LocalDate nextMaintenanceDate) {
        if (nextMaintenanceDate == null || nextMaintenanceDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_MAINTENANCE_DATE);
        }
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    private void setGPUEnabled(boolean isGPUEnabled) {
        this.isGPUEnabled = isGPUEnabled;
    }
}