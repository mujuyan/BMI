package com.example.mjy_bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText height,weight;
	String heigh_string,weight_string;
	TextView display;
	Button bmi;
	private double result;
	private double weight_double,height_double;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		height=(EditText) findViewById(R.id.height);
		weight=(EditText) findViewById(R.id.weight);
		display=(TextView) findViewById(R.id.display);
		bmi=(Button) findViewById(R.id.bmi);
		bmi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				//非空判断，去掉空格
				if (height.getText().toString().trim().length()==0) {
					//添加错误信息
					height.setError("请输入身高");
					return;//直接跳出当前的类
				}
				if (weight.getText().toString().trim().length()==0) {
					//添加错误信息
					weight.setError("请输入体重");
					return;//直接跳出当前的类
				}
				heigh_string=height.getText().toString().trim();
				weight_string=weight.getText().toString().trim();
				height_double=Double.valueOf(heigh_string);
				weight_double=Double.valueOf(weight_string);
				
				
				result=weight_double*1.0/height_double/height_double;
				
				if(result<18.5){
					
					display.setText("你的BMI值为"+result+"，呀，你太轻了，多吃点好吃的补补吧，不用担心长胖哦~");
					display.getText();
				}
				if(result>=18.5&&result<24){
					
					display.setText("你的BMI值为"+result+"，属于健康体重哦，继续保持哦~");
					display.getText();
				}
				if(result>=24&&result<28){
					display.setText("你的BMI值为"+result+"，哎呀，超重了哦，注意锻炼身体哦，使自己有一个健康的身体，加油，相信你！");
					display.getText();
				}
				if(result>=28){
					display.setText("你的BMI值为"+result+"，您处于肥胖状态哦，一定要注意锻炼身体了，拥有一个健康的身体很重要哦~");
					display.getText();
				}
					
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
