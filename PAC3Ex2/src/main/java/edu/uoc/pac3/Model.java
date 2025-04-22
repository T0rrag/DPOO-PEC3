package edu.uoc.pac3;

import java.time.LocalDate;
import java.lang.reflect.Field;

public class Model implements Comparable<Model> {
    public static final int MIN_NAME_LENGTH = 3;
    public static final String INVALID_NAME = "[ERROR] The name cannot be null, empty or have less than 3 characters";
    public static final String INVALID_DESCRIPTION = "[ERROR] The description cannot be null";
    public static final String INVALID_TP = "[ERROR] The number of true positives cannot be negative";
    public static final String INVALID_FP = "[ERROR] The number of false positives cannot be negative";
    public static final String INVALID_TN = "[ERROR] The number of true negatives cannot be negative";
    public static final String INVALID_FN = "[ERROR] The number of false negatives cannot be negative";
    public static final String INVALID_FIRST_TRAINING_DATE = "[ERROR] The first training date cannot be null or in the future";
    public static final String INVALID_LAST_TRAINING_DATE = "[ERROR] The last training date cannot be null, in the future or before the first training date";

    private static int nextId = 1; // Static field to generate unique ids
    private final int id; // Unique ID for each model
    private String name;
    private String description;
    private int tp; // True Positives
    private int fp; // False Positives
    private int tn; // True Negatives
    private int fn; // False Negatives
    private LocalDate firstTrainingDate;
    private LocalDate lastTrainingDate;

    public Model(String name, String description, int tp, int fp, int tn, int fn, LocalDate firstTrainingDate, LocalDate lastTrainingDate) {
        this.id = nextId++; // Assign the current value of nextId and then increment it
        setName(name);
        setDescription(description);
        setTp(tp);
        setFp(fp);
        setTn(tn);
        setFn(fn);
        setFirstTrainingDate(firstTrainingDate);
        setLastTrainingDate(lastTrainingDate);
    }

    // Added method to reset nextId for testing purposes using reflection
    public static void resetNextId() throws NoSuchFieldException, IllegalAccessException {
        Field field = Model.class.getDeclaredField("nextId");
        field.setAccessible(true); // Allows access to the private static field
        field.set(null, 1); // Set nextId back to 1 (null as the instance for static field)
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION);
        }
        this.description = description.trim();
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        if (tp < 0) {
            throw new IllegalArgumentException(INVALID_TP);
        }
        this.tp = tp;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        if (fp < 0) {
            throw new IllegalArgumentException(INVALID_FP);
        }
        this.fp = fp;
    }

    public int getTn() {
        return tn;
    }

    public void setTn(int tn) {
        if (tn < 0) {
            throw new IllegalArgumentException(INVALID_TN);
        }
        this.tn = tn;
    }

    public int getFn() {
        return fn;
    }

    public void setFn(int fn) {
        if (fn < 0) {
            throw new IllegalArgumentException(INVALID_FN);
        }
        this.fn = fn;
    }

    public LocalDate getFirstTrainingDate() {
        return firstTrainingDate;
    }

    public void setFirstTrainingDate(LocalDate firstTrainingDate) {
        if (firstTrainingDate == null || firstTrainingDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_FIRST_TRAINING_DATE);
        }
        this.firstTrainingDate = firstTrainingDate;
    }

    public LocalDate getLastTrainingDate() {
        return lastTrainingDate;
    }

    public void setLastTrainingDate(LocalDate lastTrainingDate) {
        if (lastTrainingDate == null || lastTrainingDate.isAfter(LocalDate.now()) || lastTrainingDate.isBefore(firstTrainingDate)) {
            throw new IllegalArgumentException(INVALID_LAST_TRAINING_DATE);
        }
        this.lastTrainingDate = lastTrainingDate;
    }

    public double getPrecision() {
        return (tp + fp == 0) ? 0 : (double) tp / (tp + fp);
    }

    public double getRecall() {
        return (tp + fn == 0) ? 0 : (double) tp / (tp + fn);
    }

    public double getF1Score() {
        double precision = getPrecision();
        double recall = getRecall();
        return (precision + recall == 0) ? 0 : 2 * (precision * recall) / (precision + recall);
    }

    public double getF1ScoreAsPercentage() {
        return getF1Score() * 100;
    }

    public boolean isValid() {
        return name != null && name.length() >= MIN_NAME_LENGTH &&
                description != null &&
                tp >= 0 && fp >= 0 && tn >= 0 && fn >= 0 &&
                firstTrainingDate != null && !firstTrainingDate.isAfter(LocalDate.now()) &&
                lastTrainingDate != null && !lastTrainingDate.isAfter(LocalDate.now()) && !lastTrainingDate.isBefore(firstTrainingDate);
    }

    public static int getMinNameLength() {
        return MIN_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return "Model{id=" + id + ", name='" + name + "', description='" + description + "', tp=" + tp +
                ", fp=" + fp + ", tn=" + tn + ", fn=" + fn +
                ", firstTrainingDate=" + firstTrainingDate + ", lastTrainingDate=" + lastTrainingDate + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id == model.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public int compareTo(Model other) {
        return Double.compare(this.getF1Score(), other.getF1Score());
    }
}
