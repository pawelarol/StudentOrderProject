public class CityRegisterValidator {
    String host;
    String login;
    String password;

   public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        System.out.println("CheckCityRegister is running!" + host + login + password);
        AnswerCityRegister ansCityRegister = new AnswerCityRegister();
        ansCityRegister.succses = false;
        return ansCityRegister;
    }
}
