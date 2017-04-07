package com.zhognong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhognong.R;
import com.zhognong.domain.Course;
import com.zhognong.utils.Uitils;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.MyViewHolder>{
    Context context;
    List<Course.CourseInfo> list;
    List<String> pathlist;
    Integer layout;
    int[] to;

    public TreeAdapter (Context context, List<Course.CourseInfo> list, Integer layout, int[] to,List<String> pathlist){
        this.context = context;
        this.list = list;
        this.layout = layout;
        this.to = to;
        this.pathlist=pathlist;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickLitener(OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }

    @Override
    public TreeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(layout, parent,
                false));
        return holder;
    }
    @Override
    public void onBindViewHolder(final TreeAdapter.MyViewHolder holder, int position) {
        if(list.get(position).isRoot()){
            holder.tv_path.setVisibility(View.VISIBLE);
            holder.parent_name.setVisibility(View.VISIBLE);
            holder.child_name.setVisibility(View.GONE);
            holder.parent_name.setText(list.get(position).getCourse_name());
        }else {
            holder.tv_path.setVisibility(View.GONE);
            holder.parent_name.setVisibility(View.GONE);
            holder.child_name.setVisibility(View.VISIBLE);
            holder.child_name.setPadding(Uitils.dip2px(context,list.get(position).getLevel()*10),0,0,0);
            holder.child_name.setText(list.get(position).getCourse_name());
        }
        //holder.tv_path.setText(pathlist.get(position));
        holder.parent_name.setText(list.get(position).getCourse_name());
//        Course.CourseInfo courseInfo=list.get(position);
//        if (list.get(position).getDir_type().equals(Constant.dir_type)){
//            setdir_type(holder,courseInfo.getNode_name());
//        }else {
//            if(courseInfo.getSub_node()!=null){
//                String nodename=getNodeName(courseInfo);
//                System.out.println(nodename);
//                if(!TextUtils.isEmpty(nodename)){
//                    setdir_type(holder,nodename);
//                }
//            }
//            holder.parent_name.setVisibility(View.GONE);
//            holder.child_name.setVisibility(View.VISIBLE);
//            ParentEntity.ChildEntity child = (ParentEntity.ChildEntity) list.get(position);
//            holder.child_name.setText(child.getName());
//        }

        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView parent_name;
        private TextView child_name;
        private TextView tv_path;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent_name = (TextView) itemView.findViewById(to[0]);
            child_name = (TextView) itemView.findViewById(to[1]);
            tv_path= (TextView) itemView.findViewById(R.id.tv_path);
        }
    }

    /**
     * 添加所有child
     * @param lists
     * @param position
     */

    public void addAllChild(List<Course.CourseInfo> lists, int position) {
        list.addAll(position, lists);
        notifyItemRangeInserted(position, lists.size());
    }

    /**
     * 删除所有child
     * @param position
     * @param itemnum
     */
    public void deleteAllChild(int position, int itemnum) {
        for (int i = 0; i < itemnum; i++) {
            list.remove(position);
        }
        notifyItemRangeRemoved(position, itemnum);
    }
}
