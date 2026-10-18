
package lab6.shipment;


class StandardParcel extends Parcel {
    // sizeTier: S/M/L affects handling
    protected final String sizeTier;

    public StandardParcel(double weightKg, double distanceKm, boolean insured, String sizeTier) {
        super(weightKg, distanceKm, insured);
        if (!sizeTier.matches("[SML]")) {
            throw new IllegalArgumentException("sizeTier must be S, M, or L");
        }
        this.sizeTier = sizeTier;
    }

    @Override
    public double shippingCost() {
        double cost = super.shippingCost();
        double sizeHandlingFee = 0;
        // Add a handling surcharge that depends on how big the parcel is.
        switch (sizeTier) {
            case "S":
                sizeHandlingFee = 0.75;
                break;
            case "M":
                sizeHandlingFee = 1.25;
                break;
            case "L":
                sizeHandlingFee = 1.75;
                break;
        }
        return cost + sizeHandlingFee;
    }

}
