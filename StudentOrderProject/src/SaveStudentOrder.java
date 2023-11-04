public class SaveStudentOrder {
    public static void main(String[] args) {
       Studentorder so = new Studentorder();

        so.hfirstName = "Arol";
        so.hlastName = "Pavel";
        so.wfirstName = "Arol";
        so.wlastName = "Anastasia";
        saveStudentOrder(so);
    }

    private static void saveStudentOrder(Studentorder studentorder){
        System.out.println("SaveStudentOrder is running!!");
        System.out.println("First name applicant: " + studentorder.hfirstName);
    }
}
