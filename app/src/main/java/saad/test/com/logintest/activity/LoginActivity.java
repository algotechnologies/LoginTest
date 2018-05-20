package saad.test.com.logintest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import saad.test.com.logintest.R;
import saad.test.com.logintest.model.PresenterImpl;
import saad.test.com.logintest.presenter.LoginPresenter;
import saad.test.com.logintest.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        initListeners();

        loginPresenter = new PresenterImpl(this);

    }

    private void initViews() {
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }

    private void initListeners() {
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        loginPresenter.performLogin(email, password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(), "Email & Password should not be blank!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_SHORT).show();
    }
}
