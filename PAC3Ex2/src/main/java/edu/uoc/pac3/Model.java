package edu.uoc.pac3;

import java.time.LocalDate;

public class Model {

    // públicos CONSTANTES
    public static final String INVALID_NAME = "[ERROR] The name cannot be null, empty or have less than 3 characters";
    public static final String INVALID_DESCRIPTION = "[ERROR] The description cannot be null";
    public static final String INVALID_TP = "[ERROR] The number of true positives cannot be negative";
    public static final String INVALID_FP = "[ERROR] The number of false positives cannot be negative";
    public static final String INVALID_TN = "[ERROR] The number of true negatives cannot be negative";
    public static final String INVALID_FN = "[ERROR] The number of false negatives cannot be negative";
    public static final String INVALID_FIRST_TRAINING_DATE = "[ERROR] The first training date cannot be null or in the future";
    public static final String INVALID_LAST_TRAINING_DATE = "[ERROR] The last training date cannot be null, in the future or before the first training date";

    // privados CONSTANTES
    private static final int MIN_NAME_LENGTH = 3;
    private static int nextId = 1;


    // privados
    private int id;
    private String name;
    private String description;
    private int tp;
    private int fp;
    private int tn;
    private int fn;
    private LocalDate firstTrainingDate;
    private LocalDate lastTrainingDate;

    // constructor//
    public Model(String name, String description, int tp, int fp, int tn, int fn,
                 LocalDate firstTrainingDate, LocalDate lastTrainingDate) {
        setId();
        setName(name);
        setDescription(description);
        setTp(tp);
        setFp(fp);
        setTn(tn);
        setFn(fn);
        setFirstTrainingDate(firstTrainingDate);
        setLastTrainingDate(lastTrainingDate);
    }

    // getters public para diferenciar //
    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTp() {
        return tp;
    }

    public int getFp() {
        return fp;
    }

    public int getTn() {
        return tn;
    }

    public int getFn() {
        return fn;
    }

    public LocalDate getFirstTrainingDate() {
        return firstTrainingDate;
    }

    public LocalDate getLastTrainingDate() {
        return lastTrainingDate;
    }

    public double getPrecision() {
        int denominator = tp + fp;
        return denominator == 0 ? 0.0 : (double) tp / denominator;
    }

    public double getRecall() {
        int denominator = tp + fn;
        return denominator == 0 ? 0.0 : (double) tp / denominator;
    }

    public double getF1Score() {
        double precision = getPrecision();
        double recall = getRecall();
        double denominator = precision + recall;
        return denominator == 0 ? 0.0 : 2 * (precision * recall) / denominator;
    }

    // setters private para diferenciar
    private static void incNextId() {
        nextId++;
    }

    private void setId() {
        this.id = nextId;
        incNextId();
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name.trim();
    }

    private void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION);
        }
        this.description = description.trim();
    }

    private void setTp(int tp) {
        if (tp < 0) {
            throw new IllegalArgumentException(INVALID_TP);
        }
        this.tp = tp;
    }

    private void setFp(int fp) {
        if (fp < 0) {
            throw new IllegalArgumentException(INVALID_FP);
        }
        this.fp = fp;
    }

    private void setTn(int tn) {
        if (tn < 0) {
            throw new IllegalArgumentException(INVALID_TN);
        }
        this.tn = tn;
    }

    private void setFn(int fn) {
        if (fn < 0) {
            throw new IllegalArgumentException(INVALID_FN);
        }
        this.fn = fn;
    }

    private void setFirstTrainingDate(LocalDate firstTrainingDate) {
        if (firstTrainingDate == null || firstTrainingDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_FIRST_TRAINING_DATE);
        }
        this.firstTrainingDate = firstTrainingDate;
    }

    private void setLastTrainingDate(LocalDate lastTrainingDate) {
        if (lastTrainingDate == null || lastTrainingDate.isAfter(LocalDate.now()) ||
                (firstTrainingDate != null && lastTrainingDate.isBefore(firstTrainingDate))) {
            throw new IllegalArgumentException(INVALID_LAST_TRAINING_DATE);
        }
        this.lastTrainingDate = lastTrainingDate;
    }
}