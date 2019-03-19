package hu.me;

public class NoSpaceValidator implements Checker {

    ValidatorResponse validatorResponse = new ValidatorResponse();

    @Override
    public ValidatorResponse valid(User user) {
        if (user.getPassword().contains(" ")) {
            validatorResponse.setMessage("A jelszo nem tartalmazhat szokozt");
            validatorResponse.setValid(false);
        } else {
            validatorResponse.setValid(true);
        }
        return validatorResponse;
    }
}
