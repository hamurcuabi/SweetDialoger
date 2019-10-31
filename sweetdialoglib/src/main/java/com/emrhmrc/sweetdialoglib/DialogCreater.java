package com.emrhmrc.sweetdialoglib;

import android.app.Activity;
import android.graphics.Color;

public class DialogCreater {

    private static String LOADING_COLOR = "#A5DC86";

    public static void basicDialog(Activity activity, String title) {
        new SweetAlertDialog(activity)
                .setTitleText(title)
                .show();
    }

    public static void basicDialog(Activity activity, String title, String content) {
        new SweetAlertDialog(activity)
                .setTitleText(title)
                .setContentText(content)
                .show();
    }

    public static void errorDialog(Activity activity, String content) {
        new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(activity.getResources().getString(R.string.info))
                .setContentText(content)
                .show();
    }

    public static void errorDialog(Activity activity, String title, String content) {
        new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(content)
                .show();
    }

    public static void warningDialog(Activity activity, String content) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(activity.getResources().getString(R.string.info))
                .setContentText(content)
                .show();
    }

    public static void succesDialog(Activity activity, String content) {
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(activity.getResources().getString(R.string.info))
                .setContentText(content)
                .show();
    }

    public static void succesDialog(Activity activity) {
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(activity.getResources().getString(R.string.info))
                .setContentText(activity.getResources().getString(R.string.succes))
                .show();
    }

    public static void questionDialog(Activity activity, DialogButtonListener listener,
                                      String question, int id) {

        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(activity.getResources().getString(R.string.sure))
                .setContentText(question)
                .setCancelText(activity.getResources().getString(R.string.no))
                .setConfirmText(activity.getResources().getString(R.string.yes))
                .showCancelButton(true)
                .setConfirmClickListener(sweetAlertDialog -> {

                    //Ok Do it
                    listener.onConfirmButton(id);
                    sweetAlertDialog.dismissWithAnimation();

                })
                .setCancelClickListener(sDialog -> {

                    //Dont do it
                    listener.onCancelButton(id);
                    sDialog.dismissWithAnimation();
                })
                .show();

    }

    public static SweetAlertDialog loadingDialog(Activity activity, String loadingText) {

        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(LOADING_COLOR));
        pDialog.setTitleText(loadingText);
        pDialog.setCancelable(false);
        pDialog.show();
        return pDialog;
    }

    public static SweetAlertDialog loadingDialog(Activity activity, String loadingText, boolean cancelable) {

        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(LOADING_COLOR));
        pDialog.setTitleText(loadingText);
        pDialog.setCancelable(cancelable);
        pDialog.showCancelButton(cancelable);
        pDialog.setCancelClickListener(sDialog -> {
            //Dont do it
            sDialog.dismissWithAnimation();
            //
        });
        pDialog.show();
        return pDialog;
    }

    public static SweetAlertDialog loadingDialog(Activity activity) {

        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(LOADING_COLOR));
        pDialog.setTitleText(activity.getResources().getString(R.string.loading));
        pDialog.setCancelable(false);
        pDialog.show();
        return pDialog;
    }

    public static SweetAlertDialog loadingDialog(Activity activity, boolean cancelable) {

        SweetAlertDialog pDialog = new SweetAlertDialog(activity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(LOADING_COLOR));
        pDialog.setTitleText(activity.getResources().getString(R.string.loading));
        pDialog.setCancelable(cancelable);
        pDialog.showCancelButton(cancelable);
        pDialog.setCancelClickListener(sDialog -> {
            //Dont do it
            sDialog.dismissWithAnimation();
        });
        pDialog.show();
        return pDialog;
    }

    public static void doneDialog(Activity activity) {
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(activity.getResources().getString(R.string.info))
                .setContentText(activity.getResources().getString(R.string.succes))
                .setConfirmClickListener(sweetAlertDialog -> sweetAlertDialog.dismissWithAnimation())
                .show();
    }

    public static void failDialog(Activity activity) {
        new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(activity.getResources().getString(R.string.info))
                .setContentText(activity.getResources().getString(R.string.fail))
                .setConfirmClickListener(sweetAlertDialog -> sweetAlertDialog.dismissWithAnimation())
                .show();
    }

    public static void changeDoneDialog(Activity activity, String question) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(activity.getResources().getString(R.string.sure))
                .setContentText(question)
                .setConfirmText(activity.getResources().getString(R.string.yes))
                .setCancelText(activity.getResources().getString(R.string.no))
                .setConfirmClickListener(sDialog -> sDialog
                        .setTitleText(activity.getResources().getString(R.string.info))
                        .setContentText(activity.getResources().getString(R.string.succes))
                        .setConfirmText(activity.getResources().getString(R.string.ok))
                        .showCancelButton(false)
                        .setConfirmClickListener(null)
                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE))
                .show();
    }

    public static void changeFailDialog(Activity activity, String question) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(activity.getResources().getString(R.string.sure))
                .setContentText(question)
                .setConfirmText(activity.getResources().getString(R.string.yes))
                .setCancelText(activity.getResources().getString(R.string.no))
                .setCancelClickListener(sDialog -> sDialog
                        .setTitleText(activity.getResources().getString(R.string.info))
                        .setContentText(activity.getResources().getString(R.string.fail))
                        .setConfirmText(activity.getResources().getString(R.string.ok))
                        .showCancelButton(false)
                        .setConfirmClickListener(null)
                        .changeAlertType(SweetAlertDialog.ERROR_TYPE))
                .show();
    }

    public static void changeFailOrDoneDialog(Activity activity, String question) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(activity.getResources().getString(R.string.sure))
                .setContentText(question)
                .setConfirmText(activity.getResources().getString(R.string.yes))
                .setCancelText(activity.getResources().getString(R.string.no))
                .setCancelClickListener(sDialog -> sDialog
                        .setTitleText(activity.getResources().getString(R.string.info))
                        .setContentText(activity.getResources().getString(R.string.fail))
                        .setConfirmText(activity.getResources().getString(R.string.ok))
                        .showCancelButton(false)
                        .setConfirmClickListener(null)
                        .changeAlertType(SweetAlertDialog.ERROR_TYPE))
                .setConfirmClickListener(sDialog -> sDialog
                        .setTitleText(activity.getResources().getString(R.string.info))
                        .setContentText(activity.getResources().getString(R.string.succes))
                        .setConfirmText(activity.getResources().getString(R.string.ok))
                        .showCancelButton(false)
                        .setConfirmClickListener(null)
                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE))
                .show();
    }
}
