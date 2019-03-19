package hu.me;

public class PasswordLengthValidator implements Checker {

    ValidatorResponse validatorResponse = new ValidatorResponse();

    @Override
    public ValidatorResponse valid(User user) {
        if (user.getPassword().length() <= 5) {
            validatorResponse.setMessage("A jelszo nem eleg hosszu");
            validatorResponse.setValid(false);
        } else {
            validatorResponse.setValid(true);
        }
        return validatorResponse;
    }
}
