package saad.test.com.logintest.model;

import android.text.TextUtils;

import saad.test.com.logintest.presenter.LoginPresenter;
import saad.test.com.logintest.view.LoginView;

/**
 * Created by Saad Aftab on 21/05/2018.
 */

public class PresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public PresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void performLogin(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            loginView.loginValidations();
        } else {
            if (email.equals("saad@gmail.com") && password.equals("a")) {
                loginView.loginSuccess();
            } else {
                loginView.loginError();
            }
        }
    }

}
