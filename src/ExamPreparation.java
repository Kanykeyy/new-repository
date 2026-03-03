public class ExamPreparation extends PlanItem {

    private Course course;

    public ExamPreparation(String title, Course course, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
        this.course = course;
    }

    @Override
    public boolean isUrgent() {
        return getDaysUntil() <= 7 && !isCompleted();
    }

    @Override
    public String getCategory() {
        return "Exam Prep";
    }

    @Override
    public String toString() {
        return super.toString() + " → " + course.getName();
    }
}