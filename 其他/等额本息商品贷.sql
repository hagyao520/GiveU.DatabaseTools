select c.contract_no as ��ͬ��,--��ͬ��
c.credit_model as ��ͬ�ʽ�ģʽ,--��ͬ���ʽ�ģʽ��Ҫ�Ͳ�Ʒ��󶨵Ľ��ģʽ�Ե���
f.credit_amount as f������,c.credit_amount as c������,g.goods_credit_amount as g������,--������(cs_credit)
c.init_pay c�׸�,g.goods_init_pay as g�׸�,--�׸����
c.price as c��Ʒ�۸�,g.goods_price as g��Ʒ�۸�,(c.credit_amount+c.init_pay) as s��Ʒ�۸�,--��Ʒ�۸�
c.deduct_date as c�״οۿ���,e.fst_date_pay as e�״οۿ���,--��ͬ��һ�ڵĻ�����--e������ֶ��Ѿ�������
(round((f.credit_amount*p.month_ratio_eir)/100,0))+(f.insurance_fee)+(f.power_fee)+(f.treasure_box_fee) as sÿ���ܻ����,--������»������������Ȩ��������ǲ������ֻ��������ӱ���
i.type_instalment as i����1,i.value_instalment as i�������,f.principal as f��һ�ڱ���,--��һ�ڱ���
ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3) as s��һ�ڱ���,--SQL��ĵȶϢ����������ĵ�һ�ڱ���
i.type_instalment as i��Ϣ2,i.value_instalment as i��Ϣ����,f.interest as f��һ����Ϣ,--��һ����Ϣ
ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),4) as s��һ����Ϣ,--SQL��ĵȶϢ����������ĵ�һ����Ϣ
(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))+(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))as sÿ��Ӧ����Ϣ,--ʵ���Ͼ��ǵ�һ�ڵı���+��һ�ڵ���Ϣ֮��
(round((f.credit_amount*p.month_ratio_eir)/100,0))-((ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))+(ROUND((f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),p.payment_num))/(power(1+(p.month_ir/100),p.payment_num)-1)-(f.credit_amount*(p.month_ir/100)*power(1+(p.month_ir/100),0))/(power(1+(p.month_ir/100),p.payment_num)-1),3))) as sÿ��Ӧ������,--�������ÿ��Ӧ�������ǡ�ÿ���ܻ����-ÿ��Ӧ����Ϣ��
f.cs_fee as f�·����,(f.annuity - f.principal - f.interest - f.account_fee) as s�·����,--�·������--�ڡ�������Ͻ��·����--���ǵ��˳���������
f.cs_fee_rate as f�·������,round(((f.annuity - f.principal - f.interest - f.account_fee) / f.credit_amount * 100),3) as s�·������,--�·�����ʣ����˳�������3λС���㣩--�ڡ�������Ͻ��·������--�ڲ�Ʒ��������²������
c.repay_style as c���ʽ,--0�ȶϢ��1ǰ�ͺ�ߣ�
f.annuity as f���»����,c.annuity as c���»����,round((f.credit_amount*p.month_ratio_eir)/100,0) as s���»����,--�»������������գ��ֻ��������ӱ���--���º�ͬ�ô����*��Ʒ��eir�������������EIR��BIRҪ��0Ϣ0������BIR��EIR��BIR���������ʡ�
c.power_flag as cȨ�������״̬,--0δ����1�����棻2�����棻9ȡ��
f.power_fee as fȨ�������,c.power_fee as cȨ�������,--Ȩ������ã������շ�cs_credit.power_fee��2�����£�18Ԫ/�£�2�����ϣ�0.1%/��
e.is_ssi as e�Ƿ�����,--0δ����1�ѹ���
g.insurance_supplier as ��������,--0δ����1ƽ����2����˼ά��3����
i.type_instalment as i����70,i.value_instalment as i���շ�,--����ƻ���ı���
f.insurance_fee as f���շ�,c.insurance_fee as c���շ�,e.insurance_fee as e���շ�,FLOOR(f.credit_amount*0.008) as s���շ�,--���շ��ã�ȡֵcs_experience����������ͨǧ�ţ���Ӫ��ǧ�ģ�����ǧ�ˡ�
f.discount_amount as fÿ���Żݽ��,round((f.credit_amount*p.month_ratio_bir)/100)-round((f.credit_amount*p.month_ratio_eir)/100) sÿ���Żݽ��,--��d.discount_value as dÿ���Żݽ�--ÿ���Żݽ�������*���»�ϵ��bir-�»�ϵ��eir����--����Ϊ���Ż�
--d.discount_value as d.ÿ���Żݽ��--���ǵ����洢���ֶΣ�0Ϣ0���ʵĺ�ͬ����Ҫ�˶����ֵ
f.lead_amount as fǰ����ѯ��,--ǰ����ѯ��(����ֽ��)???���²�Ʒ���ߺ�Ӧ�þ�û��ǰ����ѯ���ˣ��п��ܷ����������߸���Ϊ����ȯ�ۼۡ�
f.month_ir as f�´�������,p.month_ir as p�´�������,--����Ч��Ϣ��(product)
f.account_fee_rate as f����ѯ������,p.account_fee as p����ѯ����,--����ѯ������(product)---��ǰ��������ϽС�����ѯ�ѡ�
f.coupon_amount as f�������Żݽ��,e.coupon_amount as e�������Żݽ��,round(f.credit_amount*p.overpay_year*(1-0.9)/12/100,0) as s�������Żݽ��,--�������Żݽ��(���ٵ綯���ֳ�����)���Żݽ��=����� * OVERPAY_YEAR *��1-0.9��/12/100��
f.credit_type as f��ͬ���,--��ͬ���,����cs_credit��  SS-���Ѵ�; SC-�ֽ��;CY-ѭ���� ; QC-Ǯ��ȡ�֣� XO-Ǯ������
f.account_fee as f����ѯ��,round((f.credit_amount*f.account_fee_rate/100),3) as s����ѯ��,--��ѯ�ѣ���ǰ����ѯ��=������ * account_fee_rate(product.account_fee)�ڣ������Ǳ߽��²���ѡ��·�����ã�--�ڡ�������Ͻ�����ѯ�ѣ�
f.seller_service_fee as fǰ���̼ҷ����,(f.credit_amount*p.seller_bonus) as sǰ���̼ҷ����,--ǰ���̼ҷ����--�����Ϊ0�����ڴ����̼�ʱ��ȡ�̼ҷ��á���
f.customer_service_fee as fǰ�ÿͻ������,--ǰ�ÿͻ������--����ȡ����Ϊ����ȯ�ķ���
f.interest_coupon as fÿ����Ϣ����,--ÿ����Ϣ���⣨WECHAT_Record.��--�㻨Ǯʹ������Ϣȯ
f.finance_coupon as fÿ�ڲ���Ѽ���,--ÿ�ڲ���Ѽ���--�㻨Ǯʹ������Ϣȯ
f.stamp_amount as fӡ��˰,(f.credit_amount*0.00005) as sӡ��˰,--ӡ��˰
f.seller_return_fee as f�̼ҷ������,(f.credit_amount * p.seller_bonus / 100) as s�̼ҷ������,--�̼ҷ������
f.sa_bonus_fee as f������ɷ���,(f.credit_amount * p.sa_bonus / 100) as s������ɷ���,--������ɷ��ã�product.SA_BONUS)
f.cs_fee2 as f����ѯ����2,--����ѯ����(Ǯ����������ѯ�� �ڶ����䣬wallet_credot ������*service_fee2��ע��ͳһ*100---��XǮ���ĺ�ͬͳһΪ0
f.cs_fee_rate2 as f����ѯ����2,--����ѯ���ʣ����Ƴ�������3ΪС���㣩(Ǯ����������ѯ�� �ڶ����䣩---��XǮ���ĺ�ͬͳһΪ0
f.giveu_month_ir as f�����껯��,p.month_ir as p�����껯��,--�����껯�ʣ�Ĭ�ϣ�0.13/365
f.cs_coupon as fÿ����ѯ�Ѽ���,--ÿ����ѯ�Ѽ���----��ѯ�Ѽ���һ�㶼��0
f.accident_insurance_fee as f��Q���Ᵽ�շ���,--���Ᵽ�շ��ã���Q��Ŀ���� �����ֻ��ӱ���---ֻ����Q�ĺ�ͬ�У�����û��
f.coupon_sales as f����ȯ�ۼ�,(f.credit_amount*0.1) as s����ȯ�ۼ�,--����ȯ��ʵ���ۼ�--���ֽ��=����* ISCOUNSEL/100��--����Ʒ��=�����*10%���������������Ѵ������͵ģ��������Ѵ����ۼ�Ϊ0��
f.voucher_amount as f����ȯ��ֵ,ceil((f.credit_amount*0.1)/100)*100 as s����ȯ��ֵ,--����ȯ��ֵ--���ֽ��=����ȯʵ���ۼ�*1.2������ȡ��������Ʒ��=����ȯ�ۼ�����ȡ����--�����õĹ�ʽ���ȳ���100��Ȼ������ȡ���������ٳ���100
f.voucher_count as f����ȯ����,(f.voucher_amount/100) as s����ȯ����,--��ȯ����--������=����ȯ��ֵ/100��
i.type_instalment as i�ٱ���92,i.value_instalment as i�ٱ������,--����ƻ���İٱ������
--f.treasure_box_fee as f�ٱ������,FLOOR(f.credit_amount*t.treasure_box_rate/100) as s�ٱ������,--�ٱ������--С����Ĩȥ���൱������ȡ��
--f.treasure_box_flag as f�ٱ����Ƿ���,--�ٱ����ʶ 0-δ���� 1-�ѹ���2-ȡ��
g.broken_screen_type as ������δ������ѹ���,
g.stag_insurance_type as ������δ������ѹ���,
f.broken_screen_service as f����,g.BROKEN_SCREEN_SERVICE as g����,--��������ȡֵcs_goods��
f.stag_insurance_service as f�ӱ�,g.STAG_INSURANCE_SERVICE as g�ӱ�,--�ӱ�����ȡֵcs_goods��
y.service_category as һ�ӱ�������,
y.goods_category as ��ͨ��һ��ͨ��ƻ��,
y.payment_num_price as s�����ӱ�����
  from dafy_sales.cs_credit c ----��ͬ����
 inner join dafy_sales.product p on p.ID = c.id_product --���Ӳ�Ʒ��
 inner join dafy_sales.cs_credit_fee f on c.id=f.id_credit--���Ӻ�ͬ���ñ�
 inner join dafy_sales.cs_experience e on c.id=e.id_credit--���Ӵ������п���
 inner join dafy_sales.cs_goods g on c.id=g.id_credit
--inner join dafy_sales.TREASURE_BOX_TABLES t on t.search_type=p.search_type---���Ӱٱ�����ñ�
 inner join dafy_sales.product_added_services y on y.payment_num=p.payment_num--���������ӱ����ñ�
 inner join dafy_sales.instalment i on i.id_credit=c.id
--inner join dafy_sales.cs_discount d on c.id=d.id_credit--0Ϣ0������Ҫ�鿴���ű�����
where c.contract_no=16544372001 
 and c.credit_amount >= y.min_price and c.credit_amount <= y.max_price and y.verson=1
 and i.num_instalment=1 and i.status='a'
 order by i.type_instalment;
