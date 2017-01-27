package net.buildbox.sample.sample_android_rate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import hotchemi.android.rate.AppRate;
import hotchemi.android.rate.OnClickButtonListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppRate.with(this)
            .setInstallDays(0) // 起動した回数のカウントを開始する日をインストール日基準で指定。デフォルトは 10(日)後。0だとインストール初日
            .setLaunchTimes(3) // レイティングのダイアログを表示するまでの起動した回数。 デフォルトは10
            .setRemindInterval(2) // "後で"をクリックしたときのリマインドの間隔。デフォルトは 1(日)
            .setShowLaterButton(true) // ”後で”のボタンを表示するか。デフォルトは true
            .setDebug(false) // デバッグログを吐き出すか。デフォルトは false
            .setOnClickButtonListener(new OnClickButtonListener() { // ボタンクリックのコールバック
                @Override
                public void onClickButton(int which) {
                    Log.d(MainActivity.class.getName(), Integer.toString(which));
                }
            })
            .monitor();

        // 条件に合致したら表示
        AppRate.showRateDialogIfMeetsConditions(this);
    }
}
