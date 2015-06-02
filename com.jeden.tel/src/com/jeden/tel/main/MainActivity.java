package com.jeden.tel.main;

import com.jeden.tel.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener
{
	public String tels;
	public String hestory;
	
	public Button add;
	public Button delete;
	
	public Button clear;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * ��ʼ�����
     */
    public void init()
    {
    	// ������̨���񣬼�������
    	Intent sintent = new Intent(this, MainService.class);
    	sintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
    	startService(sintent);
    	
    	SharedPreferences sp = this.getSharedPreferences("jeden_tel",
    			MainActivity.MODE_PRIVATE);
    	// ��ȡ�Ѿ���ӵĵ绰
		tels = sp.getString("tels", "");
    	// ��ȡ�Ѿ����ص�������
		hestory = sp.getString("hestory", "");
		
		// ��ʾ
		EditText teledit = (EditText)findViewById(R.id.tels);
		EditText hestoryeidt = (EditText)findViewById(R.id.hestory);
		teledit.setText(tels);
		hestoryeidt.setText(hestory);
		
    	// ע������¼�
    	add = (Button) findViewById(R.id.add_tel);
    	delete = (Button) findViewById(R.id.cancel_tel);
    	clear = (Button) findViewById(R.id.clear_tel);
    	
    	add.setOnClickListener(this);
    	delete.setOnClickListener(this);
    	clear.setOnClickListener(this);
    }
    
    /**
     * ��ӻ���ɾ���绰
     * 
     * @param delete	�Ƿ���ɾ���绰
     */
    public void addOrDelete(boolean delete)
    {
    	EditText addedit = (EditText)findViewById(R.id.add_edit);
    	String teltemp = addedit.getText().toString();
    	if(delete)
    	{
    		int star = tels.indexOf(teltemp);
    		int end = star + teltemp.length()+1;
    		if(star >=0)
    		{    			
    			String one = tels.substring(0,star);
    			String two = tels.substring(end);
    			tels = one + two;
    		}
    	}
    	else
    	{
    		tels = tels + teltemp + ",\n";
    	}
    	SharedPreferences sp = this.getSharedPreferences("jeden_tel",
    			MainActivity.MODE_PRIVATE);
    	sp.edit().putString("tels", tels).commit();
    	EditText teledit = (EditText)findViewById(R.id.tels);
    	teledit.setText(tels);
    }
    
	public void onClick(View v) 
	{
		if(v == add)
		{
			addOrDelete(false);
		}
		else if(v == delete)
		{
			addOrDelete(true);
		}
		else if(v == clear)
		{
			SharedPreferences sp = this.getSharedPreferences("jeden_tel",
	    			MainActivity.MODE_PRIVATE);
			sp.edit().putString("hestory", "").commit();
			EditText hestoryedit = (EditText)findViewById(R.id.hestory);
			hestoryedit.setText("");
		}
	}
}
