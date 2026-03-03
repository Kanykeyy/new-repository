public abstract class PlanItem {

    private String title;
    private int daysUntil;
    private int estimatedHours;
    private boolean completed;

    public PlanItem(String title, int daysUntil, int estimatedHours) {
        this.title = title;
        this.daysUntil = daysUntil;
        this.estimatedHours = estimatedHours;
        this.completed = false;
    }

    public String getTitle() { return title; }
    public int getDaysUntil() { return daysUntil; }
    public int getEstimatedHours() { return estimatedHours; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() {
        completed = true;
    }

    public double getRemainingHours() {
        return completed ? 0 : estimatedHours;
    }

    public abstract boolean isUrgent();
    public abstract String getCategory();

    @Override
    public String toString() {
        String status = completed ? "✓ завершено" : "в работе";
        return String.format("%-12s \"%s\" (дней: %2d, часов: %2d, %s)",
                "[" + getCategory() + "]", title, daysUntil, estimatedHours, status);
    }
}