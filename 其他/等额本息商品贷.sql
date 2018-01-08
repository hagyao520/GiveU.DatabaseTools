select c.contract_no as 合同号,--合同号
c.credit_model as 合同资金模式,--合同的资金模式，要和产品表绑定的金额模式对的上
f.credit_amount as f贷款金额,c.credit_amount as c贷款金额,g.goods_credit_amount as g贷款金额,--贷款金额(cs_credit)
c.init_pay c首付,g.goods_init_pay as g首付,--首付金额
c.price as c商品价格,g.goods_price as g商品价格,(c.credit_amount+c.init_pay) as s商品价格,--商品价格
c.deduct_date as c首次扣款日,e.fst_date_pay as e首次扣款日,--合同第一期的还款日--e表这个字段已经不用了
(round((f.credit_amount*p.month_ratio_eir)/100,0))+(f.insurance_fee)+(f.power_fee)+(f.treasure_box_fee) as s每月总还款额,--这里的月还款（包含保险与权益包，但是不包含手机健康与延保）
i.type_instalment as i本金1,i.value_instalment as i本金费用,f.principal as f第一期本金,--第一期本金
ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3) as s第一期本金,--SQL版的等额本息法计算出来的第一期本金
i.type_instalment as i利息2,i.value_instalment as i利息费用,f.interest as f第一期利息,--第一期利息
ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),4) as s第一期利息,--SQL版的等额本息法计算出来的第一期利息
(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))+(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))as s每月应还本息,--实际上就是第一期的本金+第一期的利息之和
(round((f.credit_amount*p.month_ratio_eir)/100,0))-((ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))+(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))) as s每月应付费用,--这里算的每月应付费用是【每月总还款额-每月应还本息】
f.cs_fee as f月服务费,(f.annuity - f.principal - f.interest - f.account_fee) as s月服务费,--月服务费用--在【申请表】上叫月服务费--就是倒退出来的数据
f.cs_fee_rate as f月服务费率,round(((f.annuity - f.principal - f.interest - f.account_fee) / f.credit_amount * 100),3) as s月服务费率,--月服务费率（倒退出来保存3位小数点）--在【申请表】上叫月服务费率--在产品部里面叫月财务费率
c.repay_style as c还款方式,--0等额本息；1前低后高；
f.annuity as f纯月还款额,c.annuity as c纯月还款额,round((f.credit_amount*p.month_ratio_eir)/100,0) as s纯月还款额,--月还款额（不包含保险，手机健康，延保）--【新合同用贷款本金*产品表eir】【正常情况下EIR比BIR要大，0息0费率下BIR比EIR大，BIR是融资利率】
c.power_flag as c权益包购买状态,--0未购买；1基础版；2升级版；9取消
f.power_fee as f权益包费用,c.power_fee as c权益包费用,--权益包费用（按月收费cs_credit.power_fee）2万以下，18元/月，2万以上，0.1%/月
e.is_ssi as e是否购买保险,--0未购买；1已购买；
g.insurance_supplier as 保险类型,--0未购买；1平安；2托普思维；3苏宁
i.type_instalment as i保险70,i.value_instalment as i保险费,--还款计划表的保险
f.insurance_fee as f保险费,c.insurance_fee as c保险费,e.insurance_fee as e保险费,FLOOR(f.credit_amount*0.008) as s保险费,--保险费用（取值cs_experience）【线上普通千九，运营商千四，线上千八】
f.discount_amount as f每月优惠金额,round((f.credit_amount*p.month_ratio_bir)/100)-round((f.credit_amount*p.month_ratio_eir)/100) s每月优惠金额,--【d.discount_value as d每月优惠金额】--每月优惠金额【贷款金额*（月还系数bir-月还系数eir）】--负数为无优惠
--d.discount_value as d.每月优惠金额--这是单独存储的字段，0息0费率的合同才需要核对这个值
f.lead_amount as f前置咨询费,--前置咨询费(针对现金贷)???【新产品上线后应该就没有前置咨询费了，有可能废弃掉，或者更改为抵用券售价】
f.month_ir as f月贷款利率,p.month_ir as p月贷款利率,--月有效利息率(product)
f.account_fee_rate as f月咨询费用率,p.account_fee as p月咨询费率,--月咨询费用率(product)---在前端申请表上叫【月咨询费】
f.coupon_amount as f买立减优惠金额,e.coupon_amount as e买立减优惠金额,round(f.credit_amount*p.overpay_year*(1-0.9)/12/100,0) as s买立减优惠金额,--买立减优惠金额(低速电动四轮车才有)【优惠金额=贷款本金 * OVERPAY_YEAR *（1-0.9）/12/100】
f.credit_type as f合同类别,--合同类别,来自cs_credit表  SS-消费贷; SC-现金贷;CY-循环贷 ; QC-钱包取现； XO-钱包消费
f.account_fee as f月咨询费,round((f.credit_amount*f.account_fee_rate/100),3) as s月咨询费,--咨询费（月前置咨询费=贷款金额 * account_fee_rate(product.account_fee)在（财务那边叫月财务费、月服务费用）--在【申请表】上叫月咨询费）
f.seller_service_fee as f前置商家服务费,(f.credit_amount*p.seller_bonus) as s前置商家服务费,--前置商家服务费--如果不为0则需在打款给商家时收取商家费用【】
f.customer_service_fee as f前置客户服务费,--前置客户服务费--不收取，改为抵用券的费用
f.interest_coupon as f每期利息减免,--每期利息减免（WECHAT_Record.）--零花钱使用了免息券
f.finance_coupon as f每期财务费减免,--每期财务费减免--零花钱使用了免息券
f.stamp_amount as f印花税,(f.credit_amount*0.00005) as s印花税,--印花税
f.seller_return_fee as f商家返点费用,(f.credit_amount * p.seller_bonus / 100) as s商家返点费用,--商家返点费用
f.sa_bonus_fee as f销售提成费用,(f.credit_amount * p.sa_bonus / 100) as s销售提成费用,--销售提成费用（product.SA_BONUS)
f.cs_fee2 as f月咨询费用2,--月咨询费用(钱包的是日咨询费 第二区间，wallet_credot 贷款金额*service_fee2）注意统一*100---非X钱包的合同统一为0
f.cs_fee_rate2 as f月咨询费率2,--月咨询费率（倒推出来保存3为小数点）(钱包的是日咨询费 第二区间）---非X钱包的合同统一为0
f.giveu_month_ir as f即有年化率,p.month_ir as p即有年化率,--即有年化率（默认）0.13/365
f.cs_coupon as f每期咨询费减免,--每期咨询费减免----咨询费减免一般都是0
f.accident_insurance_fee as f手Q意外保险费用,--意外保险费用（手Q项目新增 包含手机延保）---只有手Q的合同有，其他没有
f.coupon_sales as f抵用券售价,(f.credit_amount*0.1) as s抵用券售价,--抵用券的实际售价--【现金贷=提款额* ISCOUNSEL/100】--【商品贷=贷款本金*10%】（但是由于消费贷是赠送的，所以消费贷的售价为0）
f.voucher_amount as f抵用券面值,ceil((f.credit_amount*0.1)/100)*100 as s抵用券面值,--抵用券面值--【现金贷=抵用券实际售价*1.2后向上取整】【商品贷=抵用券售价向上取整】--这里用的公式是先除以100，然后向上取整，接着再乘以100
f.voucher_count as f抵用券数量,(f.voucher_amount/100) as s抵用券数量,--赠券数量--【数量=抵用券面值/100】
i.type_instalment as i百宝箱92,i.value_instalment as i百宝箱费用,--还款计划表的百宝箱费用
--f.treasure_box_fee as f百宝箱费用,FLOOR(f.credit_amount*t.treasure_box_rate/100) as s百宝箱费用,--百宝箱费用--小数点抹去，相当于向下取整
--f.treasure_box_flag as f百宝箱是否购买,--百宝箱标识 0-未购买； 1-已购买；2-取消
g.broken_screen_type as 碎屏零未购买二已购买,
g.stag_insurance_type as 碎屏零未购买二已购买,
f.broken_screen_service as f碎屏,g.BROKEN_SCREEN_SERVICE as g碎屏,--碎屏服务（取值cs_goods）
f.stag_insurance_service as f延保,g.STAG_INSURANCE_SERVICE as g延保,--延保服务（取值cs_goods）
y.service_category as 一延保二碎屏,
y.goods_category as 零通用一普通二苹果,
y.payment_num_price as s碎屏延保费用
  from dafy_sales.cs_credit c ----合同主表
 inner join dafy_sales.product p on p.ID = c.id_product --链接产品表
 inner join dafy_sales.cs_credit_fee f on c.id=f.id_credit--链接合同费用表
 inner join dafy_sales.cs_experience e on c.id=e.id_credit--链接代扣银行卡表
 inner join dafy_sales.cs_goods g on c.id=g.id_credit
--inner join dafy_sales.TREASURE_BOX_TABLES t on t.search_type=p.search_type---链接百宝箱费用表
 inner join dafy_sales.product_added_services y on y.payment_num=p.payment_num--链接碎屏延保配置表
 inner join dafy_sales.instalment i on i.id_credit=c.id
--inner join dafy_sales.cs_discount d on c.id=d.id_credit--0息0费率需要查看这张表数据
where c.contract_no=16544372001 
 and c.credit_amount >= y.min_price and c.credit_amount <= y.max_price and y.verson=1
 and i.num_instalment=1 and i.status='a'
 order by i.type_instalment;
