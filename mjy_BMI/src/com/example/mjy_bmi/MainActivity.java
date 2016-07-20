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
				// TODO �Զ����ɵķ������
				//�ǿ��жϣ�ȥ���ո�
				if (height.getText().toString().trim().length()==0) {
					//��Ӵ�����Ϣ
					height.setError("���������");
					return;//ֱ��������ǰ����
				}
				if (weight.getText().toString().trim().length()==0) {
					//��Ӵ�����Ϣ
					weight.setError("����������");
					return;//ֱ��������ǰ����
				}
				heigh_string=height.getText().toString().trim();
				weight_string=weight.getText().toString().trim();
				height_double=Double.valueOf(heigh_string);
				weight_double=Double.valueOf(weight_string);
				
				
				result=weight_double*1.0/height_double/height_double;
				
				if(result<18.5){
					
					display.setText("���BMIֵΪ"+result+"��ѽ����̫���ˣ���Ե�óԵĲ����ɣ����õ��ĳ���Ŷ~");
					display.getText();
				}
				if(result>=18.5&&result<24){
					
					display.setText("���BMIֵΪ"+result+"�����ڽ�������Ŷ����������Ŷ~");
					display.getText();
				}
				if(result>=24&&result<28){
					display.setText("���BMIֵΪ"+result+"����ѽ��������Ŷ��ע���������Ŷ��ʹ�Լ���һ�����������壬���ͣ������㣡");
					display.getText();
				}
				if(result>=28){
					display.setText("���BMIֵΪ"+result+"�������ڷ���״̬Ŷ��һ��Ҫע����������ˣ�ӵ��һ���������������ҪŶ~");
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
