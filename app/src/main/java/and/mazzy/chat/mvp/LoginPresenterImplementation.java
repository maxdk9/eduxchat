package and.mazzy.chat.mvp;

import android.text.TextUtils;

import and.mazzy.chat.LoginActivity;
import and.mazzy.chat.R;

public class LoginPresenterImplementation implements LoginPresenter,LoginModel.onLoginFinishedListener {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImplementation(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImpementation();
    }

    @Override
    public void onCancelled() {
        loginView.ShowProgress(false);
    }

    @Override
    public void onPasswordError() {
        loginView.ShowProgress(false);
        loginView.setUserPasswordError(R.string.error_incorrect_password);

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void validateCredentials(String username, String password) {


        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            loginView.setUserPasswordError(R.string.error_invalid_password);
            return;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(username)) {
            loginView.setUserNameError(R.string.error_field_required);
            return;
        } else if (!isEmailValid(username)) {
            loginView.setUserNameError(R.string.error_invalid_email);
            return;
        }

        loginView.ShowProgress(true);
        loginModel.onLogin(username,password,this);
    }


    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}
