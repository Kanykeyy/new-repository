public class ClubEvent extends PlanItem {

    private String clubName;

    public ClubEvent(String title, String clubName, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
        this.clubName = clubName;
    }

    @Override
    public boolean isUrgent() {
        return getDaysUntil() <= 3 && !isCompleted();
    }

    @Override
    public String getCategory() {
        return "Club Event";
    }

    @Override
    public String toString() {
        return super.toString() + " → " + clubName;
    }
}
