package com.emrhmrc.sweetdialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.emrhmrc.sweetdialoglib.DialogButtonListener;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.emrhmrc.sweetdialoglib.SweetAlertDialog;

public class MainActivity extends AppCompatActivity implements DialogButtonListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSucces = findViewById(R.id.btnSucces);
        Button btnError = findViewById(R.id.btnError);
        Button btnWarning = findViewById(R.id.btnWarning);
        Button btnBasic = findViewById(R.id.btnBasic);
        Button btnQuestion = findViewById(R.id.btnQuestion);
        Button btnLoading = findViewById(R.id.btnLoading);
        Button btnDone = findViewById(R.id.btnDone);
        Button btnFail = findViewById(R.id.btnFail);
        Button btnChangeDone = findViewById(R.id.btnChangeDone);
        Button btnChangeFail = findViewById(R.id.btnChangeFail);
        btnDone.setOnClickListener(this);
        btnFail.setOnClickListener(this);

    }

    public void Succes(View v) {
        DialogCreater.succesDialog(this);
    }

    public void Error(View v) {
        DialogCreater.errorDialog(this, "Error Message");
    }

    public void Warning(View v) {
        DialogCreater.warningDialog(this, "Warning Message");
    }

    public void Basic(View v) {
        DialogCreater.basicDialog(this, "Title", "Basic Content");
    }

    public void Question(View v) {
        DialogCreater.questionDialog(this, this, "Question ?", 1);
    }

    public void Loading(View v) {
        SweetAlertDialog loadingDialog = DialogCreater.loadingDialog(this, true);
        loadingDialog.showCancelButton(true);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissWithAnimation();
                DialogCreater.doneDialog(MainActivity.this);
            }
        }, 3000);


    }

    public void Done() {
        DialogCreater.doneDialog(this);
    }

    public void Fail() {
        DialogCreater.failDialog(this);
    }

    public void ChangeDone(View v) {
        DialogCreater.changeFailOrDoneDialog(this, "Question");
    }

    public void ChangeFail(View v) {
        DialogCreater.changeFailDialog(this, "Question");
    }

    @Override
    public void onConfirmButton(int id) {
        switch (id) {
            case 1:
                Done();
                break;
        }
    }

    @Override
    public void onCancelButton(int id) {
        switch (id) {
            case 1:
                Fail();
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnDone:
                Done();
                break;
            case R.id.btnFail:
                Fail();
                break;
        }
    }
}
