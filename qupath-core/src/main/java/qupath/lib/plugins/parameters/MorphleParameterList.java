package qupath.lib.plugins.parameters;

import java.io.Serializable;

public class MorphleParameterList implements Serializable {
    private String detectionImage;
    private String detectionImageBrightfield;
    private double requestedPixelSizeMicrons;
    private double backgroundRadiusMicrons;
    private double medianRadiusMicrons;
    private double sigmaMicrons;
    private double minAreaMicrons;
    private double maxAreaMicrons;
    private double threshold;
    private double maxBackground;
    private boolean watershedPostProcess;
    private boolean excludeDAB;
    private double cellExpansionMicrons;
    private boolean includeNuclei;
    private boolean smoothBoundaries;
    private boolean makeMeasurements;
    private boolean backgroundByReconstruction;
    private String thresholdCompartment;
    private double thresholdPositive1;
    private double thresholdPositive2;
    private double thresholdPositive3;
    private boolean singleThreshold;

    // Default constructor
    public MorphleParameterList() {}

    // Parameterized constructor
    public MorphleParameterList(String detectionImage, String detectionImageBrightfield, double requestedPixelSizeMicrons, double backgroundRadiusMicrons, double medianRadiusMicrons, double sigmaMicrons, double minAreaMicrons, double maxAreaMicrons, double backgroundRadius, double medianRadius, double sigma, double minArea, double maxArea, double threshold, double maxBackground, boolean watershedPostProcess, boolean excludeDAB, double cellExpansionMicrons, double cellExpansion, boolean includeNuclei, boolean smoothBoundaries, boolean makeMeasurements) {
        this.detectionImage = detectionImage;
        this.detectionImageBrightfield = detectionImageBrightfield;
        this.requestedPixelSizeMicrons = requestedPixelSizeMicrons;
        this.backgroundRadiusMicrons = backgroundRadiusMicrons;
        this.medianRadiusMicrons = medianRadiusMicrons;
        this.sigmaMicrons = sigmaMicrons;
        this.minAreaMicrons = minAreaMicrons;
        this.maxAreaMicrons = maxAreaMicrons;
        this.threshold = threshold;
        this.maxBackground = maxBackground;
        this.watershedPostProcess = watershedPostProcess;
        this.excludeDAB = excludeDAB;
        this.cellExpansionMicrons = cellExpansionMicrons;
        this.includeNuclei = includeNuclei;
        this.smoothBoundaries = smoothBoundaries;
        this.makeMeasurements = makeMeasurements;
        this.backgroundByReconstruction = backgroundByReconstruction;
        this.thresholdCompartment = thresholdCompartment;
        this.thresholdPositive1 = thresholdPositive1;
        this.thresholdPositive2 = thresholdPositive2;
        this.thresholdPositive3 = thresholdPositive3;
        this.singleThreshold = singleThreshold;
    }

    // Getters and Setters
    public String getDetectionImage() {
        return detectionImage;
    }

    public void setDetectionImage(String detectionImage) {
        this.detectionImage = detectionImage;
    }

    public String getDetectionImageBrightfield() {
        return detectionImageBrightfield;
    }

    public void setDetectionImageBrightfield(String detectionImageBrightfield) {
        this.detectionImageBrightfield = detectionImageBrightfield;
    }

    public double getRequestedPixelSizeMicrons() {
        return requestedPixelSizeMicrons;
    }

    public void setRequestedPixelSizeMicrons(double requestedPixelSizeMicrons) {
        this.requestedPixelSizeMicrons = requestedPixelSizeMicrons;
    }

    public double getBackgroundRadiusMicrons() {
        return backgroundRadiusMicrons;
    }

    public void setBackgroundRadiusMicrons(double backgroundRadiusMicrons) {
        this.backgroundRadiusMicrons = backgroundRadiusMicrons;
    }

    public double getMedianRadiusMicrons() {
        return medianRadiusMicrons;
    }

    public void setMedianRadiusMicrons(double medianRadiusMicrons) {
        this.medianRadiusMicrons = medianRadiusMicrons;
    }

    public double getSigmaMicrons() {
        return sigmaMicrons;
    }

    public void setSigmaMicrons(double sigmaMicrons) {
        this.sigmaMicrons = sigmaMicrons;
    }

    public double getMinAreaMicrons() {
        return minAreaMicrons;
    }

    public void setMinAreaMicrons(double minAreaMicrons) {
        this.minAreaMicrons = minAreaMicrons;
    }

    public double getMaxAreaMicrons() {
        return maxAreaMicrons;
    }

    public void setMaxAreaMicrons(double maxAreaMicrons) {
        this.maxAreaMicrons = maxAreaMicrons;
    }

//    public double getBackgroundRadius() {
//        return backgroundRadius;
//    }
//
//    public void setBackgroundRadius(double backgroundRadius) {
//        this.backgroundRadius = backgroundRadius;
//    }
//
//    public double getMedianRadius() {
//        return medianRadius;
//    }
//
//    public void setMedianRadius(double medianRadius) {
//        this.medianRadius = medianRadius;
//    }
//
//    public double getSigma() {
//        return sigma;
//    }
//
//    public void setSigma(double sigma) {
//        this.sigma = sigma;
//    }
//
//    public double getMinArea() {
//        return minArea;
//    }
//
//    public void setMinArea(double minArea) {
//        this.minArea = minArea;
//    }
//
//    public double getMaxArea() {
//        return maxArea;
//    }
//
//    public void setMaxArea(double maxArea) {
//        this.maxArea = maxArea;
//    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getMaxBackground() {
        return maxBackground;
    }

    public void setMaxBackground(double maxBackground) {
        this.maxBackground = maxBackground;
    }

    public boolean isWatershedPostProcess() {
        return watershedPostProcess;
    }

    public void setWatershedPostProcess(boolean watershedPostProcess) {
        this.watershedPostProcess = watershedPostProcess;
    }

    public boolean isExcludeDAB() {
        return excludeDAB;
    }

    public void setExcludeDAB(boolean excludeDAB) {
        this.excludeDAB = excludeDAB;
    }

    public double getCellExpansionMicrons() {
        return cellExpansionMicrons;
    }

    public void setCellExpansionMicrons(double cellExpansionMicrons) {
        this.cellExpansionMicrons = cellExpansionMicrons;
    }

//    public double getCellExpansion() {
//        return cellExpansion;
//    }
//
//    public void setCellExpansion(double cellExpansion) {
//        this.cellExpansion = cellExpansion;
//    }

    public boolean isIncludeNuclei() {
        return includeNuclei;
    }

    public void setIncludeNuclei(boolean includeNuclei) {
        this.includeNuclei = includeNuclei;
    }

    public boolean isSmoothBoundaries() {
        return smoothBoundaries;
    }

    public void setSmoothBoundaries(boolean smoothBoundaries) {
        this.smoothBoundaries = smoothBoundaries;
    }

    public boolean isMakeMeasurements() {
        return makeMeasurements;
    }

    public void setMakeMeasurements(boolean makeMeasurements) {
        this.makeMeasurements = makeMeasurements;
    }

    public boolean isBackgroundByReconstruction() {
        return backgroundByReconstruction;
    }

    public void setBackgroundByReconstruction(boolean backgroundByReconstruction) {
        this.backgroundByReconstruction = backgroundByReconstruction;
    }

    // Getter and Setter for thresholdCompartment
    public String getThresholdCompartment() {
        return thresholdCompartment;
    }

    public void setThresholdCompartment(String thresholdCompartment) {
        this.thresholdCompartment = thresholdCompartment;
    }

    // Getter and Setter for thresholdPositive1
    public double getThresholdPositive1() {
        return thresholdPositive1;
    }

    public void setThresholdPositive1(double thresholdPositive1) {
        this.thresholdPositive1 = thresholdPositive1;
    }

    // Getter and Setter for thresholdPositive2
    public double getThresholdPositive2() {
        return thresholdPositive2;
    }

    public void setThresholdPositive2(double thresholdPositive2) {
        this.thresholdPositive2 = thresholdPositive2;
    }

    // Getter and Setter for thresholdPositive3
    public double getThresholdPositive3() {
        return thresholdPositive3;
    }

    public void setThresholdPositive3(double thresholdPositive3) {
        this.thresholdPositive3 = thresholdPositive3;
    }

    // Getter and Setter for singleThreshold
    public boolean isSingleThreshold() {
        return singleThreshold;
    }

    public void setSingleThreshold(boolean singleThreshold) {
        this.singleThreshold = singleThreshold;
    }
}