public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    private static void checkAll() {
        checkStudents();
        checkWedding();
        checkChildren();
        checkCityRegister();
    }

    private static void checkCityRegister() {
        System.out.println("CheckCityRegister is running!");
    }

    private static void checkChildren() {
        System.out.println("CheckChildren is running!");
    }

    private static void checkWedding() {
        System.out.println("CheckWedding is running!");
    }

    private static void checkStudents() {
        System.out.println("CheckStudents is running!");
    }
}
