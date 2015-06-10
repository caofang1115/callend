package com.jeden.tel.main;

import java.util.HashMap;

public class MainListener 
{
	// ����
	private static MainListener instance = new MainListener();
	
	// ������Fragment�ļ���
	private HashMap<String, BaseFragment> map = new HashMap<String, BaseFragment>();
	
	private MainListener()
	{
		
	}
	
	public static MainListener getInstance()
	{
		return instance;
	}

	/**
	 * ע��Fragment�ļ���
	 * 
	 * @param key
	 * 			����Fragment�ı�ʾ
	 * @param bf
	 * 			Fragmentʵ��
	 */
	public void registerChangeListener(String key, BaseFragment bf)
	{
		map.put(key, bf);
	}
	
	/**
	 * ���Fragment�ļ���
	 * 
	 * @param key
	 * 			Fragment�ı�ʾ
	 */
	public void unRegisterChangeListener(String key)
	{
		map.remove(key);
	}
	
	/**
	 * ˢ��Fragment�е�listview����ʾ����
	 * 
	 * @param key
	 * 			Fragment�ı�ʾ
	 */
	public void refreshFragmentList(String key)
	{
		BaseFragment bf = map.get(key);
		if(bf != null)
		{
			bf.refreshListView();
		}
	}
}
