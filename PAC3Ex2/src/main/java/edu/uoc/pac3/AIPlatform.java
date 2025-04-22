package edu.uoc.pac3;

import java.time.LocalDate;

public class AIPlatform {
    // Constants
    public static final String INVALID_NAME = "[ERROR] The name cannot be null and it can only contain characters and spaces";
    public static final String INVALID_DESCRIPTION = "[ERROR] The description cannot be null, empty or blank";
    public static final String INVALID_DOMAIN = "[ERROR] The domain cannot be null and must be a valid domain: 'www.example.com'";
    public static final String INVALID_RELEASE_DATE = "[ERROR] The release date cannot be null or in the future";
    private static final int MAX_CONCURRENT_USERS = 100;

    // Attributes
    private String name;
    private String description;
    private String domain;
    private LocalDate releaseDate;
    private int maxConcurrentUsers;
    private ComputeCluster cluster;

    // Constructors
    public AIPlatform(String name, String description, String domain, LocalDate releaseDate, int maxConcurrentUsers) {
        setName(name);
        setDescription(description);
        setDomain(domain);
        setReleaseDate(releaseDate);
        setMaxConcurrentUsers(maxConcurrentUsers);
        this.cluster = null;
    }

    public AIPlatform(String name, String description, String domain, LocalDate releaseDate, int maxConcurrentUsers, String clusterName, int numNodes, int numGPUs, double ramCapacity, LocalDate nextMaintenanceDate, boolean isGPUEnabled, int maxModels) {
        setName(name);
        setDescription(description);
        setDomain(domain);
        setReleaseDate(releaseDate);
        setMaxConcurrentUsers(maxConcurrentUsers);
        setCluster(clusterName, numNodes, numGPUs, ramCapacity, nextMaintenanceDate, isGPUEnabled, maxModels);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDomain() {
        return domain;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getMaxConcurrentUsers() {
        return maxConcurrentUsers;
    }

    public ComputeCluster getCluster() {
        return cluster;
    }

    // Setters
    private void setName(String name) {
        if (name == null || !name.matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        name = name.trim();
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    private void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION);
        }
        this.description = description.trim();
    }

    private void setDomain(String domain) {
        if (domain == null || !domain.matches("^(?!-)[a-z0-9-]+(?<!-)(?:\\.(?!-)[a-z0-9-]+(?<!-))*\\.[a-z]{2,}$")) {
            throw new IllegalArgumentException(INVALID_DOMAIN);
        }
        this.domain = domain;
    }

    private void setReleaseDate(LocalDate releaseDate) {
        if (releaseDate == null || releaseDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_RELEASE_DATE);
        }
        this.releaseDate = releaseDate;
    }

    private void setMaxConcurrentUsers(int maxConcurrentUsers) {
        if (maxConcurrentUsers < 1) {
            this.maxConcurrentUsers = 1;
        } else if (maxConcurrentUsers > MAX_CONCURRENT_USERS) {
            this.maxConcurrentUsers = MAX_CONCURRENT_USERS;
        } else {
            this.maxConcurrentUsers = maxConcurrentUsers;
        }
    }

    private void setCluster(String name, int numNodes, int numGPUs, double ramCapacity, LocalDate nextMaintenanceDate, boolean isGPUEnabled, int maxModels) {
        try {
            this.cluster = new ComputeCluster(name, numNodes, numGPUs, ramCapacity, nextMaintenanceDate, isGPUEnabled, maxModels);
        } catch (IllegalArgumentException e) {
            this.cluster = null;
        }
    }
}