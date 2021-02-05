package com.xh.rxjavademo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jakewharton.rxbinding2.widget.RxTextView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;

/**
 * @author FuZhiXue(Fran)
 * @date 2021/1/28 9:08 PM
 */
public class FormCheckActivity extends AppCompatActivity {
    private static final String TAG = "FormCheckActivity";

    /**
     * 步骤1：设置控件变量 & 绑定
     */
    private EditText tvName, tvAge, tvJob;
    private Button btnList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_from_check);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvJob = findViewById(R.id.tvJob);
        btnList = findViewById(R.id.btnList);

        // 步骤2：为每个EditText设置被观察者，用于发送监听事件

        /*
         * 说明：
         * 1. 此处采用了RxBinding：RxTextView.textChanges(name) = 对对控件数据变更进行监听（功能类似TextWatcher），需要引入依赖：compile 'com.jakewharton.rxbinding2:rxbinding:2.0.0'
         * 2. 传入EditText控件，点击任1个EditText撰写时，都会发送数据事件 = Function3（）的返回值（下面会详细说明）
         * 3. 采用skip(1)原因：跳过 一开始EditText无任何输入时的空值
         **/
        Observable<CharSequence> observableName = RxTextView.textChanges(tvName).skip(1);
        Observable<CharSequence> observableAge = RxTextView.textChanges(tvAge).skip(1);
        Observable<CharSequence> observableJob = RxTextView.textChanges(tvJob).skip(1);

        // 步骤3：通过combineLatest（）合并事件 & 联合判断
        Disposable disposable = Observable.combineLatest(observableName, observableAge, observableJob, new Function3<CharSequence, CharSequence, CharSequence, Boolean>() {
            @NonNull
            @Override
            public Boolean apply(@NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, @NonNull CharSequence charSequence3) throws Exception {
                // 步骤4：规定表单信息输入不能为空
                // 1. 姓名信息
                boolean isUserNameValid = !TextUtils.isEmpty(tvName.getText());
                // 除了设置为空，也可设置长度限制
//                boolean isUserNameValid = !TextUtils.isEmpty(tvName.getText()) && (tvName.getText().toString().length() > 2 && tvName.getText().toString().length() < 9);

                // 2. 年龄信息
                boolean isUserAgeValid = !TextUtils.isEmpty(tvAge.getText());

                // 3. 职业信息
                boolean isUserJobValid = !TextUtils.isEmpty(tvJob.getText());

                // 步骤5：返回信息 = 联合判断，即3个信息同时已填写，"提交按钮"才可点击
                return isUserNameValid && isUserAgeValid && isUserJobValid;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean enable) throws Exception {
                        // 步骤6：返回结果 & 设置按钮可点击样式
                        Log.e(TAG, "提交按钮是否可点击： " + enable);
                        btnList.setEnabled(enable);
                    }
                });
    }
}
