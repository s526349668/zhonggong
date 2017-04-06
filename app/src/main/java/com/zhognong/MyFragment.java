package com.zhognong;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhognong.adapter.SpaceItemDecoration;
import com.zhognong.adapter.TreeAdapter;
import com.zhognong.domain.Course;
import com.zhognong.utils.Constant;
import com.zhognong.utils.JsonDemo;
import com.zhognong.utils.ParseUilts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lt on 2015/12/14.
 */
public class MyFragment extends Fragment {
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    getNodeName((List<Course.CourseInfo>) msg.obj);
                    treeAdapter.notifyDataSetChanged();
            }
            super.handleMessage(msg);
        }
    };
    private String mText;
    private TreeAdapter treeAdapter;
    private int clickposition=-1;
    private List<Course.CourseInfo> courseInfos=new ArrayList();
    private List<String> pathList=new ArrayList<String>();
    private String path;
    private List<Course.CourseInfo> childList=new ArrayList<Course.CourseInfo>();
    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if(getArguments()!=null){
            mText = getArguments().getString("text");
        }
    }
    public void getNodeName(List<Course.CourseInfo> curriculum){
        for(Course.CourseInfo courseInfo : curriculum){
                if(courseInfo.getDir_type().equals(Constant.dir_type)){
                    courseInfo.setIsroot(true);
                    courseInfos.add(courseInfo);
                }else {
                    if(!TextUtils.isEmpty(courseInfo.getNode_name())){
                        if(!TextUtils.isEmpty(path)){
                            path=path+courseInfo.getNode_name()+">";
                        }else{
                            path=courseInfo.getNode_name()+">";
                        }
                    }
                    if(courseInfo.getSub_node()!=null){
                        getNodeName(courseInfo.getSub_node());
                    }
                }
        }
    }
    public void getchildList(Course.CourseInfo courseInfos, int level){
        if(courseInfos.getSub_node()!=null){
            for(Course.CourseInfo courseInfo:courseInfos.getSub_node()){
                    courseInfo.setLevel(level);
                    childList.add(courseInfo);
                    if(courseInfo.getSub_node()!=null){
                        getchildList(courseInfo,courseInfo.getLevel()+1);
                    }
            }
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //initData();
        View view=inflater.inflate(R.layout.fragment_course,null);
        RecyclerView rv_course= (RecyclerView) view.findViewById(R.id.rv_course);
        rv_course.setLayoutManager(new LinearLayoutManager(getActivity()));
        treeAdapter=new TreeAdapter(getActivity(), courseInfos, R.layout.item_course,
                new int[]{R.id.parent_name, R.id.child_name},pathList);
        rv_course.setAdapter(treeAdapter);
        rv_course.addItemDecoration(new SpaceItemDecoration(1,1));
        ParseUilts.parseJson(handler, JsonDemo.JSONDEMO);
        treeAdapter.setOnItemClickLitener(new TreeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Course.CourseInfo parent=courseInfos.get(position);
                if (courseInfos.get(position).isroot()){//判断是否为父
                    if ((position + 1) == courseInfos.size()) {//判断是否为最后一个元素
                        treeAdapter.deleteAllChild(clickposition +1, childList.size());
                        int lastsize= position -childList.size();
                        childList.clear();
                        getchildList(parent,2);
                        treeAdapter.addAllChild(childList, lastsize+1);
                        clickposition=lastsize;
                    } else {
                        if (courseInfos.get(position + 1).isroot()) {//如果是父则表示为折叠状态需要添加儿子
                            if(clickposition!=-1){
                                int lastsize= position -childList.size();
                                treeAdapter.deleteAllChild(clickposition +1, childList.size());
                                childList.clear();
                                getchildList(parent,2);
                                if(clickposition>position){
                                    treeAdapter.addAllChild(childList, position + 1);
                                    clickposition=position;
                                }else{
                                    treeAdapter.addAllChild(childList,lastsize+1);
                                    clickposition=lastsize;
                                }
                            }else{
                                getchildList(parent,2);
                                clickposition=position;
                                treeAdapter.addAllChild(childList, position + 1);
                            }
                          //  treeAdapter.addAllChild(parent.getChildren(), position + 1);
                        } else if (!courseInfos.get(position + 1).isroot()) {//如果是儿子则表示为展开状态需要删除儿子
                            treeAdapter.deleteAllChild(position + 1, childList.size());
                            clickposition=-1;
                            childList.clear();
                        }
                    }
                }else {//是儿子你想干啥就干啥吧
                   // ParentEntity.ChildEntity child = (ParentEntity.ChildEntity) parentEntities.get(position);
                    //Toast.makeText(getApplicationContext(), child.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
