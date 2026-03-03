import java.util.ArrayList;
import java.util.List;

public class CampusLifeApp {

    public static void main(String[] args) {

        // courses
        Course oop = new Course("OOP", "Dr. Lee", 6);
        Course math = new Course("Discrete Math", "Prof. Kim", 4);
        Course english = new Course("English Literature", "Ms. Smith", 3);

        System.out.println("Курсы:");
        System.out.println(oop);
        System.out.println(math);
        System.out.println(english);
        System.out.println();

        // list of tasks
        List<PlanItem> schedule = new ArrayList<>();

        schedule.add(new AssignmentTask("Lab 2", oop, 1, 5));
        schedule.add(new AssignmentTask("Project Proposal", oop, 7, 8));
        schedule.add(new ExamPreparation("Midterm Discrete Math", math, 5, 15));
        schedule.add(new ClubEvent("K-pop rehearsal", "Dance Club", 2, 3));
        schedule.add(new AssignmentTask("Essay 1", english, 0, 6));
        schedule.add(new ExamPreparation("Final English", english, 12, 10));

        // printing

        System.out.println(" schedule ");
        int totalRemaining = 0;
        PlanItem mostUrgent = null;
        int minDaysUrgent = Integer.MAX_VALUE;

        for (PlanItem item : schedule) {
            System.out.println(item);
            if (item.isUrgent()) {
                System.out.println("   ★ СРОЧНО ★");
            }
            System.out.println("   Категория: " + item.getCategory());
            System.out.println("   Осталось: " + item.getRemainingHours() + " ч");
            System.out.println();

            totalRemaining += (int) item.getRemainingHours();

            if (item.isUrgent() && item.getDaysUntil() < minDaysUrgent) {
                minDaysUrgent = item.getDaysUntil();
                mostUrgent = item;
            }
        }

        System.out.println("Общее оставшееся время: " + totalRemaining + " часов");

        if (mostUrgent != null) {
            System.out.println("\nСамое срочное сейчас: " + mostUrgent);
        }

        //
        System.out.println("\nЗавершаем первое задание...");
        schedule.get(1).markCompleted();

        System.out.println("\nПосле обновления:");
        for (PlanItem item : schedule) {
            System.out.println(item + (item.isUrgent() ? "   ★ СРОЧНО ★" : ""));
        }

        // Study sessions
        System.out.println("\n=== Время учёбы (Study Sessions) ===");
        StudySession s1 = new StudySession(oop, 120);
        StudySession s2 = new StudySession(oop, 90);
        StudySession s3 = new StudySession(math, 60);

        System.out.println(s1 + " → " + s1.hours() + " ч");
        System.out.println(s2 + " → " + s2.hours() + " ч");
        System.out.println(s3 + " → " + s3.hours() + " ч");
    }
}