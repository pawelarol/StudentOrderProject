public class SaveStudentOrder {
    public static void main(String[] args) {
       StudentOrder so = new StudentOrder();

        so.hfirstName = "Arol";
        so.hlastName = "Pavel";
        so.wfirstName = "Arol";
        so.wlastName = "Anastasia";
        saveStudentOrder(so);
    }

    private static void saveStudentOrder(StudentOrder studentorder){
        long id = 199;
        System.out.println("SaveStudentOrder is running!!");
        System.out.println("First name applicant: " + studentorder.hfirstName);
    }
}
