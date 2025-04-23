package edu.uoc.pac3;

import java.time.LocalDate;

public class ComputeCluster {

    // públicos CONSTANTES
    public static final String INVALID_NAME = "[ERROR] The name cannot be null and has to start with 'cluster-' followed by a number";
    public static final String INVALID_NUM_NODES = "[ERROR] The number of nodes has to be greater or equal to 4";
    public static final String INVALID_NUM_GPUS = "[ERROR] The number of GPUs cannot be negative or zero";
    public static final String INVALID_RAM_CAPACITY = "[ERROR] The RAM capacity has to be greater or equal to 16 GB";
    public static final String INVALID_MAINTENANCE_DATE = "[ERROR] The next maintenance date cannot be null or in the past";
    public static final String INVALID_MAX_MODELS = "[ERROR] The maximum number of models has to be greater than 0";
    public static final String MODEL_NULL = "[ERROR] The model cannot be null";
    public static final String CANNOT_ADD_MODEL = "[ERROR] The model cannot be added to the cluster because it is full";
    public static final String MODEL_ALREADY_EXISTS = "[ERROR] The model already exists in the cluster";
    public static final String MODEL_NOT_FOUND = "[ERROR] The model does not exist in the cluster";

    // privados CONSTANTES
    private static final int MIN_NUM_NODES = 4;
    private static final int MIN_NUM_GPUS = 1;
    private static final double MIN_RAM_CAPACITY = 16.0;

    // privados aquí
    private String name;
    private int numNodes;
    private int numGPUs;
    private double ramCapacity;
    private LocalDate nextMaintenanceDate;
    private boolean isGPUEnabled;

    private final int MAX_MODELS;
    private Model[] models;
    private int numModels;

    // constructor //
    public ComputeCluster(String name, int numNodes, int numGPUs, double ramCapacity,
                          LocalDate nextMaintenanceDate, boolean isGPUEnabled, int maxModels) {
        setName(name);
        setNumNodes(numNodes);
        setNumGPUs(numGPUs);
        setRamCapacity(ramCapacity);
        setNextMaintenanceDate(nextMaintenanceDate);
        setGPUEnabled(isGPUEnabled);

        if (maxModels < 1) {
            throw new IllegalArgumentException(INVALID_MAX_MODELS);
        }

        this.MAX_MODELS = maxModels;
        this.models = new Model[maxModels];
        this.numModels = 0;
    }

    // Getters publicos
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

    public int getMaxModels() {
        return MAX_MODELS;
    }

    public int getNumModels() {
        return numModels;
    }

    public Model[] getModels() {
        return models;
    }

    // Setters privados
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

    // private methods (utilidad - pueden modificarse si dan error)
    private int findModel(Model model) {
        if (model == null) {
            throw new NullPointerException(MODEL_NULL);
        }
        for (int i = 0; i < numModels; i++) {
            if (models[i].equals(model)) {
                return i;
            }
        }
        return -1;
    }

    private boolean containsModel(Model model) {
        return findModel(model) != -1;
    }

    // public methods
    public void addModel(Model model) {
        if (model == null) {
            throw new NullPointerException(MODEL_NULL);
        }
        if (containsModel(model)) {
            throw new IllegalArgumentException(MODEL_ALREADY_EXISTS);
        }
        if (numModels >= MAX_MODELS) {
            throw new IllegalArgumentException(CANNOT_ADD_MODEL);
        }
        models[numModels++] = model;
    }

    public void removeModel(Model model) {
        if (model == null) {
            throw new NullPointerException(MODEL_NULL);
        }
        int index = findModel(model);
        if (index == -1) {
            throw new IllegalArgumentException(MODEL_NOT_FOUND);
        }
        for (int i = index; i < numModels - 1; i++) {
            models[i] = models[i + 1];
        }
        models[--numModels] = null;
    }

    public Model getBestModel() {
        if (numModels == 0) {
            return null;
        }
        Model bestModel = models[0];
        for (int i = 1; i < numModels; i++) {
            if (models[i].getF1Score() > bestModel.getF1Score()) {
                bestModel = models[i];
            }
        }
        return bestModel;
    }
}
