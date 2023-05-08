package com.example.helloworld;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * 该自定义Dialog应用在：弹出框居中显示图片，点击其他区域自动关闭Dialog
 *
 * @author SHANHY(365384722@QQ.COM)
 * @date   2015年12月4日
 */
public class CustomPickerDialog extends Dialog {

    private SelectDateCallback callback;

    private int year;
    private int month;
    private int day;

    public CustomPickerDialog(Context context) {
        super(context);
    }

    public void setCallback(SelectDateCallback callback) {
        this.callback = callback;
    }

    public static class Builder {
        private Context context;

        private DatePicker datePicker;

        private Button submitButton;
        private Button cancelButton;




        public Builder(Context context) {
            this.context = context;
        }



        public CustomPickerDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CustomPickerDialog dialog = new CustomPickerDialog(context);
            View layout = inflater.inflate(R.layout.dialog_date_picker, null);
//            dialog.addContentView(layout, new LayoutParams(
//                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT
//                    , android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
            dialog.setContentView(layout);
            datePicker = layout.findViewById(R.id.date_picker);
            Calendar calendar = Calendar.getInstance();
            dialog.year = calendar.get(Calendar.YEAR);
            dialog.month = calendar.get(Calendar.MONTH);
            dialog.day = calendar.get(Calendar.DAY_OF_MONTH);

            datePicker.init(dialog.year, dialog.month, dialog.day, new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                    dialog.year = year;
                    dialog.month = month;
                    dialog.day = day;
                }
            });


            submitButton = layout.findViewById(R.id.submit_button);
            submitButton.setOnClickListener((view) -> {
                if(dialog.callback != null) {

                    dialog.callback.selectDate(dialog.year, dialog.month, dialog.day);
                }
                 dialog.dismiss();
            });

            cancelButton = layout.findViewById(R.id.cancel_button);
            cancelButton.setOnClickListener((view) -> {
                dialog.dismiss();
            });


            return dialog;
        }


    }
}