package com.example.administrator.mystudent.ShakeShake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.mystudent.R;



public class ShakeActivity extends AppCompatActivity {
    private static final String TAG = "摇一摇";
    private static final int SENSOR_SHAKE = 10;
    private ImageView mImageShake;
    private SensorManager mSensorManager;
    private Vibrator mVibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        init();
    }

    private void init() {
        mImageShake= (ImageView) findViewById(R.id.iv_shake);
        mSensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        mVibrator= (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    /**
     * 但显示当前界面的时候
     */
    @Override
    protected void onResume() {
        super.onResume();
        if(mSensorManager!=null){
            // 第一个参数是Listener，第二个参数是所得传感器类型，第三个参数值获取传感器信息的频率
            mSensorManager.registerListener(mSensorEventListener,mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mSensorManager != null) {
            // 取消监听器
            mSensorManager.unregisterListener(mSensorEventListener);
        }
    }

    //传感器监听类
  private SensorEventListener mSensorEventListener=new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
             // 传感器信息改变时执行该方法
            float[] values = event.values;
            float x = values[0]; // x轴方向的重力加速度，向右为正
            float y = values[1]; // y轴方向的重力加速度，向前为正
            float z = values[2]; // z轴方向的重力加速度，向上为正
            // 一般在这三个方向的重力加速度达到40就达到了摇晃手机的状态。
            int medumValue = 18;// 如果不敏感请自行调低该数值,低于10的话就不行了,因为z轴上的加速度本身就已经达到10了
            if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
                mVibrator.vibrate(200);
                Message msg = new Message();
                msg.what = SENSOR_SHAKE;
                handler.sendMessage(msg);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
         //当传感器的精度变化时会调用
        }
    };

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==SENSOR_SHAKE){
                setAimation();
                setVoice();
                Toast.makeText(getApplicationContext(),"恭喜你摇到了iphone7",Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void setVoice() {

        SoundPool  sp= new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        sp.load(this,R.raw.clock, 1); //第二个参数是音乐资源文件
        sp.play(1, 1, 1, 0, 0, 1);//播放声音
    }

    private void setAimation() {
        RotateAnimation ra=new RotateAnimation(0.0f, 60.0f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(200);
        mImageShake.startAnimation(ra);
    }

}
