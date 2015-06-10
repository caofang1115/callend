package com.jeden.tel.tools;

import com.jeden.tel.main.MainActivity;

import android.content.Context;
import android.content.SharedPreferences;

public class DataBean 
{
	// ��������Ϣ
	private String[] black = null;
	
	// �������ؼ�¼
	private String[] telhistory = null;
	
	// �������ؼ�¼
	private String[] msghistory = null;
	
	// ��������Ϣ
	private String tempBlack = null;
	
	// �������ؼ�¼
	private String tempTel = null;
	
	// �������ؼ�¼
	private String tempMsg = null;
	
	// ����
	private static DataBean instance = new DataBean();
	
	// ������
	private Context context = null;
	
	private DataBean()
	{
	}
	
	public static DataBean getInstance()
	{
		return instance;
	}
	
	/**
	 * ��ʼ��������Ϣ
	 * 
	 * @param context
	 * 			�����Ļ���
	 */
	public void init(Context context)
	{
		this.context = context;
		
		SharedPreferences sp = context.getSharedPreferences(Config.SHARE_NAME, 
				MainActivity.MODE_PRIVATE);
		
		tempBlack = sp.getString(Config.SHARE_BLACK_NAME, "");
		black = tempBlack.split(";");
		
		tempTel = sp.getString(Config.SHARE_TEL_NAME, "");
		telhistory = tempTel.split(";");
		
		tempMsg = sp.getString(Config.SHARE_MSG_NAME, "");
		msghistory = tempMsg.split(";");
	}
	
	/**
	 * ��ȡ���������ַ�����
	 * 
	 * @return �����ĺ�������Ϣ
	 */
	public String getBlackString()
	{
		return tempBlack;
	}
	
	/**
	 * ��ȡ���ص��ĵ绰��Ϣ���ַ�����
	 * 
	 * @return �����ĵ绰��¼��Ϣ
	 */
	public String getTelString()
	{
		return tempTel;
	}
	
	/**
	 * ��ȡ���ص��Ķ�����Ϣ���ַ�����
	 * 
	 * @return �����Ķ�����Ϣ
	 */
	public String getMsgString()
	{
		return tempMsg;
	}
	
	/**
	 * ��ȡ�����������飩
	 * 
	 * @return �����ĺ�������Ϣ
	 */
	public String[] getBlackList()
	{
		return black;
	}
	
	/**
	 * ��ȡ���ص��ĵ绰��Ϣ�����飩
	 * 
	 * @return �����ĵ绰��¼��Ϣ
	 */
	public String[] getTelHistory()
	{
		return telhistory;
	}
	
	/**
	 * ��ȡ���ص��Ķ�����Ϣ�����飩
	 * 
	 * @return �����Ķ�����Ϣ
	 */
	public String[] getMsgHistory()
	{
		return msghistory;
	}
	
	/**
	 * ��ȡ�������е�һ��
	 * 
	 * @param index
	 * 			�����е�λ��
	 * @return һ������������Ϣ
	 */
	public String getBlackItem(int index)
	{
		return black[index];
	}
	
	/**
	 * ��ȡ������Ϣ�е�һ��
	 * 
	 * @param index
	 * 			�����е�λ��
	 * @return	һ���������Ϣ
	 */
	public String getTelItem(int index)
	{
		return telhistory[index];
	}
	
	/**
	 * ��ȡ������Ϣ�е�һ��
	 * 
	 * @param index
	 * 			�����е�λ��
	 * @return һ��������Ϣ
	 */
	public String getMsgItem(int index)
	{
		return msghistory[index];
	}
	
	/**
	 * ��ӵ�������
	 * 
	 * @param item
	 * 			һ����������Ϣ
	 */
	public void addBlackItem(String item)
	{
		if(item == null || item.indexOf(",") < 0 || tempBlack.contains(item))
		{
			return;
		}
		
		if(!item.contains(";"))
		{
			item += ";";
		}
		
		tempBlack += item;
		black = tempBlack.split(";");
		SharedPreferences sp = context.getSharedPreferences(Config.SHARE_NAME, 
				MainActivity.MODE_PRIVATE);
		sp.edit().putString(Config.SHARE_BLACK_NAME, tempBlack).commit();
	}
	
	/**
	 * ��ӵ�������Ϣ
	 * 
	 * @param item
	 * 			һ��������Ϣ
	 */
	public void addTelItem(String item)
	{
		if(item == null || item.indexOf(",") < 0)
		{
			return;
		}
		
		if(!item.contains(";"))
		{
			item += ";";
		}
		
		tempTel += item;
		telhistory = tempTel.split(";");
		SharedPreferences sp = context.getSharedPreferences(Config.SHARE_NAME, 
				MainActivity.MODE_PRIVATE);
		sp.edit().putString(Config.SHARE_TEL_NAME, tempTel).commit();
	}
	
	/**
	 * ��ӵ�������Ϣ
	 * 
	 * @param item
	 * 			һ��������Ϣ
	 */
	public void addMsgItem(String item)
	{
		if(item == null || item.indexOf(",") < 0)
		{
			return;
		}
		
		if(!item.contains(";"))
		{
			item += ";";
		}
		
		tempMsg += item;
		msghistory = tempMsg.split(";");
		SharedPreferences sp = context.getSharedPreferences(Config.SHARE_NAME, 
				MainActivity.MODE_PRIVATE);
		sp.edit().putString(Config.SHARE_MSG_NAME, tempMsg).commit();
	}
	
	/**
	 * ɾ��һ����������Ϣ
	 * 
	 * @param index
	 * 			�������е�λ��
	 */
	public void delBlackItem(int index)
	{
		if(black.length <= index)
		{
			return;
		}
		
		String item = black[index];
		tempBlack = tempBlack.replace(item + ";", "");
		black = tempBlack.split(";");
		SharedPreferences sp = context.getSharedPreferences(Config.SHARE_NAME, 
				MainActivity.MODE_PRIVATE);
		sp.edit().putString(Config.SHARE_BLACK_NAME, tempBlack).commit();
	}
	
	/**
	 * ɾ������������Ϣ
	 */
	public void delTel()
	{
		tempTel = "";
		telhistory = tempTel.split(";");
		SharedPreferences sp = context.getSharedPreferences(Config.SHARE_NAME, 
				MainActivity.MODE_PRIVATE);
		sp.edit().putString(Config.SHARE_TEL_NAME, tempTel).commit();
	}
	
	/**
	 * ɾ�����ж�����Ϣ
	 */
	public void delMsg()
	{
		tempMsg = "";
		msghistory = tempMsg.split(";");
		SharedPreferences sp = context.getSharedPreferences(Config.SHARE_NAME, 
				MainActivity.MODE_PRIVATE);
		sp.edit().putString(Config.SHARE_MSG_NAME, tempMsg).commit();
	}
}
