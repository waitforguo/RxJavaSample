package com.xh.rxjavademo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.Disposable


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = "MainActivity"

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvHi: TextView = findViewById(R.id.tvHi)
        tvHi.setOnClickListener(this)

        val tvFormCheck: TextView = findViewById(R.id.tvFormCheck)
        tvFormCheck.setOnClickListener {
            startActivity(Intent(this@MainActivity, FormCheckActivity::class.java))
        }

//        RxJavaTest.rxJavaTest()
//        RxJavaTest.rxJavaTestIO()
//        RxJavaTest.rxJavaJust()
//        RxJavaTest.rxJavaArray()
//        RxJavaTest.rxJavaTime()
//        RxJavaTest.rxJavaInterval()
//        RxJavaTest.rxJavaTestMap1()
//        RxJavaTest.rxJavaMap2()
//        RxJavaTest.rxJavaFlatMap()
//        RxJavaTest.rxJavaConcatMap()
//        RxJavaTest.rxJavaBuffer()
//        RxJavaTest.rxJavaConcat()
//        RxJavaTest.rxJavaMerge()
//        RxJavaTest.rxJavaConcatDelayError()
//        RxJavaTest.rxJavaMergeArrayDelayError()
//        RxJavaTest.rxJavaZip()
//        RxJavaTest.rxJavaCombineLatest()
//        RxJavaTest.rxJavaReduce()
//        RxJavaTest.rxJavaCollect()
//        RxJavaTest.rxJavaStartWithArray()
//        RxJavaTest.rxJavaCount()
//        RxJavaTest.rxJavaDoAction()
//        RxJavaTest.rxJavaOnErrorReturn()
//        RxJavaTest.rxJavaOnErrorResumeNext()
//        RxJavaTest.rxJavaOnExceptionResumeNext()
//        RxJavaTest.rxJavaRetry()
//        RxJavaTest.rxJavaRetryWhen()
//        RxJavaTest.rxJavaRepeat()
    }

    override fun onClick(v: View?) {
//        RxJavaTest.rxJavaIntervalRetrofit()
//        RxJavaTest.rxJavaRepeatWhenRetrofit()
//        RxJavaTest.rxJavaNestedRetrofit()
//        RxJavaTest.rxJavaMergeData()
//        RxJavaTest.rxJavaZipMergeData()
//        RxJavaTest.rxJavaGetData()
//        RxJavaTest.rxJavaThreadChanged()
//        RxJavaTest.rxJavaSchedulers()
        disposable = RxJavaTest.rxJavaRetryConnect()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}