	
  3 年前的项目，今天把博客贴上来，便于初学者学习。	
	BMI指数（身体质量指数，简称体质指数，又称体重指数，英文为Body Mass Index，简称BMI）是用体重公斤数除以身高米数平方得出的数字。
## BMI指数计算
	体质指数（BMI）=体重（kg）÷身高^2（m）

___

	
	

|BMI值|身体状况|
|---| ---|
|bmi<18.5 |过轻|
|18.5<=bmi<24|健康体重|
|24<=bmi<28|超重|
|bmi>=28|肥胖|

 好了，了解了BMI之后开始正式写代码。
其实做这个项目大体就需要两步，第一步是编写界面，第二步是按钮的点击事件。
## 首先先建一个BMI的android项目。
　先来几张app截图
![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL2ltZy5ibG9nLmNzZG4ubmV0LzIwMTYwNzIwMTAwNTA4MzA4)
![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL2ltZy5ibG9nLmNzZG4ubmV0LzIwMTYwNzIwMTA0NDUyOTg4)


现在开始我们的项目之旅~
## 编写界面

首先先要写这个界面，我们可以采用线性布局 ，垂直分布，其中身高和体重那里又需要一个线性布局，要把三个控件水平排放，好，直接上代码。
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 android:orientation="vertical"
 tools:context="com.example.mjy_bmi.MainActivity" >

 <TextView
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_centerHorizontal="true"
 android:layout_gravity="center_horizontal"
 android:layout_marginTop="20dp"
 android:text="@string/title"
 android:textColor="#ff00ff"
 android:textSize="30dp" />

 <LinearLayout
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 android:layout_marginTop="20dp" >

 <TextView
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginLeft="50dp"
 android:layout_gravity="center"
 android:layout_weight="1"
 android:text="身高:"
 android:textColor="#ffaa00"
 android:textSize="20dp" />

 <EditText
 android:id="@+id/height"
 android:layout_width="30dp"
 android:layout_height="wrap_content"
 android:layout_weight="1"
 android:layout_gravity="center"
 android:textSize="20dp" />

 <TextView
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginRight="30dp"
 android:layout_weight="1"
 android:text="m"
 android:layout_gravity="center"
 android:textColor="#ffaa00"
 android:textSize="20dp" />
 </LinearLayout>

 <LinearLayout
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 android:layout_marginTop="20dp" >

 <TextView
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginLeft="50dp"
 android:layout_gravity="center"
 android:layout_weight="1"
 android:text="体重:"
 android:textColor="#bbaa00"
 android:textSize="20dp" />

 <EditText
 android:id="@+id/weight"
 android:layout_width="30dp"
 android:layout_height="wrap_content"
 android:layout_gravity="center"
 android:layout_weight="1"
 android:textSize="20dp" />

 <TextView
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"
 android:layout_marginRight="30dp"
 android:layout_weight="1"
 android:text="kg"
 android:textColor="#bbaa00"
 android:layout_gravity="center"
 android:textSize="20dp" />
 </LinearLayout>

 <Button
 android:id="@+id/bmi"
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 android:layout_marginTop="20dp"
 android:background="#aaddaa"
 android:text="计算BMI"
 android:textColor="#ccff00" />

 <TextView 
 android:id="@+id/display"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 android:gravity="center"
 android:textColor="#00ff00"
 android:textSize="20dp"
 
 />

</LinearLayout>
```

是不是很简单，都是一些特别简单的属性，先写一个大体的界面，然后再优化一下，给他们添加颜色，修改字体等等。

## 第二步，在MainActivity中按钮的点击事件的实现

```
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
					
					display.setText("你的BMI值为"+result+",属于健康体重哦，继续保持哦~");
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


```

height,weight首先获取文本框中的值，注意他现在是字符串的形式，我们要计算的话必须把他转化成double类型。在计算之前，我们先判断身高和体重是否为串。首先了解Trim()函数，删除字符串首尾的空白（可以首尾一起，也可以指定首或尾，取决于控制参数），但会保留字符串内部作为词与词之间分隔的空格。
```
//非空判断，去掉空格
if (height.getText().toString().trim().length()==0) {
					//添加错误信息
					height.setError("请输入身高");
					return;//直接跳出当前的类
				}

```
如果不为空的话，将字符串类型转化为double类型进行计算
```
heigh_string=height.getText().toString().trim();
weight_string=weight.getText().toString().trim();
height_double=Double.valueOf(heigh_string);
weight_double=Double.valueOf(weight_string);
				
```
带入计算公式
```
result=weight_double*1.0/(height_double*height_double);
```
进行判断
```
if(result<18.5){
					
					display.setText("你的BMI值为"+result+"，属于健康体重哦，继续保持哦~");
					display.getText();
				}
```
先设置他的文本，再显示他的文本。

好了，简简单单几步，一个小小的BMI app出世了，是不是很简单呐，当然，你还可以在此基础上继续对它进行优化。
	第一次写博客，不知道写的东西好不好，以后会继续坚持下去的，每次做一个项目，直接把项目总结写到博客里面。新手上路，大牛勿喷，大家一起学习，一起进步吧！
	
	最后附上源代码
	[BMI源代码下载地址](https://github.com/mujuyan/BMI)
