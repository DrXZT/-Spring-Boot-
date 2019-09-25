package com.ptg.formwork.constans;

/**
 * className: Constants
 * description: TODO
 *
 * @author luofeng
 * @version 1.0
 * @date 2018/11/6 7:47 PM
 */
public final class Constants {
    //论坛状态  过期0，正常1，精品5，置顶6,公众号推文7
    //团队成员状态 审核 0 队员 1  管理员 2  队长 3
    //编码方式
    public final String CHARACTER_ENCODING = "UTF-8";
    //本地服务器文件URL
    public final static String IMG_URL = "";
    //public final static String IMG_URL = "http://192.168.3.74:8080/img/";
    //服务器文件存储地址
    public final static String SERVER_DATA_URL="/usr/local/Data";
    //public final static String SERVER_DATA_URL= Paths.get("D:", "IdeaProjects","file").toString();
    //服务器映射文件地址

    public final static String APP_ID = "";
    public final static String APP_SECRET = "";
    public final static String CODE_URL = "https://api.weixin.qq.com/sns/jscode2session";
    //百度接口信息
    public final static String BAIDU_APPID = "15199730";
    public final static String BAIDU_API_KEY = "eMo6rnLqqaBvg6jG8dpTHcAd";
    public final static String BAIDU_SECRET_KEY = "GLM4NlITSbL4hvD3eeZMdy2nf2SLNQAm";

    //token验证失败
    public final static String ERROR_TOKEN = "token验证失败";
    //点赞
    public final static String PRAISE_SUCCESS = "点赞成功";
    public final static String PRAISE_CANCLE = "取消点赞";
    //创建成功
    public final static String CREADE_GROUP = "创建成功";
    //申请 加入团队
    public final static String JOIN_GROUP = "团队申请成功";
    public final static String HAVE_GROUP = "请勿重复添加团队";
    //踢出成员成功
    public final static String REMOVE_MEMBER_SUCCESS = "已成功踢出团队";
    public final static String NO_ROOT = "您没有权限进行此操作";
    //审核通过
    public final static String REMOVE_MEMBER_VERIFY = "审核通过";
    //修改成功
    public final static String UPDATE_MEMBER_MESSAGE = "修改成功";
    //上传成功
    public final static String UPDATA_SUCCESS = "发布成功";
    //反馈成功
    public final static String FEEDBACK_SUCCESS = "反馈成功";
    //删除成功
    public final static String DELETR_SUCCESS = "删除成功";
    //用户信息不全
    public final static String USER_INFO_LACK = "该用户信息不完全，请提醒该用户补全个人信息（姓名、电话、学历、履历）";
    //添加成功
    public final static String ADD_SUCCESS = "添加成功";
    //报名成功
    public final static String SIGNUP_SICCESS = "报名成功";
    //报名异常
    public final static String SIFNUP_EXCEPTION = "信息填写不正确";
    //date格式
    public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    //date格式2
    public final static String DATE_FORMAT2 = "yyyy-MM-dd HH:mm:ss";
    //date格式3
    public final static String DATE_FORMAT3 = "yyyy-MM-dd";
    //date格式4
    public final static String DATE_FORMAT4 = "yyyy年MM月dd日 HH:mm:ss";
    //date传入格式错误
    public final static String DATE_ERR = "date传入格式错误";
    //退出团队成功
    public final static String QUIT_SUCCESS = "退出成功";
    //解散成功
    public final static String DISSOLUTION_SUCCESS = "解散成功";
    //投票失败
    public final static String VOTE_ERR = "请勿重复投票";
    //投票成功
    public final static String VOTE_SUCCESS = "投票成功";
}
