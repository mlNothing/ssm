package lml.domain;

import lml.utils.dateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable {
    private String id;//无意义
    private String orderNum;//订单编号
    //这样前端页面传递过来的String类型的时间  '2016-11-11 11:11:11' 会转换为 Date 类型
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date orderTime;//下单时间
    private String oderDesc;
    private String orderTimeStr;
    private int orderStatus;//订单状态 0 未支付 1已支付
    private String orderStatusStr;
    private int peopleCount;//出行人数
    private Product product;//产品
    private List<Traveller> travellers;//游客
    private Member member;//成员
    private Integer payType;//支付方式 0 支付宝 1 微信 2 其他
    private String payTypeStr;

    public String getOderDesc() {
        return oderDesc;
    }

    public void setOderDesc(String oderDesc) {
        this.oderDesc = oderDesc;
    }

    public String getOrderStatusStr() {
        if (orderStatus==0)
        {
            orderStatusStr="未支付";
        }
        if (orderStatus==1){
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    private String orderDesc;//订单描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime!=null){
        orderTimeStr = dateUtils.Date2String(orderTime, "yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType!=null){
            if (payType==0){
                payTypeStr="支付宝";
            }
            if (payType==1){
                payTypeStr="微信";
            } if (payType==2){
                payTypeStr="其他";
            }

        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
