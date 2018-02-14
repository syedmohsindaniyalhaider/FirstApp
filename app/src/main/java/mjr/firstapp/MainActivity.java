package mjr.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSubmit;
    private EditText userInput, passwordInput, confirmPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sID();
        afterClick();
    }
    private void sID() {
        userInput = (EditText) findViewById(R.id.userId);
        passwordInput = (EditText) findViewById(R.id.inputPassword);
        btnSubmit = (Button) findViewById(R.id.buttonId);
        confirmPassword = (EditText) findViewById(R.id.passwordConfirm);
    }
    private void afterClick(){
        btnSubmit.setOnClickListener(this);
    }
    private void validateFields() {
        String u_i = userInput.getText().toString();
        String p_i = passwordInput.getText().toString();
        String c_p = confirmPassword.getText().toString();
        if(u_i.equals("")){
            userInput.setError(getResources().getString(R.string.username_error));
            getCurrentFocus();
            return;
        }
        if(p_i.equals("")){
            passwordInput.setError(getResources().getString(R.string.password_error));
            getCurrentFocus();
            return;
        }
        if(  c_p.equals("")){
            confirmPassword.setError(getResources().getString(R.string.confirm_password_error));
            getCurrentFocus();
            return;
        }
        if(!p_i.equals(c_p)){
            confirmPassword.setError("Your Password does not match");
            getCurrentFocus();
            return;
        }
        startActivity(new Intent(this,SecondActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonId:
                validateFields();
                break;
        }
    }
}