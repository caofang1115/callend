package com.jeden.tel.main;

import com.jeden.tel.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public abstract class BaseFragment extends Fragment 
{
	// Fragment�����е��б�
	public ListView listview = null;
	
	// �б��������
	public ListViewAdapter adapter = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		View rootView = inflater.inflate(R.layout.fragment_listview, container, false);
		initView(rootView);
		
		MainListener.getInstance().registerChangeListener(getFragmentFlag(), this);
		
		return rootView;
	}
	
	@Override
	public void onDestroyView() 
	{
		MainListener.getInstance().unRegisterChangeListener(getFragmentFlag());
		super.onDestroyView();
	}

	/**
	 * ��ʼ�������Ϣ
	 * 
	 * @param rootView
	 * 			Fragment�ĸ���ͼ
	 */
	public abstract void initView(View rootView);
	
	/**
	 * ˢ��listview��ͼ�ϵ�����
	 */
	public void refreshListView()
	{
		if(adapter == null)
		{
			return;
		}
		
		adapter.notifyDataSetChanged();
	}
	
	/**
	 * �ײ���ť����¼�����
	 */
	public abstract void bottomBtnClick();
	
	/**
	 * ��ȡ�����ʾ
	 * 
	 * @return ��־
	 */
	public abstract String getFragmentFlag();
}
