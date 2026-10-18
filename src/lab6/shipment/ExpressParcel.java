
package lab6.shipment;

class ExpressParcel extends StandardParcel {
    private final boolean sameDay;

    public ExpressParcel(double weightKg, double distanceKm, boolean insured,
                         String sizeTier, boolean sameDay) {
        // Reuse the StandardParcel setup for the shared attributes,
        // then store whether this is a same-day delivery.
        super(weightKg, distanceKm, insured, sizeTier);
        this.sameDay = sameDay;
    }

    @Override
    public double shippingCost() {
        // Build on Standard cost using super.<method>()
        double cost = super.shippingCost();
        // Express surcharge: faster delivery multiplier + optional same-day fee
        cost *= 1.35; // express speed premium
        // Same-day delivery adds a flat rush charge on top of the express price.
        if (sameDay) {
            double sameDayRushFee = 7.50;
            cost += sameDayRushFee;
        }
        return cost;
    }
}
