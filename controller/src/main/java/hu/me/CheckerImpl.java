package hu.me;
public class CheckerImpl implements Checker {

    @Override
    public boolean noSpaceCheck(String pw) {
        if (pw.contains(" "))
            return false;
        return true;
    }

    @Override
    public boolean passwordLengthCheck(String pw) {
        if(pw.length() < 6)
            return false;
        return true;
    }

    @Override
    public boolean usernameLengthCheck(String uname) {
        if (uname.length() < 6)
            return false;
        return true;
    }

    @Override
    public void save(String uname, String pw) {
        if(noSpaceCheck(pw))
            System.out.println("A jelszóban nem lehet szóköz!");
        else if(!passwordLengthCheck(pw))
            System.out.println("A jelszó minimum 6 karakterből álljon!");
        else if(!usernameLengthCheck(uname))
            System.out.println("A felhasználónév minimum 6 karakterből álljon");
        else
            System.out.println(uname + " nevű felhasználó eltárolva");
    }

}
