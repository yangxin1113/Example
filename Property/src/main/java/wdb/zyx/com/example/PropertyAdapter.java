package wdb.zyx.com.example;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zyx on 2016/3/1.
 */
public class PropertyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String,Object>> mList;
    private ArrayList<HashMap<String,TextView[]>> mViewList;
    private Drawable drawableNormal ;
    private Drawable drawablePressed;
    private Handler mHandler;

    //用于保存用户的属性集合
    private HashMap<String,String> selectProMap=new HashMap<String, String>();
    /**
     * 返回选中的属性
     * @return
     */
    public HashMap<String, String> getSelectProMap() {
        return selectProMap;
    }


    public void setSelectProMap(HashMap<String, String> selectProMap) {
        this.selectProMap = selectProMap;
    }




    public PropertyAdapter(Handler handler, Context context, ArrayList<HashMap<String, Object>> list){
        super();
        this.mHandler=handler;
        this.mContext=context;
        this.mList=list;
        mViewList=new ArrayList<HashMap<String,TextView[]>>();
       // drawableNormal=mContext.getResources().getDrawable(R.drawable.tv_property_label);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            // 获取list_item布局文件的视图
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.lv_property_item, null,true);
            holder = new ViewHolder();

            // 获取控件对象
            holder.tvPropName= (TextView) convertView
                    .findViewById(R.id.tv_property_name);
            //holder.llPropContents=(LinearLayout)convertView.findViewById(R.id.ll_property_content);
            //holder.tlPropContents=(TableLayout)convertView.findViewById(R.id.ll_property_content);
            // 设置控件集到convertView
            holder.vgPropContents= (MyViewGroup) convertView.findViewById(R.id.myviewgroup);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (this.mList != null) {
            //HashMap<String,TextView[]> mapView=new HashMap<String, TextView[]>();
            ArrayList<String> lables = (ArrayList<String>) this.mList.get(position).get("lable");
            String type = (String) this.mList.get(position).get(
                    "type");
            holder.tvPropName.setText(type);//规格名称
            holder.tvPropName.setTextColor(Color.BLACK);
            //动态加载标签
            //判断布局中的子控件是否为0，如果不为0，就不添加了，防止ListView滚动时重复添加
            if(holder.vgPropContents.getChildCount()==0){
                TextView[]  textViews = new TextView[lables.size()];
                //设置每个标签的文本和布局
                //TableRow tr=new TableRow(mContext);

                for (int i = 0; i < lables.size(); i++) {
                    TextView textView = new TextView(mContext);
                    textView.setGravity(17);
                    textView.setPadding(100, 200,100, 15);
                    textViews[i] = textView;
                    textViews[i].setBackgroundResource(R.mipmap.state_true);
                    textViews[i].setText(lables.get(i).toString());
                    textViews[i].setTag(i);

                    textViews[i].setTextColor(Color.parseColor("#EE5500"));
                    //tr.addView(textViews[i]);
                    // holder.llPropContents.addView(textViews[i]);
                    holder.vgPropContents.addView(textViews[i]);
                }
                //holder.tlPropContents.addView(tr);
                //绑定标签的Click事件
                for(int j=0;j<textViews.length;j++){
                    textViews[j].setTag(textViews);
                    textViews[j].setOnClickListener(new LableClickListener(type));
                }

                //把控件存起来
//               mapView.put(type, textViews);
//               mViewList.add(mapView);
            }
            /**判断之前是否已选中标签*/
            if(selectProMap.get(type)!=null){
                for(int h=0;h<holder.vgPropContents.getChildCount();h++){
                    TextView v=(TextView) holder.vgPropContents.getChildAt(h);
                    if(selectProMap.get(type).equals(v.getText().toString())){
                        //v.setBackgroundColor(Color.parseColor("#EE5500"));
                        v.setTextColor(Color.parseColor("#FFFFFF"));
                        selectProMap.put(type, v.getText().toString());
                    }
                }
            }



        }
        return convertView;
    }
    /*定义item对象*/
    public class ViewHolder {

        TextView tvPropName;
        LinearLayout llPropContents;
        MyViewGroup vgPropContents;
        TableLayout tlPropContents;
    }
    class LableClickListener implements View.OnClickListener {
        private String type;
        public LableClickListener(String type){

            this.type=type;
        }
        @Override
        public void onClick(View v) {
            TextView[] textViews=(TextView[])v.getTag();
            TextView tv=(TextView)v;
            for(int i=0;i<textViews.length;i++){
                //让点击的标签背景变成橙色，字体颜色变为白色
                if(tv.equals(textViews[i])){
                    //textViews[i].setBackgroundColor(Color.parseColor("#EE5500"));
                    textViews[i].setTextColor(Color.parseColor("#000000"));
                    selectProMap.put(type, textViews[i].getText().toString());
                    Log.i("zyxaaaa", tv.getText().toString());
                }else{
                    //其他标签背景变成白色，字体颜色为黑色
                    //textViews[i].setBackgroundDrawable(drawableNormal);
                    //textViews[i].setBackgroundResource(R.mipmap.state_true);
                    textViews[i].setTextColor(Color.parseColor("#000000"));
                }
            }

        }

    }
}
