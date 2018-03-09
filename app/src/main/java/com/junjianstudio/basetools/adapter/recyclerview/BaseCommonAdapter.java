package com.junjianstudio.basetools.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.junjianstudio.basetools.adapter.helper.DataHelper;
import com.junjianstudio.basetools.adapter.viewHolder.ViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * 单类型通用的Adapter
 * Created by junjianliu
 * time: 2017/6/13.
 */

public abstract  class BaseCommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements DataHelper<T>{

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected List<ViewHolder> viewHolders;

    public void add(T t,int i) {
        this.mDatas.add(i,t);
    }

    public void put(int i,T t) {
        this.mDatas.set(i,t);
    }

    public void set(int i,T t) {
        this.mDatas.set(i,t);
    }

    public void addDatas(List<T> t){
        this.mDatas = t;
        notifyDataSetChanged();
    }

    @Override
    public boolean addAll(List list) {
        boolean result = mDatas.addAll(list);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public boolean addAll(int position, List list) {
        boolean result = mDatas.addAll(position, list);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public void add(T data) {
        mDatas.add(data);
        notifyDataSetChanged();
    }

    @Override
    public void add(int position, T data) {
        mDatas.add(position,data);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public boolean contains(Object data) {
        return mDatas.contains(data);
    }

    @Override
    public T getData(int index) {
        return mDatas.get(index);
    }

    @Override
    public void modify(T oldData, T newData) {
        modify(mDatas.indexOf(oldData), newData);
    }

    @Override
    public void modify(int index, T newData) {
        mDatas.set(index, newData);
        notifyDataSetChanged();
    }

    @Override
    public boolean remove(T data) {
        boolean result = mDatas.remove(data);
        notifyDataSetChanged();
        return result;
    }

    public void add(List<T> t){
        int count  = t.size();
        for(int i = 0; i < count; i++){
            mDatas.add(t.get(i));
        }

        notifyDataSetChanged();
    }

    public T get(int pos){
        return mDatas.get(pos);
    }

    public List<T> getData(){
        return mDatas;
    }

    public void remove(int pos) {
        this.mDatas.remove(pos);
        notifyDataSetChanged();
    }

    public BaseCommonAdapter(Context mContext, int mLayoutId, List<T> mDatas) {
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
        this.mDatas = mDatas;
        this.mInflater = LayoutInflater.from(mContext);
        this.viewHolders = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder viewHolder = ViewHolder.get(mContext, parent, mLayoutId);
            viewHolders.add(viewHolder);
            return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder, mDatas.get(position), position);
    }


    public abstract void convert(ViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size() ;
    }
}
