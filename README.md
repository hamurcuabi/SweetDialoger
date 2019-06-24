# SweetDialoger


1)
 compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }


2) implements DialogButtonListener

3)
public class MainActivity extends AppCompatActivity implements DialogButtonListener , View.OnClickListener {


    public  void Succes(View v) {
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
        DialogCreater.loadingDialog(this);
    }

    public void Done() {
        DialogCreater.doneDialog(this);
    }

    public void Fail() {
        DialogCreater.failDialog(this);
    }

    public void ChangeDone(View v) {
        DialogCreater.changeDoneDialog(this, "Question");
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

        switch (v.getId()){

            case R.id.btnDone:Done();break;
            case R.id.btnFail:Fail();break;
        }
    }
}
