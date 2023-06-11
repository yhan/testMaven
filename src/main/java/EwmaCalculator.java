
public class EwmaCalculator
{
    private double alpha; // Smoothing factor
    private double previousValue;
    private boolean isFirstValue;
    private long previousTimestamp;

    public EwmaCalculator(double alpha)
    {
        this.alpha = alpha;
        previousValue = 0;
        isFirstValue = true;
        previousTimestamp = 0;
    }

    public double calculate(double newValue, long timestamp)
    {
        if (isFirstValue)
        {
            isFirstValue = false;
            previousValue = newValue;
            previousTimestamp = timestamp;
            return newValue;
        }

        double timeDifference = timestamp - previousTimestamp;
        double weightedAlpha = Math.exp(-alpha * timeDifference);
        double smoothedValue = (weightedAlpha * newValue) + ((1 - weightedAlpha) * previousValue);
        previousValue = smoothedValue;
        previousTimestamp = timestamp;
        return smoothedValue;
    }
}

