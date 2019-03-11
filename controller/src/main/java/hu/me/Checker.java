package hu.me;

public interface Checker {

    boolean noSpaceCheck(String password);
    boolean passwordLengthCheck(String password);
    boolean usernameLengthCheck(String username);
    void save(String username, String password);

}
