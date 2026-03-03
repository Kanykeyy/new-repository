public class AssignmentTask extends PlanItem {

    private Course course;


    //constructor
    public AssignmentTask(String title, Course course, int daysUntil, int estimatedHours) {
        super(title, daysUntil, estimatedHours);
        this.course = course;
    }


    //methods
    public Course getCourse() {
        return course;
    }

    @Override
    public boolean isUrgent() {
        return getDaysUntil() <= 2 && !isCompleted();
    }

    @Override
    public String getCategory() {
        return "Assignment";
    }

    @Override
    public String toString() {
        return super.toString() + " → " + course.getName();
    }
}
