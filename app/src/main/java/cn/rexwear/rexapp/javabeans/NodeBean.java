package cn.rexwear.rexapp.javabeans;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NodeBean {

    @SerializedName("tree_map")
    public TreeMapDTO treeMap;
    @SerializedName("nodes")
    public List<NodesDTO> nodes;

    public static NodeBean objectFromData(String str) {

        return new Gson().fromJson(str, NodeBean.class);
    }

    public static NodeBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NodeBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NodeBean> arrayNodeBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<NodeBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NodeBean> arrayNodeBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NodeBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public static class TreeMapDTO {
        @SerializedName("0")
        public List<Integer> $0;
        @SerializedName("30")
        public List<Integer> $30;
        @SerializedName("35")
        public List<Integer> $35;
        @SerializedName("33")
        public List<Integer> $33;
        @SerializedName("1")
        public List<Integer> $1;
        @SerializedName("26")
        public List<Integer> $26;
        @SerializedName("3")
        public List<Integer> $3;
        @SerializedName("7")
        public List<Integer> $7;
        @SerializedName("27")
        public List<Integer> $27;
        @SerializedName("25")
        public List<Integer> $25;
        @SerializedName("11")
        public List<Integer> $11;
        @SerializedName("15")
        public List<Integer> $15;

        public static TreeMapDTO objectFromData(String str) {

            return new Gson().fromJson(str, TreeMapDTO.class);
        }

        public static TreeMapDTO objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), TreeMapDTO.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<TreeMapDTO> arrayTreeMapDTOFromData(String str) {

            Type listType = new TypeToken<ArrayList<TreeMapDTO>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<TreeMapDTO> arrayTreeMapDTOFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TreeMapDTO>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }
    }

    public static class NodesDTO {
        @SerializedName("breadcrumbs")
        public List<?> breadcrumbs;
        @SerializedName("description")
        public String description;
        @SerializedName("display_in_list")
        public Boolean displayInList;
        @SerializedName("display_order")
        public Integer displayOrder;
        @SerializedName("node_id")
        public Integer nodeId;
        @SerializedName("node_name")
        public Object nodeName;
        @SerializedName("node_type_id")
        public String nodeTypeId;
        @SerializedName("parent_node_id")
        public Integer parentNodeId;
        @SerializedName("title")
        public String title;
        @SerializedName("type_data")
        public TypeDataDTO typeData;
        @SerializedName("view_url")
        public String viewUrl;

        public static NodesDTO objectFromData(String str) {

            return new Gson().fromJson(str, NodesDTO.class);
        }

        public static NodesDTO objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), NodesDTO.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<NodesDTO> arrayNodesDTOFromData(String str) {

            Type listType = new TypeToken<ArrayList<NodesDTO>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<NodesDTO> arrayNodesDTOFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<NodesDTO>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public static class TypeDataDTO {
            @SerializedName("allow_posting")
            public Boolean allowPosting;
            @SerializedName("can_create_thread")
            public Boolean canCreateThread;
            @SerializedName("can_upload_attachment")
            public Boolean canUploadAttachment;
            @SerializedName("discussion")
            public DiscussionDTO discussion;
            @SerializedName("discussion_count")
            public Integer discussionCount;
            @SerializedName("forum_type_id")
            public String forumTypeId;
            @SerializedName("is_unread")
            public Boolean isUnread;
            @SerializedName("last_post_date")
            public Integer lastPostDate;
            @SerializedName("last_post_id")
            public Integer lastPostId;
            @SerializedName("last_post_username")
            public String lastPostUsername;
            @SerializedName("last_thread_id")
            public Integer lastThreadId;
            @SerializedName("last_thread_prefix_id")
            public Integer lastThreadPrefixId;
            @SerializedName("last_thread_title")
            public String lastThreadTitle;
            @SerializedName("message_count")
            public Integer messageCount;
            @SerializedName("min_tags")
            public Integer minTags;
            @SerializedName("require_prefix")
            public Boolean requirePrefix;

            public static TypeDataDTO objectFromData(String str) {

                return new Gson().fromJson(str, TypeDataDTO.class);
            }

            public static TypeDataDTO objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), TypeDataDTO.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<TypeDataDTO> arrayTypeDataDTOFromData(String str) {

                Type listType = new TypeToken<ArrayList<TypeDataDTO>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<TypeDataDTO> arrayTypeDataDTOFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<TypeDataDTO>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public static class DiscussionDTO {
                @SerializedName("allowed_thread_types")
                public List<String> allowedThreadTypes;
                @SerializedName("allow_answer_voting")
                public Boolean allowAnswerVoting;
                @SerializedName("allow_answer_downvote")
                public Boolean allowAnswerDownvote;

                public static DiscussionDTO objectFromData(String str) {

                    return new Gson().fromJson(str, DiscussionDTO.class);
                }

                public static DiscussionDTO objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), DiscussionDTO.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<DiscussionDTO> arrayDiscussionDTOFromData(String str) {

                    Type listType = new TypeToken<ArrayList<DiscussionDTO>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<DiscussionDTO> arrayDiscussionDTOFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<DiscussionDTO>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }
            }
        }
    }
}
