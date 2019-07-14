# SweetDialoger
	
SweetDialoger makes dialogs to get rid of writing massy codes again and again.

## Prerequisites

Add this in your module `build.gradle` file between android tags (**not** your root `build.gradle` file):

```gradle
compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	 implementation 'com.github.hamurcuabi:SweetDialoger:-SNAPSHOT'
}
```
## Usage
This following basic methodes have default variables. First add this to your Activity

public class MainActivity extends AppCompatActivity **implements DialogButtonListener** , View.OnClickListener


To display basic success Dialog:

``` java
DialogCreater.succesDialog(this);
```
To display basic error Dialog:

``` java
 DialogCreater.errorDialog(this, "Error Message");
```
To display basic info Dialog:

``` java
DialogCreater.basicDialog(this, "Title", "Basic Content");
```
To display basic warning Dialog:

``` java
DialogCreater.warningDialog(this, "Warning Message");
```

To display basic question Dialog:

``` java
DialogCreater.questionDialog(this, this, "Question ?", 1);
```
To display basic loading Dialog:

``` java
DialogCreater.loadingDialog(this);
```
To display basic done Dialog:

``` java
DialogCreater.doneDialog(this);
```
To display basic fail Dialog:

``` java
DialogCreater.failDialog(this);
```
To display basic changeDone Dialog:

``` java
DialogCreater.changeDoneDialog(this, "Question");
```
To display basic changeFailDialog:

``` java
DialogCreater.changeFailDialog(this, "Question");
```
Done and Fail Dialog methodes:
``` java
 public void Done() {
        DialogCreater.doneDialog(this);
    }

    public void Fail() {
        DialogCreater.failDialog(this);
    }

```


``` java
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
```


