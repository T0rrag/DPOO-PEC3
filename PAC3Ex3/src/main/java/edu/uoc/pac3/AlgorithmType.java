package edu.uoc.pac3;

public enum AlgorithmType {
    LINEAR_REGRESSION("Linear Regression", 0.75, 0.65, 1.0),
    Q_LEARNING("Q-Learning", 0.70, 0.60, 0.1),
    NEURAL_NETWORK("Neural Network", 0.92, 0.88, 0.001);

    private final String description;
    private final double expectedPrecision;
    private final double expectedRecall;
    private final double learningRate;

    AlgorithmType(String description, double expectedPrecision, double expectedRecall, double learningRate) {
        this.description = description;
        this.expectedPrecision = expectedPrecision;
        this.expectedRecall = expectedRecall;
        this.learningRate = learningRate;
    }

// dividir como en EX2 si da problemas (sanity)
    public String getDescription() {
        return description;
    }

    public double getExpectedPrecision() {
        return expectedPrecision;
    }

    public double getExpectedRecall() {
        return expectedRecall;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public double getExpectedF1Score() {
        double denominator = expectedPrecision + expectedRecall;
        return denominator == 0 ? 0.0 : 2 * (expectedPrecision * expectedRecall) / denominator;
    }

    public static AlgorithmType getType(String description) {
        if (description == null) {
            return null;
        }
        for (AlgorithmType type : values()) {
            if (type.description.equals(description)) {
                return type;
            }
        }
        return null;
    }

    public AlgorithmType getNextBetterLearningRate() {
        AlgorithmType[] values = values();
        int nextOrdinal = ordinal() + 1;
        return nextOrdinal < values.length ? values[nextOrdinal] : this;
    }
}