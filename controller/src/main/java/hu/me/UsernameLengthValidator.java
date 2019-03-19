package hu.me;

public class UsernameLengthValidator implements Checker {

    ValidatorResponse validatorResponse = new ValidatorResponse();

    @Override
    public ValidatorResponse valid(User user) {
        if (user.getUsername().length() <= 5) {
            validatorResponse.setMessage("A felhasznalonev nem eleg hosszu");
            validatorResponse.setValid(false);
        } else {
            validatorResponse.setValid(true);
        }
        return validatorResponse;
    }
}
