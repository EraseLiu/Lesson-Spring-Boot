# Lesson-Spring-Boot
学习SpringBoot资料

```flow
st=>start: 申请售后
cond1=>condition: 图片文字审核
op1=>end: 驳回
op2=>operation: 通过:买家发货
op3=>operation: 卖家收货
cond2=>condition: 实物审核
cond3=>condition: 退货/换货
op4=>operation: 卖家发货
op5=>operation: 退款
e1=>end: 订单完成(换)
e2=>end: 订单完成(退)

st->cond1
cond1(false)->op1
cond1(true)->op2->op3->cond2
cond2(false)->op1
cond2(true)->cond3
cond3(false)->op4->e1
cond3(true)->op5->e2
```
