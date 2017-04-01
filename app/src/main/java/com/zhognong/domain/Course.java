package com.zhognong.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */

public class Course {
    private String dir_type;
    private List<CourseInfo> sub_node;

    public String getDir_type() {
        return dir_type;
    }

    public void setDir_type(String dir_type) {
        this.dir_type = dir_type;
    }

    public List<CourseInfo> getSub_node() {
        return sub_node;
    }

    public void setSub_node(List<CourseInfo> sub_node) {
        this.sub_node = sub_node;
    }
    public static class CourseInfo{
        private String node_name;
        private String dir_type;
        private List<CourseInfo> sub_node;
        private boolean isroot;

        public boolean isroot() {
            return isroot;
        }

        public void setIsroot(boolean isroot) {
            this.isroot = isroot;
        }

        public String getNode_name() {
            return node_name;
        }

        public void setNode_name(String node_name) {
            this.node_name = node_name;
        }

        public String getDir_type() {
            return dir_type;
        }

        public void setDir_type(String dir_type) {
            this.dir_type = dir_type;
        }

        public List<CourseInfo> getSub_node() {
            return sub_node;
        }

        public void setSub_node(List<CourseInfo> sub_node) {
            this.sub_node = sub_node;
        }
    }
}
