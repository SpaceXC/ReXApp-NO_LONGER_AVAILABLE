package cn.rexwear.rexapp.javabeans;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ForumBean {

    @SerializedName("forum")
    public ForumDTO forum;
    @SerializedName("threads")
    public List<ThreadsDTO> threads;
    @SerializedName("pagination")
    public PaginationDTO pagination;
    @SerializedName("sticky")
    public List<?> sticky;

    public static ForumBean objectFromData(String str) {

        return new Gson().fromJson(str, ForumBean.class);
    }

    public static ForumBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ForumBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<ForumBean> arrayForumBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ForumBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<ForumBean> arrayForumBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ForumBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public static class ForumDTO {
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

        public static ForumDTO objectFromData(String str) {

            return new Gson().fromJson(str, ForumDTO.class);
        }

        public static ForumDTO objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ForumDTO.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ForumDTO> arrayForumDTOFromData(String str) {

            Type listType = new TypeToken<ArrayList<ForumDTO>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ForumDTO> arrayForumDTOFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ForumDTO>>() {
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
            @SerializedName("custom_fields")
            public List<?> customFields;
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
            @SerializedName("prefixes")
            public List<?> prefixes;
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

    public static class PaginationDTO {
        @SerializedName("current_page")
        public Integer currentPage;
        @SerializedName("last_page")
        public Integer lastPage;
        @SerializedName("per_page")
        public Integer perPage;
        @SerializedName("shown")
        public Integer shown;
        @SerializedName("total")
        public Integer total;

        public static PaginationDTO objectFromData(String str) {

            return new Gson().fromJson(str, PaginationDTO.class);
        }

        public static PaginationDTO objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), PaginationDTO.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<PaginationDTO> arrayPaginationDTOFromData(String str) {

            Type listType = new TypeToken<ArrayList<PaginationDTO>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<PaginationDTO> arrayPaginationDTOFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<PaginationDTO>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }
    }

    public static class ThreadsDTO {
        @SerializedName("can_edit")
        public Boolean canEdit;
        @SerializedName("can_edit_tags")
        public Boolean canEditTags;
        @SerializedName("can_hard_delete")
        public Boolean canHardDelete;
        @SerializedName("can_reply")
        public Boolean canReply;
        @SerializedName("can_soft_delete")
        public Boolean canSoftDelete;
        @SerializedName("can_view_attachments")
        public Boolean canViewAttachments;
        @SerializedName("custom_fields")
        public CustomFieldsDTO customFields;
        @SerializedName("discussion_open")
        public Boolean discussionOpen;
        @SerializedName("discussion_state")
        public String discussionState;
        @SerializedName("discussion_type")
        public String discussionType;
        @SerializedName("first_post_id")
        public Integer firstPostId;
        @SerializedName("first_post_reaction_score")
        public Integer firstPostReactionScore;
        @SerializedName("highlighted_post_ids")
        public List<?> highlightedPostIds;
        @SerializedName("is_first_post_pinned")
        public Boolean isFirstPostPinned;
        @SerializedName("is_unread")
        public Boolean isUnread;
        @SerializedName("is_watching")
        public Boolean isWatching;
        @SerializedName("last_post_date")
        public Integer lastPostDate;
        @SerializedName("last_post_id")
        public Integer lastPostId;
        @SerializedName("last_post_user_id")
        public Integer lastPostUserId;
        @SerializedName("last_post_username")
        public String lastPostUsername;
        @SerializedName("node_id")
        public Integer nodeId;
        @SerializedName("post_date")
        public Integer postDate;
        @SerializedName("prefix_id")
        public Integer prefixId;
        @SerializedName("reply_count")
        public Integer replyCount;
        @SerializedName("sticky")
        public Boolean sticky;
        @SerializedName("tags")
        public List<?> tags;
        @SerializedName("thread_id")
        public Integer threadId;
        @SerializedName("title")
        public String title;
        @SerializedName("User")
        public UserDTO user;
        @SerializedName("user_id")
        public Integer userId;
        @SerializedName("username")
        public String username;
        @SerializedName("view_count")
        public Integer viewCount;
        @SerializedName("view_url")
        public String viewUrl;
        @SerializedName("visitor_post_count")
        public Integer visitorPostCount;

        public static ThreadsDTO objectFromData(String str) {

            return new Gson().fromJson(str, ThreadsDTO.class);
        }

        public static ThreadsDTO objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ThreadsDTO.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ThreadsDTO> arrayThreadsDTOFromData(String str) {

            Type listType = new TypeToken<ArrayList<ThreadsDTO>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ThreadsDTO> arrayThreadsDTOFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ThreadsDTO>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public static class CustomFieldsDTO {
            public static CustomFieldsDTO objectFromData(String str) {

                return new Gson().fromJson(str, CustomFieldsDTO.class);
            }

            public static CustomFieldsDTO objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), CustomFieldsDTO.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<CustomFieldsDTO> arrayCustomFieldsDTOFromData(String str) {

                Type listType = new TypeToken<ArrayList<CustomFieldsDTO>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<CustomFieldsDTO> arrayCustomFieldsDTOFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<CustomFieldsDTO>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }
        }

        public static class UserDTO {
            @SerializedName("activity_visible")
            public Boolean activityVisible;
            @SerializedName("avatar_urls")
            public AvatarUrlsDTO avatarUrls;
            @SerializedName("can_ban")
            public Boolean canBan;
            @SerializedName("can_converse")
            public Boolean canConverse;
            @SerializedName("can_edit")
            public Boolean canEdit;
            @SerializedName("can_follow")
            public Boolean canFollow;
            @SerializedName("can_ignore")
            public Boolean canIgnore;
            @SerializedName("can_post_profile")
            public Boolean canPostProfile;
            @SerializedName("can_view_profile")
            public Boolean canViewProfile;
            @SerializedName("can_view_profile_posts")
            public Boolean canViewProfilePosts;
            @SerializedName("can_warn")
            public Boolean canWarn;
            @SerializedName("custom_fields")
            public CustomFieldsDTO customFields;
            @SerializedName("custom_title")
            public String customTitle;
            @SerializedName("dob")
            public DobDTO dob;
            @SerializedName("is_admin")
            public Boolean isAdmin;
            @SerializedName("is_banned")
            public Boolean isBanned;
            @SerializedName("is_discouraged")
            public Boolean isDiscouraged;
            @SerializedName("is_followed")
            public Boolean isFollowed;
            @SerializedName("is_ignored")
            public Boolean isIgnored;
            @SerializedName("is_moderator")
            public Boolean isModerator;
            @SerializedName("is_staff")
            public Boolean isStaff;
            @SerializedName("is_super_admin")
            public Boolean isSuperAdmin;
            @SerializedName("last_activity")
            public Integer lastActivity;
            @SerializedName("location")
            public String location;
            @SerializedName("message_count")
            public Integer messageCount;
            @SerializedName("profile_banner_urls")
            public ProfileBannerUrlsDTO profileBannerUrls;
            @SerializedName("question_solution_count")
            public Integer questionSolutionCount;
            @SerializedName("reaction_score")
            public Integer reactionScore;
            @SerializedName("register_date")
            public Integer registerDate;
            @SerializedName("secondary_group_ids")
            public List<?> secondaryGroupIds;
            @SerializedName("signature")
            public String signature;
            @SerializedName("trophy_points")
            public Integer trophyPoints;
            @SerializedName("user_group_id")
            public Integer userGroupId;
            @SerializedName("user_id")
            public Integer userId;
            @SerializedName("user_state")
            public String userState;
            @SerializedName("user_title")
            public String userTitle;
            @SerializedName("username")
            public String username;
            @SerializedName("view_url")
            public String viewUrl;
            @SerializedName("visible")
            public Boolean visible;
            @SerializedName("vote_score")
            public Integer voteScore;
            @SerializedName("warning_points")
            public Integer warningPoints;
            @SerializedName("website")
            public String website;

            public static UserDTO objectFromData(String str) {

                return new Gson().fromJson(str, UserDTO.class);
            }

            public static UserDTO objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), UserDTO.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<UserDTO> arrayUserDTOFromData(String str) {

                Type listType = new TypeToken<ArrayList<UserDTO>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<UserDTO> arrayUserDTOFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<UserDTO>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public static class AvatarUrlsDTO {
                public static AvatarUrlsDTO objectFromData(String str) {

                    return new Gson().fromJson(str, AvatarUrlsDTO.class);
                }

                public static AvatarUrlsDTO objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), AvatarUrlsDTO.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<AvatarUrlsDTO> arrayAvatarUrlsDTOFromData(String str) {

                    Type listType = new TypeToken<ArrayList<AvatarUrlsDTO>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<AvatarUrlsDTO> arrayAvatarUrlsDTOFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<AvatarUrlsDTO>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }
            }

            public static class CustomFieldsDTO {
                public static CustomFieldsDTO objectFromData(String str) {

                    return new Gson().fromJson(str, CustomFieldsDTO.class);
                }

                public static CustomFieldsDTO objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), CustomFieldsDTO.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<CustomFieldsDTO> arrayCustomFieldsDTOFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CustomFieldsDTO>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<CustomFieldsDTO> arrayCustomFieldsDTOFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<CustomFieldsDTO>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }
            }

            public static class DobDTO {
                @SerializedName("year")
                public Object year;
                @SerializedName("month")
                public Integer month;
                @SerializedName("day")
                public Integer day;

                public static DobDTO objectFromData(String str) {

                    return new Gson().fromJson(str, DobDTO.class);
                }

                public static DobDTO objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), DobDTO.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<DobDTO> arrayDobDTOFromData(String str) {

                    Type listType = new TypeToken<ArrayList<DobDTO>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<DobDTO> arrayDobDTOFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<DobDTO>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }
            }

            public static class ProfileBannerUrlsDTO {
                @SerializedName("l")
                public String l;
                @SerializedName("m")
                public String m;

                public static ProfileBannerUrlsDTO objectFromData(String str) {

                    return new Gson().fromJson(str, ProfileBannerUrlsDTO.class);
                }

                public static ProfileBannerUrlsDTO objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ProfileBannerUrlsDTO.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<ProfileBannerUrlsDTO> arrayProfileBannerUrlsDTOFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ProfileBannerUrlsDTO>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<ProfileBannerUrlsDTO> arrayProfileBannerUrlsDTOFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<ProfileBannerUrlsDTO>>() {
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
