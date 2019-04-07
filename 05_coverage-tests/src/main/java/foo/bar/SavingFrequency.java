package foo.bar;

public enum SavingFrequency {
    EACH_DAY(1.00),
    EACH_WEEK(7.00),
    EACH_MONTH(30.42 ),
    EACH_SECOND_DAY(2.00),
    TWICE_A_WEEK(3.50),
    ONCE_A_YEAR(365.25);

    private double days;

    SavingFrequency(double days) {
        this.days = days;
    }

    public double getDays() {
        return days;
    }
}
