public class StudentOrderValidator {
    public static void main(String[] args) {

        checkAll();
    }

    private static void checkAll() {
        while (true){
        StudentOrder so = readStudentOrder();
        if(so == null) {
            break;
        }
        AnswerCityRegister ansCityRegister = checkCityRegister(so);
            if (!ansCityRegister.succses) {
                sendBadMail(so);
                continue;
            }
            checkStudents(so);
            checkWedding(so);
            checkChildren(so);
            sendMail(so);
        }
      }

    private static void sendBadMail(StudentOrder so) {
        System.out.println("Bad mail have sent!");
    }

    static StudentOrder readStudentOrder() {
        return new StudentOrder();
    }
    private static void sendMail(StudentOrder studentOrder) {
        System.out.println("Mail have sent!");
    }


    public static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        CityRegisterValidator checkCity = new CityRegisterValidator();
       checkCity.host = "1";
       checkCity.login = "CityRegister";
       checkCity.password = "12345678";
       AnswerCityRegister ans = checkCity.checkCityRegister(studentOrder);
       return ans;
    }

    private static AnswerChildren checkChildren(StudentOrder studentOrder) {
        CheckChildren checkChild = new CheckChildren();
        checkChild.host = "2";
        checkChild.login = "CheckChildren";
        checkChild.password = "12345123";
        AnswerChildren ansChildren = checkChild.checkChildren(studentOrder);
        return ansChildren;
    }

    private static AnswerWedding checkWedding(StudentOrder studentOrder) {
       CheckWedding checkWed = new CheckWedding();
       checkWed.host = "3";
       checkWed.login = "CheckWedding";
       checkWed.password = "12341234";
        AnswerWedding ansWedding = checkWed.checkWedding(studentOrder);
        return ansWedding;
    }

    private static AnswerStudents checkStudents(StudentOrder studentOrder) {
        CheckStudents checkStud = new CheckStudents();
        checkStud.host = "4";
        checkStud.login = "CheckStudents";
        checkStud.password = "12344321";
        AnswerStudents ansStudents = checkStud.checkStudents(studentOrder);
        return ansStudents;
    }
}
