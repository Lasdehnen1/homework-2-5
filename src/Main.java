import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String login = "boris1___";
        String password = "112fdfsf____";
        String confirmPassword = "112fdfsf____";


        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20) {
            throw new WrongLoginException("Превышена длина логина");
        }
        Pattern pt = Pattern.compile("^[aA-zZ(0-9)\\.]*$");
        Matcher mt = pt.matcher(login);
        if(!mt.matches()){
            throw new WrongLoginException("Некорректный логин");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Превышена длина пароля");
        }
        Matcher mt1 = pt.matcher(password);
        if(!mt1.matches()){
            throw new WrongLoginException("Некорректный пароль");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }


}