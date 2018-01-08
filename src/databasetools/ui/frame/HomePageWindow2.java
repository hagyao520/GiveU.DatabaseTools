package databasetools.ui.frame;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import databasetools.ui.common.MyScrollBarUI;
import databasetools.util.*;

@SuppressWarnings("serial")
public class HomePageWindow2  extends JFrame{
	
	/** 主面板 */
	private JPanel MainPanel;  
	
	/** 数据展示列表 */
	public static JScrollPane DataDisplayList;
	
	/** 用户信息查询按钮 */
	private JButton UserInfoButton;
	/** 用户信息查询输入框 */
	private JTextField UserInfoTextField;

	/** 用户绑定门店信息查询按钮 */
	private JButton UserBoundStoreButton;
	/** 用户绑定门店信息查询输入框 */
	private JTextField UserBoundStoreTextField;
	
	/** 城市绑定合同模式查询按钮 */ 
	private JButton CityBoundContractModeButton;
	/** 城市绑定合同模式查询输入框 */
	private JTextField CityBoundContractModeTextField;
	
	/** 门店绑定商品类型查询按钮 */
	private JButton StoreBoundCommodityTypeButton; 
	/** 门店绑定商品类型查询输入框 */
	private JTextField StoreBoundCommodityTypeTextField;
	
	/** 门店绑定产品版本查询按钮 */
	private JButton StoreBoundProductVersionButton; 
	/** 门店绑定产品版本查询输入框 */
	private JTextField StoreBoundProductVersionTextField;
	
	/** 产品版本查询按钮 */
	private JButton ProductVersionButton; 
	/** 产品版本代码输入框 */
	private JTextField ProductVersionCodeTextField;
	/** 产品注册代码输入框 */
	private JTextField ProductRegistrationCodeTextField;
	
	/** 产品信息查询按钮 */
	private JButton ProductInformationButton; 
	/** 合同模式输入框 */
	private JTextField ContractModeTextField;
	/** 商品类型输入框 */
	private JTextField CommodityTypeTextField;
	/** 产品版本输入框 */
	private JTextField ProductVersionTextField;
	/** 产品类型输入框 */
	private JTextField ProductTypeTextField;  
	/** 首付比例输入框 */
	private JTextField DownPaymentRatioTextField;
	/** 产品状态输入框 */
	private JTextField ProductStatusTextField;

	/** 保险及上限费查询按钮 */
	private JButton InsuranceFeeButton; 
	/** 贷款本金输入框 */
	private JTextField LoanPrincipalTextField_Insurance;  
	/** 保险费率输入框 */
	private JTextField InsuranceRateTextField;  
	/** 产品代码输入框 */
	private JTextField ProductVersionCodeTextField_Insurance;
	
	/** 百宝箱费用查询按钮 */
	private JButton TreasureBoxFeeButton;
	/** 贷款本金输入框 */
	private JTextField LoanPrincipalTextField_TreasureBox;  
	/** 百宝箱费率输入框 */
	private JTextField TreasureBoxRateTextField;  
	/** 产品代码输入框 */
	private JTextField ProductVersionCodeTextField_TreasureBox;
	
	/** 商城赠券费用查询按钮 */
	private JButton MallCouponsFeeButton;  
	/** 贷款本金输入框 */
	private JTextField LoanPrincipalTextField_MallCoupons;  
	/** 商城赠券费率输入框 */
	private JTextField MallCouponsRateTextField;  
	/** 产品代码输入框 */
	private JTextField ProductVersionCodeTextField_MallCoupons;
	
	/** 每期应还费用查询按钮 */
	private JButton EachPeriodShouldBeReturnedFeeButton;    
	/** 贷款本金输入框 */
	private JTextField LoanPrincipalTextField_EachPeriodShouldBeReturned;  
	/** 保险费输入框 */
	private JTextField InsuranceFeeTextField_EachPeriodShouldBeReturned;  
	/** 百宝箱费输入框 */
	private JTextField TreasureBoxFeeTextField_EachPeriodShouldBeReturned;
	/** 产品代码输入框 */
	private JTextField ProductVersionCodeTextField_EachPeriodShouldBeReturned;
	
	/** 全面保费用查询按钮 */
	private JButton ComprehensiveInsuranceFeeButton;    
	/** 贷款本金输入框 */
	private JTextField LoanPrincipalTextField_ComprehensiveInsurance;  

	/** 教育程度查询按钮 */
	private JButton EducationalLevelButton;      
	/** 教育程度注册代码输入框 */
	private JTextField EducationalLevelRegistrationCodeTextField;
		
	/** 住房情况查询按钮 */
	private JButton HousingSituationButton;          
	/** 住房情况注册代码输入框 */
	private JTextField HousingSituationRegistrationCodeTextField;
	
	/** 婚姻状况查询按钮 */
	private JButton MaritalStatusButton;            
	/** 婚姻状况注册代码输入框 */
	private JTextField MaritalStatusRegistrationCodeTextField;
	
	/** 行业类别查询按钮 */
	private JButton IndustryCategoryButton;              
	/** 行业类别注册代码输入框 */
	private JTextField IndustryCategoryRegistrationCodeTextField;

	/** 单位性质查询按钮 */
	private JButton UnitPropertiesButton;                
	/** 单位性质注册代码输入框 */
	private JTextField UnitPropertiesRegistrationCodeTextField;
	
	/** 职位查询按钮 */
	private JButton PositionButton;        
	/** 职位注册代码输入框 */
	private JTextField PositionRegistrationCodeTextField;
	
	/** 工作年限查询按钮 */
	private JButton WorkingLifeButton;        
	/** 工作年限注册代码输入框 */
	private JTextField WorkingLifeRegistrationCodeTextField;
	
	/** 支持银行查询按钮 */
	private JButton SupportBankButton;          
	/** 支持银行注册代码输入框 */
	private JTextField SupportBankRegistrationCodeTextField;
	
	/** 评定内部代码查询按钮 */
	private JButton EvaluationOfInternalCodeButton;            
	/** 评定内部代码注册代码输入框 */
	private JTextField EvaluationOfInternalCodeRegistrationCodeTextField;
	
	/** 短征信验证码查询按钮 */
	private JButton SMSAuthorizationAuthenticationCodeButton;              
	/** 手机号输入框 */
	private JTextField PhoneNumberTextField_SMSAuthorizationAuthentication;  
	
	/** 客户合同查询按钮 */
	private JButton CustomerContractButton;                  
	/** 销售ID输入框 */
	private JTextField SellingIDTextField; 
	
	/** 每期还款费用查询按钮 */
	private JButton RepaymentsForEachPeriodFeeButton;      
	/** 贷款本金输入框 */
	private JTextField LoanPrincipalTextField_RepaymentsForEachPeriod;  
	/** 保险费输入框 */
	private JTextField InsuranceFeeTextField_RepaymentsForEachPeriod;  
	/** 百宝箱费用输入框 */
	private JTextField TreasureBoxFeeTextField_RepaymentsForEachPeriod;
	/** 全面保费输入框 */
	private JTextField ComprehensiveInsuranceFeeTextField; 
	/** 产品代码输入框 */
	private JTextField ProductVersionCodeTextField_RepaymentsForEachPeriod;
	
	/** 每月还款金额查询按钮 */
	private JButton MonthlyReturnFeeButton;       
	/** 贷款本金输入框 */
	private JTextField LoanPrincipalTextField_MonthlyReturn;  
	/** 产品代码输入框 */
	private JTextField ProductVersionCodeTextField_MonthlyReturn;
	
	/** 每月应还本息费用查询按钮 */
	private JButton MonthlyWeShouldAlsoPrincipalFeeButton;      
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_MonthlyWeShouldAlsoPrincipal;    

	/** 每月应付费用查询按钮 */
	private JButton MonthlyPayableFeeButton;
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_MonthlyPayable; 
	
	/** 月咨询费及月咨询费率查询按钮 */
	private JButton MonthlyConsultingFeeAndRateButton;
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_MonthlyConsulting; 
	
	/** 月服务费及月服务费率查询按钮 */
	private JButton MonthlyServiceFeeAndRateButton;  
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_MonthlyService; 
	
	/** 月贷款利率查询按钮 */
	private JButton MonthlyLoanInterestRateButton;    
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_MonthlyLoanInterestRate; 
	
	
	/** 合同状态修改按钮 */
	private JButton ContractStateUpdateButton;      
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_ContractStateUpdate; 
	/** 合同状态输入框 */
	private JTextField ContractStateTextField_ContractStateUpdate; 
	
	/** 短信签章验证码查询按钮 */
	private JButton ShortMessageSignatureCodeButton;                
	/** 手机号输入框 */
	private JTextField PhoneNumberTextField_ShortMessageSignature; 
	
	/** PDF签章合同查询按钮 */  
	private JButton PDFSigningContractButton;                
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_PDFSigningContract; 
	
	/** 签章记录删除按钮 */  
	private JButton SignatureRecordDeleteButton; 
	/** 合同ID输入框 */
	private JTextField ContractIDTextField_SignatureRecord; 
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_SignatureRecord; 
	
	/** 存储过程执行按钮 */  
	private JButton StoredProcedureExecutionButton;   
	/** 存储过程名称输入框 */
	private JTextField StoredProcedureNameTextField_StoredProcedureExecution; 
	/** 合同号输入框 */
	private JTextField ContractNumberTextField_StoredProcedureExecution;
	/** 合同ID输入框 */
	private JTextField ContractIDTextField_StoredProcedureExecution; 
	
	/** 还款计划表查询按钮 */  
	private JButton ReimbursementPlanQueryButton;     
	/** 还款计划表删除按钮 */  
	private JButton ReimbursementPlanDeleteButton; 
	/** 合同ID输入框 */
	private JTextField ContractIDTextField_ReimbursementPlan; 
		
	/** 合同号Txt */
	private JLabel contractLabel;
	/** 合同号输入框 */
	private JTextField contractField;
	/** 查询合同费用详情按钮 */
	private JButton InquiryContractExpensesButton;

	/** SQLTxt */
	private JLabel SQLLabel;
	/** SQL提示Txt */
	private JLabel SQLPromptLabel;
	/** SQL输入框*/
	private JTextArea SQLArea;
	/** SQL输入框滑轮*/
	private JScrollPane SQLScroll;
	/** 查询SQL详情按钮 */
	private JButton SQLButton;
	
	/** 挂起进程按钮 */
	private JButton HangUpProcess;
	/** 挂起进程图标 */
	private TrayIcon icon;
	private SystemTray tray;

	public static HomePageWindow2 getInstance() {
		HomePageWindow2 inst = new HomePageWindow2();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
		return inst;
	}
	
	public HomePageWindow2() {
		super();
		initGUI();
		initTrayIcon();
		initFocusListener();
		initButtonEvent();
	}
	
	private void initGUI() {
		
	    try {			
			setTitle("By:小智出品，必属精品-----欢迎使用即有宝<等额本息商品贷>信息查询系统  ");
			setSize(1920,1080-30);
			setLocation(0,0);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			MainPanel = new JPanel() {
			//设置背景图片	
//			private static final long serialVersionUID = 1L;
//			  protected void paintComponent(Graphics g) {
//					super.paintComponent(g);
//					g.drawImage(PictureUtil.getPicture("HomePage.png").getImage(), 0, 0, null);
//					this.setOpaque(false);
//			  }
			};
			MainPanel.setLayout(null);
			getContentPane().add(MainPanel, BorderLayout.CENTER);
			MainPanel.setBorder(Constants.GRAY_BORDER);
			
			DataDisplayList = new JScrollPane();
			DataDisplayList.setBounds(730,10,1180,807);
			//设置背景是否透明
			DataDisplayList.setOpaque(false);  
			DataDisplayList.getViewport().setOpaque(false);  
			MainPanel.add(DataDisplayList);
			
//			UserInfoButton = new JLabel("用户信息查询");
//			UserInfoButton.setFont(Constants.BASIC_FONT4);
//			UserInfoButton.setBorder(null);
//			UserInfoButton.setBounds(10, 10, 120, 25);
//			UserInfoButton.setOpaque(false);
//			UserInfoButton.setBackground(new Color(240, 245, 240, 60));
//			MainPanel.add(UserInfoButton);

			UserInfoButton = new JButton("用户信息查询");
			UserInfoButton.setFont(Constants.BASIC_FONT4);
			UserInfoButton.setBounds(10, 10, 140, 25);
			MainPanel.add(UserInfoButton);
		
			UserInfoTextField = new JTextField();
			UserInfoTextField.setBounds(160, 10, 180, 25);
			UserInfoTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			UserInfoTextField.setText("请输入用户ID...");
			UserInfoTextField.setFont(Constants.BASIC_FONT4);
			UserInfoTextField.setForeground(Color.GRAY); 
			MainPanel.add(UserInfoTextField);

			UserBoundStoreButton = new JButton("用户绑定门店");
			UserBoundStoreButton.setFont(Constants.BASIC_FONT4);
			UserBoundStoreButton.setBounds(350, 10, 140, 25);
			MainPanel.add(UserBoundStoreButton);
	
			UserBoundStoreTextField = new JTextField();
			UserBoundStoreTextField.setBounds(500, 10, 220, 25);
			UserBoundStoreTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			UserBoundStoreTextField.setText("请输入用户ID...");
			UserBoundStoreTextField.setFont(Constants.BASIC_FONT4);
			UserBoundStoreTextField.setForeground(Color.GRAY); 
			MainPanel.add(UserBoundStoreTextField);
			
			CityBoundContractModeButton = new JButton("城市绑定合同模式");
			CityBoundContractModeButton.setFont(Constants.BASIC_FONT4);
			CityBoundContractModeButton.setBounds(10, 40, 140, 25);
			MainPanel.add(CityBoundContractModeButton);
	
			CityBoundContractModeTextField = new JTextField();
			CityBoundContractModeTextField.setBounds(160, 40, 180, 25);
			CityBoundContractModeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			CityBoundContractModeTextField.setText("请输入城市名称...");
			CityBoundContractModeTextField.setFont(Constants.BASIC_FONT4);
			CityBoundContractModeTextField.setForeground(Color.GRAY); 
			MainPanel.add(CityBoundContractModeTextField);
			
			StoreBoundCommodityTypeButton = new JButton("门店绑定商品类型");
			StoreBoundCommodityTypeButton.setFont(Constants.BASIC_FONT4);
			StoreBoundCommodityTypeButton.setBounds(350, 40, 140, 25);
			MainPanel.add(StoreBoundCommodityTypeButton);
	
			StoreBoundCommodityTypeTextField = new JTextField();
			StoreBoundCommodityTypeTextField.setBounds(500, 40, 220, 25);
			StoreBoundCommodityTypeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			StoreBoundCommodityTypeTextField.setText("请输入门店代码...");
			StoreBoundCommodityTypeTextField.setFont(Constants.BASIC_FONT4);
			StoreBoundCommodityTypeTextField.setForeground(Color.GRAY); 
			MainPanel.add(StoreBoundCommodityTypeTextField);
			
			StoreBoundProductVersionButton = new JButton("门店绑定产品版本");
			StoreBoundProductVersionButton.setFont(Constants.BASIC_FONT4);
			StoreBoundProductVersionButton.setBounds(10, 70, 140, 25);
			MainPanel.add(StoreBoundProductVersionButton);
	
			StoreBoundProductVersionTextField = new JTextField();
			StoreBoundProductVersionTextField.setBounds(160, 70, 560, 25);
			StoreBoundProductVersionTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			StoreBoundProductVersionTextField.setText("请输入门店代码...");
			StoreBoundProductVersionTextField.setFont(Constants.BASIC_FONT4);
			StoreBoundProductVersionTextField.setForeground(Color.GRAY); 
			MainPanel.add(StoreBoundProductVersionTextField);
			
			ProductVersionButton = new JButton("产品版本查询");
			ProductVersionButton.setFont(Constants.BASIC_FONT4);
			ProductVersionButton.setBounds(10, 100, 140, 25);
			MainPanel.add(ProductVersionButton);
	
			ProductVersionCodeTextField = new JTextField();
			ProductVersionCodeTextField.setBounds(160, 100, 275, 25);
			ProductVersionCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductVersionCodeTextField.setText("请输入产品版本代码,多个请以'?','?'隔开...");
			ProductVersionCodeTextField.setFont(Constants.BASIC_FONT4);
			ProductVersionCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(ProductVersionCodeTextField);
			
			ProductRegistrationCodeTextField = new JTextField();
			ProductRegistrationCodeTextField.setBounds(445, 100, 275, 25);
			ProductRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductRegistrationCodeTextField.setText("请输入产品注册代码...");
			ProductRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			ProductRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(ProductRegistrationCodeTextField);
			
			ProductInformationButton = new JButton("产品信息查询");
			ProductInformationButton.setFont(Constants.BASIC_FONT4);
			ProductInformationButton.setBounds(10, 130, 140, 25*2+5);
			MainPanel.add(ProductInformationButton);
	
			ContractModeTextField = new JTextField();
			ContractModeTextField.setBounds(160, 130, 180, 25);
			ContractModeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractModeTextField.setText("请输入合同模式..");
			ContractModeTextField.setFont(Constants.BASIC_FONT4);
			ContractModeTextField.setForeground(Color.GRAY); 
			MainPanel.add(ContractModeTextField);
			
			CommodityTypeTextField = new JTextField();
			CommodityTypeTextField.setBounds(350, 130, 180, 25);
			CommodityTypeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			CommodityTypeTextField.setText("请输入商品类型...");
			CommodityTypeTextField.setFont(Constants.BASIC_FONT4);
			CommodityTypeTextField.setForeground(Color.GRAY); 
			MainPanel.add(CommodityTypeTextField);
			
			ProductVersionTextField = new JTextField();
			ProductVersionTextField.setBounds(540, 130, 180, 25);
			ProductVersionTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductVersionTextField.setText("请输入产品版本...");
			ProductVersionTextField.setFont(Constants.BASIC_FONT4);
			ProductVersionTextField.setForeground(Color.GRAY); 
			MainPanel.add(ProductVersionTextField);
			
			ProductTypeTextField = new JTextField();
			ProductTypeTextField.setBounds(160, 160, 180, 25);
			ProductTypeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductTypeTextField.setText("请输入产品类型...");
			ProductTypeTextField.setFont(Constants.BASIC_FONT4);
			ProductTypeTextField.setForeground(Color.GRAY); 
			MainPanel.add(ProductTypeTextField);
			
			DownPaymentRatioTextField = new JTextField();
			DownPaymentRatioTextField.setBounds(350, 160, 180, 25);
			DownPaymentRatioTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			DownPaymentRatioTextField.setText("请输入首付比例...");
			DownPaymentRatioTextField.setFont(Constants.BASIC_FONT4);
			DownPaymentRatioTextField.setForeground(Color.GRAY); 
			MainPanel.add(DownPaymentRatioTextField);
			
			ProductStatusTextField = new JTextField();
			ProductStatusTextField.setBounds(540, 160, 180, 25);
			ProductStatusTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductStatusTextField.setText("请输入产品状态...");
			ProductStatusTextField.setFont(Constants.BASIC_FONT4);
			ProductStatusTextField.setForeground(Color.GRAY); 
			MainPanel.add(ProductStatusTextField);
	
			InsuranceFeeButton = new JButton("保险及上限费查询");
			InsuranceFeeButton.setFont(Constants.BASIC_FONT4);
			InsuranceFeeButton.setBounds(10, 190, 140, 25);
			MainPanel.add(InsuranceFeeButton);
	
			LoanPrincipalTextField_Insurance = new JTextField();
			LoanPrincipalTextField_Insurance.setBounds(160, 190, 180, 25);
			LoanPrincipalTextField_Insurance.setBorder(Constants.LIGHT_GRAY_BORDER);
			LoanPrincipalTextField_Insurance.setText("请输入贷款本金...");
			LoanPrincipalTextField_Insurance.setFont(Constants.BASIC_FONT4);
			LoanPrincipalTextField_Insurance.setForeground(Color.GRAY); 
			MainPanel.add(LoanPrincipalTextField_Insurance);
			
			InsuranceRateTextField = new JTextField();
			InsuranceRateTextField.setBounds(350, 190, 180, 25);
			InsuranceRateTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			InsuranceRateTextField.setText("请输入保险费率...");
			InsuranceRateTextField.setFont(Constants.BASIC_FONT4);
			InsuranceRateTextField.setForeground(Color.GRAY); 
			MainPanel.add(InsuranceRateTextField);
			
			ProductVersionCodeTextField_Insurance = new JTextField();
			ProductVersionCodeTextField_Insurance.setBounds(540, 190, 180, 25);
			ProductVersionCodeTextField_Insurance.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductVersionCodeTextField_Insurance.setText("请输入产品代码...");
			ProductVersionCodeTextField_Insurance.setFont(Constants.BASIC_FONT4);
			ProductVersionCodeTextField_Insurance.setForeground(Color.GRAY); 
			MainPanel.add(ProductVersionCodeTextField_Insurance);
			
			TreasureBoxFeeButton = new JButton("百宝箱费用查询");
			TreasureBoxFeeButton.setFont(Constants.BASIC_FONT4);
			TreasureBoxFeeButton.setBounds(10, 220, 140, 25);
			MainPanel.add(TreasureBoxFeeButton);
	
			LoanPrincipalTextField_TreasureBox = new JTextField();
			LoanPrincipalTextField_TreasureBox.setBounds(160, 220, 180, 25);
			LoanPrincipalTextField_TreasureBox.setBorder(Constants.LIGHT_GRAY_BORDER);
			LoanPrincipalTextField_TreasureBox.setText("请输入贷款本金...");
			LoanPrincipalTextField_TreasureBox.setFont(Constants.BASIC_FONT4);
			LoanPrincipalTextField_TreasureBox.setForeground(Color.GRAY); 
			MainPanel.add(LoanPrincipalTextField_TreasureBox);
			
			TreasureBoxRateTextField = new JTextField();
			TreasureBoxRateTextField.setBounds(350, 220, 180, 25);
			TreasureBoxRateTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			TreasureBoxRateTextField.setText("请输入百宝箱费率...");
			TreasureBoxRateTextField.setFont(Constants.BASIC_FONT4);
			TreasureBoxRateTextField.setForeground(Color.GRAY); 
			MainPanel.add(TreasureBoxRateTextField);
			
			ProductVersionCodeTextField_TreasureBox = new JTextField();
			ProductVersionCodeTextField_TreasureBox.setBounds(540, 220, 180, 25);
			ProductVersionCodeTextField_TreasureBox.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductVersionCodeTextField_TreasureBox.setText("请输入产品代码...");
			ProductVersionCodeTextField_TreasureBox.setFont(Constants.BASIC_FONT4);
			ProductVersionCodeTextField_TreasureBox.setForeground(Color.GRAY); 
			MainPanel.add(ProductVersionCodeTextField_TreasureBox);
			
			MallCouponsFeeButton = new JButton("商城赠券费用查询");
			MallCouponsFeeButton.setFont(Constants.BASIC_FONT4);
			MallCouponsFeeButton.setBounds(10, 250, 140, 25);
			MainPanel.add(MallCouponsFeeButton);
	
			LoanPrincipalTextField_MallCoupons = new JTextField();
			LoanPrincipalTextField_MallCoupons.setBounds(160, 250, 180, 25);
			LoanPrincipalTextField_MallCoupons.setBorder(Constants.LIGHT_GRAY_BORDER);
			LoanPrincipalTextField_MallCoupons.setText("请输入贷款本金...");
			LoanPrincipalTextField_MallCoupons.setFont(Constants.BASIC_FONT4);
			LoanPrincipalTextField_MallCoupons.setForeground(Color.GRAY); 
			MainPanel.add(LoanPrincipalTextField_MallCoupons);
			
			MallCouponsRateTextField = new JTextField();
			MallCouponsRateTextField.setBounds(350, 250, 180, 25);
			MallCouponsRateTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			MallCouponsRateTextField.setText("请输入商城赠券费率...");
			MallCouponsRateTextField.setFont(Constants.BASIC_FONT4);
			MallCouponsRateTextField.setForeground(Color.GRAY); 
			MainPanel.add(MallCouponsRateTextField);
			
			ProductVersionCodeTextField_MallCoupons = new JTextField();
			ProductVersionCodeTextField_MallCoupons.setBounds(540, 250, 180, 25);
			ProductVersionCodeTextField_MallCoupons.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductVersionCodeTextField_MallCoupons.setText("请输入产品代码...");
			ProductVersionCodeTextField_MallCoupons.setFont(Constants.BASIC_FONT4);
			ProductVersionCodeTextField_MallCoupons.setForeground(Color.GRAY); 
			MainPanel.add(ProductVersionCodeTextField_MallCoupons);
			
			EachPeriodShouldBeReturnedFeeButton = new JButton("每期应还费用查询");
			EachPeriodShouldBeReturnedFeeButton.setFont(Constants.BASIC_FONT4);
			EachPeriodShouldBeReturnedFeeButton.setBounds(10, 280, 140, 25);
			MainPanel.add(EachPeriodShouldBeReturnedFeeButton);
	
			LoanPrincipalTextField_EachPeriodShouldBeReturned = new JTextField();
			LoanPrincipalTextField_EachPeriodShouldBeReturned.setBounds(160, 280, 130, 25);
			LoanPrincipalTextField_EachPeriodShouldBeReturned.setBorder(Constants.LIGHT_GRAY_BORDER);
			LoanPrincipalTextField_EachPeriodShouldBeReturned.setText("请输入贷款本金...");
			LoanPrincipalTextField_EachPeriodShouldBeReturned.setFont(Constants.BASIC_FONT4);
			LoanPrincipalTextField_EachPeriodShouldBeReturned.setForeground(Color.GRAY); 
			MainPanel.add(LoanPrincipalTextField_EachPeriodShouldBeReturned);
			
			InsuranceFeeTextField_EachPeriodShouldBeReturned = new JTextField();
			InsuranceFeeTextField_EachPeriodShouldBeReturned.setBounds(300, 280, 130, 25);
			InsuranceFeeTextField_EachPeriodShouldBeReturned.setBorder(Constants.LIGHT_GRAY_BORDER);
			InsuranceFeeTextField_EachPeriodShouldBeReturned.setText("请输入保险费...");
			InsuranceFeeTextField_EachPeriodShouldBeReturned.setFont(Constants.BASIC_FONT4);
			InsuranceFeeTextField_EachPeriodShouldBeReturned.setForeground(Color.GRAY); 
			MainPanel.add(InsuranceFeeTextField_EachPeriodShouldBeReturned);
			
			TreasureBoxFeeTextField_EachPeriodShouldBeReturned = new JTextField();
			TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setBounds(440, 280, 130, 25);
			TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setBorder(Constants.LIGHT_GRAY_BORDER);
			TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setText("请输入百宝箱费...");
			TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setFont(Constants.BASIC_FONT4);
			TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setForeground(Color.GRAY); 
			MainPanel.add(TreasureBoxFeeTextField_EachPeriodShouldBeReturned);
			
			ProductVersionCodeTextField_EachPeriodShouldBeReturned = new JTextField();
			ProductVersionCodeTextField_EachPeriodShouldBeReturned.setBounds(580, 280, 140, 25);
			ProductVersionCodeTextField_EachPeriodShouldBeReturned.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductVersionCodeTextField_EachPeriodShouldBeReturned.setText("请输入产品代码...");
			ProductVersionCodeTextField_EachPeriodShouldBeReturned.setFont(Constants.BASIC_FONT4);
			ProductVersionCodeTextField_EachPeriodShouldBeReturned.setForeground(Color.GRAY); 
			MainPanel.add(ProductVersionCodeTextField_EachPeriodShouldBeReturned);
			
			ComprehensiveInsuranceFeeButton = new JButton("全面保费用查询");
			ComprehensiveInsuranceFeeButton.setFont(Constants.BASIC_FONT4);
			ComprehensiveInsuranceFeeButton.setBounds(10, 310, 140, 25);
			MainPanel.add(ComprehensiveInsuranceFeeButton);
	
			LoanPrincipalTextField_ComprehensiveInsurance = new JTextField();
			LoanPrincipalTextField_ComprehensiveInsurance.setBounds(160, 310, 180, 25);
			LoanPrincipalTextField_ComprehensiveInsurance.setBorder(Constants.LIGHT_GRAY_BORDER);
			LoanPrincipalTextField_ComprehensiveInsurance.setText("请输入贷款本金...");
			LoanPrincipalTextField_ComprehensiveInsurance.setFont(Constants.BASIC_FONT4);
			LoanPrincipalTextField_ComprehensiveInsurance.setForeground(Color.GRAY); 
			MainPanel.add(LoanPrincipalTextField_ComprehensiveInsurance);
			
			EducationalLevelButton = new JButton("教育程度查询");
			EducationalLevelButton.setFont(Constants.BASIC_FONT4);
			EducationalLevelButton.setBounds(350, 310, 140, 25);
			MainPanel.add(EducationalLevelButton);
	
			EducationalLevelRegistrationCodeTextField = new JTextField();
			EducationalLevelRegistrationCodeTextField.setBounds(500, 310, 220, 25);
			EducationalLevelRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			EducationalLevelRegistrationCodeTextField.setText("请输入教育程度注册代码...");
			EducationalLevelRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			EducationalLevelRegistrationCodeTextField.setEditable(false);
			EducationalLevelRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			EducationalLevelRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(EducationalLevelRegistrationCodeTextField);
			
			HousingSituationButton = new JButton("住房情况查询");
			HousingSituationButton.setFont(Constants.BASIC_FONT4);
			HousingSituationButton.setBounds(10, 340, 140, 25);
			MainPanel.add(HousingSituationButton);
	
			HousingSituationRegistrationCodeTextField = new JTextField();
			HousingSituationRegistrationCodeTextField.setBounds(160, 340, 180, 25);
			HousingSituationRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			HousingSituationRegistrationCodeTextField.setText("请输入住房情况注册代码...");
			HousingSituationRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			HousingSituationRegistrationCodeTextField.setEditable(false);
			HousingSituationRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			HousingSituationRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(HousingSituationRegistrationCodeTextField);
			
			MaritalStatusButton = new JButton("婚姻状况查询");
			MaritalStatusButton.setFont(Constants.BASIC_FONT4);
			MaritalStatusButton.setBounds(350, 340, 140, 25);
			MainPanel.add(MaritalStatusButton);
	
			MaritalStatusRegistrationCodeTextField = new JTextField();
			MaritalStatusRegistrationCodeTextField.setBounds(500, 340, 220, 25);
			MaritalStatusRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			MaritalStatusRegistrationCodeTextField.setText("请输入婚姻状况注册代码...");
			MaritalStatusRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			MaritalStatusRegistrationCodeTextField.setEditable(false);
			MaritalStatusRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			MaritalStatusRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(MaritalStatusRegistrationCodeTextField);
			
			IndustryCategoryButton = new JButton("行业类别查询");
			IndustryCategoryButton.setFont(Constants.BASIC_FONT4);
			IndustryCategoryButton.setBounds(10, 370, 140, 25);
			MainPanel.add(IndustryCategoryButton);
	
			IndustryCategoryRegistrationCodeTextField = new JTextField();
			IndustryCategoryRegistrationCodeTextField.setBounds(160, 370, 180, 25);
			IndustryCategoryRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			IndustryCategoryRegistrationCodeTextField.setText("请输入行业类别注册代码...");
			IndustryCategoryRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			IndustryCategoryRegistrationCodeTextField.setEditable(false);
			IndustryCategoryRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			IndustryCategoryRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(IndustryCategoryRegistrationCodeTextField);
			
			UnitPropertiesButton = new JButton("单位性质查询");
			UnitPropertiesButton.setFont(Constants.BASIC_FONT4);
			UnitPropertiesButton.setBounds(350, 370, 140, 25);
			MainPanel.add(UnitPropertiesButton);
	
			UnitPropertiesRegistrationCodeTextField = new JTextField();
			UnitPropertiesRegistrationCodeTextField.setBounds(500, 370, 220, 25);
			UnitPropertiesRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			UnitPropertiesRegistrationCodeTextField.setText("请输入单位性质注册代码...");
			UnitPropertiesRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			UnitPropertiesRegistrationCodeTextField.setEditable(false);
			UnitPropertiesRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			UnitPropertiesRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(UnitPropertiesRegistrationCodeTextField);
			
			PositionButton = new JButton("职位信息查询");
			PositionButton.setFont(Constants.BASIC_FONT4);
			PositionButton.setBounds(10, 400, 140, 25);
			MainPanel.add(PositionButton);
	
			PositionRegistrationCodeTextField = new JTextField();
			PositionRegistrationCodeTextField.setBounds(160, 400, 180, 25);
			PositionRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			PositionRegistrationCodeTextField.setText("请输入职位注册代码...");
			PositionRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			PositionRegistrationCodeTextField.setEditable(false);
			PositionRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			PositionRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(PositionRegistrationCodeTextField);
			
			WorkingLifeButton = new JButton("工作年限查询");
			WorkingLifeButton.setFont(Constants.BASIC_FONT4);
			WorkingLifeButton.setBounds(350, 400, 140, 25);
			MainPanel.add(WorkingLifeButton);
	
			WorkingLifeRegistrationCodeTextField = new JTextField();
			WorkingLifeRegistrationCodeTextField.setBounds(500, 400, 220, 25);
			WorkingLifeRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			WorkingLifeRegistrationCodeTextField.setText("请输入工作年限注册代码...");
			WorkingLifeRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			WorkingLifeRegistrationCodeTextField.setEditable(false);
			WorkingLifeRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			WorkingLifeRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(WorkingLifeRegistrationCodeTextField);
			
			SupportBankButton = new JButton("支持银行查询");
			SupportBankButton.setFont(Constants.BASIC_FONT4);
			SupportBankButton.setBounds(10, 430, 140, 25);
			MainPanel.add(SupportBankButton);
	
			SupportBankRegistrationCodeTextField = new JTextField();
			SupportBankRegistrationCodeTextField.setBounds(160, 430, 180, 25);
			SupportBankRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			SupportBankRegistrationCodeTextField.setText("请输入支持银行注册代码...");
			SupportBankRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			SupportBankRegistrationCodeTextField.setEditable(false);
			SupportBankRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			SupportBankRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(SupportBankRegistrationCodeTextField);
			
			EvaluationOfInternalCodeButton = new JButton("评定内部代码查询");
			EvaluationOfInternalCodeButton.setFont(Constants.BASIC_FONT4);
			EvaluationOfInternalCodeButton.setBounds(350, 430, 140, 25);
			MainPanel.add(EvaluationOfInternalCodeButton);
	
			EvaluationOfInternalCodeRegistrationCodeTextField = new JTextField();
			EvaluationOfInternalCodeRegistrationCodeTextField.setBounds(500, 430, 220, 25);
			EvaluationOfInternalCodeRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
//			EvaluationOfInternalCodeRegistrationCodeTextField.setText("请输入评定内部注册代码...");
			EvaluationOfInternalCodeRegistrationCodeTextField.setText("程序已写死,可以直接查询...");
			EvaluationOfInternalCodeRegistrationCodeTextField.setEditable(false);
			EvaluationOfInternalCodeRegistrationCodeTextField.setFont(Constants.BASIC_FONT4);
			EvaluationOfInternalCodeRegistrationCodeTextField.setForeground(Color.GRAY); 
			MainPanel.add(EvaluationOfInternalCodeRegistrationCodeTextField);
			
			SMSAuthorizationAuthenticationCodeButton = new JButton("短征信授权验证码");
			SMSAuthorizationAuthenticationCodeButton.setFont(Constants.BASIC_FONT4);
			SMSAuthorizationAuthenticationCodeButton.setBounds(10, 460, 140, 25);
			MainPanel.add(SMSAuthorizationAuthenticationCodeButton);
	
			PhoneNumberTextField_SMSAuthorizationAuthentication = new JTextField();
			PhoneNumberTextField_SMSAuthorizationAuthentication.setBounds(160, 460, 180, 25);
			PhoneNumberTextField_SMSAuthorizationAuthentication.setBorder(Constants.LIGHT_GRAY_BORDER);
			PhoneNumberTextField_SMSAuthorizationAuthentication.setText("请输入手机号...");
			PhoneNumberTextField_SMSAuthorizationAuthentication.setFont(Constants.BASIC_FONT4);
			PhoneNumberTextField_SMSAuthorizationAuthentication.setForeground(Color.GRAY); 
			MainPanel.add(PhoneNumberTextField_SMSAuthorizationAuthentication);
			
			CustomerContractButton = new JButton("客户合同查询");
			CustomerContractButton.setFont(Constants.BASIC_FONT4);
			CustomerContractButton.setBounds(350, 460, 140, 25);
			MainPanel.add(CustomerContractButton);
	
			SellingIDTextField = new JTextField();
			SellingIDTextField.setBounds(500, 460, 220, 25);
			SellingIDTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			SellingIDTextField.setText("请输入销售ID...");
			SellingIDTextField.setFont(Constants.BASIC_FONT4);
			SellingIDTextField.setForeground(Color.GRAY); 
			MainPanel.add(SellingIDTextField);
			
			RepaymentsForEachPeriodFeeButton = new JButton("每期还款费用查询");
			RepaymentsForEachPeriodFeeButton.setFont(Constants.BASIC_FONT4);
			RepaymentsForEachPeriodFeeButton.setBounds(10, 490, 140, 25*2+5);
			MainPanel.add(RepaymentsForEachPeriodFeeButton);
	
			LoanPrincipalTextField_RepaymentsForEachPeriod = new JTextField();
			LoanPrincipalTextField_RepaymentsForEachPeriod.setBounds(160, 490, 180, 25);
			LoanPrincipalTextField_RepaymentsForEachPeriod.setBorder(Constants.LIGHT_GRAY_BORDER);
			LoanPrincipalTextField_RepaymentsForEachPeriod.setText("请输入贷款本金...");
			LoanPrincipalTextField_RepaymentsForEachPeriod.setFont(Constants.BASIC_FONT4);
			LoanPrincipalTextField_RepaymentsForEachPeriod.setForeground(Color.GRAY); 
			MainPanel.add(LoanPrincipalTextField_RepaymentsForEachPeriod);
			
			InsuranceFeeTextField_RepaymentsForEachPeriod = new JTextField();
			InsuranceFeeTextField_RepaymentsForEachPeriod.setBounds(350, 490, 180, 25);
			InsuranceFeeTextField_RepaymentsForEachPeriod.setBorder(Constants.LIGHT_GRAY_BORDER);
			InsuranceFeeTextField_RepaymentsForEachPeriod.setText("请输入保险费...");
			InsuranceFeeTextField_RepaymentsForEachPeriod.setFont(Constants.BASIC_FONT4);
			InsuranceFeeTextField_RepaymentsForEachPeriod.setForeground(Color.GRAY); 
			MainPanel.add(InsuranceFeeTextField_RepaymentsForEachPeriod);
			
			TreasureBoxFeeTextField_RepaymentsForEachPeriod = new JTextField();
			TreasureBoxFeeTextField_RepaymentsForEachPeriod.setBounds(540, 490, 180, 25);
			TreasureBoxFeeTextField_RepaymentsForEachPeriod.setBorder(Constants.LIGHT_GRAY_BORDER);
			TreasureBoxFeeTextField_RepaymentsForEachPeriod.setText("请输入百宝箱费用...");
			TreasureBoxFeeTextField_RepaymentsForEachPeriod.setFont(Constants.BASIC_FONT4);
			TreasureBoxFeeTextField_RepaymentsForEachPeriod.setForeground(Color.GRAY); 
			MainPanel.add(TreasureBoxFeeTextField_RepaymentsForEachPeriod);
			
			ComprehensiveInsuranceFeeTextField = new JTextField();
			ComprehensiveInsuranceFeeTextField.setBounds(160, 520, 275, 25);
			ComprehensiveInsuranceFeeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
			ComprehensiveInsuranceFeeTextField.setText("请输入全面保费用...");
			ComprehensiveInsuranceFeeTextField.setFont(Constants.BASIC_FONT4);
			ComprehensiveInsuranceFeeTextField.setForeground(Color.GRAY); 
			MainPanel.add(ComprehensiveInsuranceFeeTextField);
			
			ProductVersionCodeTextField_RepaymentsForEachPeriod = new JTextField();
			ProductVersionCodeTextField_RepaymentsForEachPeriod.setBounds(445, 520, 275, 25);
			ProductVersionCodeTextField_RepaymentsForEachPeriod.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductVersionCodeTextField_RepaymentsForEachPeriod.setText("请输入产品代码...");
			ProductVersionCodeTextField_RepaymentsForEachPeriod.setFont(Constants.BASIC_FONT4);
			ProductVersionCodeTextField_RepaymentsForEachPeriod.setForeground(Color.GRAY); 
			MainPanel.add(ProductVersionCodeTextField_RepaymentsForEachPeriod);
			
			MonthlyReturnFeeButton = new JButton("每月还款金额查询");
			MonthlyReturnFeeButton.setFont(Constants.BASIC_FONT4);
			MonthlyReturnFeeButton.setBounds(10, 550, 140, 25);
			MainPanel.add(MonthlyReturnFeeButton);
	
			LoanPrincipalTextField_MonthlyReturn = new JTextField();
			LoanPrincipalTextField_MonthlyReturn.setBounds(160, 550, 275, 25);
			LoanPrincipalTextField_MonthlyReturn.setBorder(Constants.LIGHT_GRAY_BORDER);
			LoanPrincipalTextField_MonthlyReturn.setText("请输入贷款本金...");
			LoanPrincipalTextField_MonthlyReturn.setFont(Constants.BASIC_FONT4);
			LoanPrincipalTextField_MonthlyReturn.setForeground(Color.GRAY); 
			MainPanel.add(LoanPrincipalTextField_MonthlyReturn);
			
			ProductVersionCodeTextField_MonthlyReturn = new JTextField();
			ProductVersionCodeTextField_MonthlyReturn.setBounds(445, 550, 275, 25);
			ProductVersionCodeTextField_MonthlyReturn.setBorder(Constants.LIGHT_GRAY_BORDER);
			ProductVersionCodeTextField_MonthlyReturn.setText("请输入产品代码...");
			ProductVersionCodeTextField_MonthlyReturn.setFont(Constants.BASIC_FONT4);
			ProductVersionCodeTextField_MonthlyReturn.setForeground(Color.GRAY); 
			MainPanel.add(ProductVersionCodeTextField_MonthlyReturn);
			
			MonthlyWeShouldAlsoPrincipalFeeButton = new JButton("每月应还本息查询");
			MonthlyWeShouldAlsoPrincipalFeeButton.setFont(Constants.BASIC_FONT4);
			MonthlyWeShouldAlsoPrincipalFeeButton.setBounds(10, 580, 140, 25);
			MainPanel.add(MonthlyWeShouldAlsoPrincipalFeeButton);
	
			ContractNumberTextField_MonthlyWeShouldAlsoPrincipal = new JTextField();
			ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setBounds(160, 580, 180, 25);
			ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setText("请输入合同号...");
			ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_MonthlyWeShouldAlsoPrincipal);
			
			MonthlyPayableFeeButton = new JButton("每月应付费用查询");
			MonthlyPayableFeeButton.setFont(Constants.BASIC_FONT4);
			MonthlyPayableFeeButton.setBounds(350, 580, 140, 25);
			MainPanel.add(MonthlyPayableFeeButton);
	
			ContractNumberTextField_MonthlyPayable = new JTextField();
			ContractNumberTextField_MonthlyPayable.setBounds(500, 580, 220, 25);
			ContractNumberTextField_MonthlyPayable.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_MonthlyPayable.setText("请输入合同号...");
			ContractNumberTextField_MonthlyPayable.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_MonthlyPayable.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_MonthlyPayable);
			
			MonthlyConsultingFeeAndRateButton = new JButton("月咨询及费率查询");
			MonthlyConsultingFeeAndRateButton.setFont(Constants.BASIC_FONT4);
			MonthlyConsultingFeeAndRateButton.setBounds(10, 610, 140, 25);
			MainPanel.add(MonthlyConsultingFeeAndRateButton);
	
			ContractNumberTextField_MonthlyConsulting = new JTextField();
			ContractNumberTextField_MonthlyConsulting.setBounds(160, 610, 180, 25);
			ContractNumberTextField_MonthlyConsulting.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_MonthlyConsulting.setText("请输入合同号...");
			ContractNumberTextField_MonthlyConsulting.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_MonthlyConsulting.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_MonthlyConsulting);
			
			MonthlyServiceFeeAndRateButton = new JButton("月服务及费率查询");
			MonthlyServiceFeeAndRateButton.setFont(Constants.BASIC_FONT4);
			MonthlyServiceFeeAndRateButton.setBounds(350, 610, 140, 25);
			MainPanel.add(MonthlyServiceFeeAndRateButton);
	
			ContractNumberTextField_MonthlyService = new JTextField();
			ContractNumberTextField_MonthlyService.setBounds(500, 610, 220, 25);
			ContractNumberTextField_MonthlyService.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_MonthlyService.setText("请输入合同号...");
			ContractNumberTextField_MonthlyService.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_MonthlyService.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_MonthlyService);
			
			MonthlyLoanInterestRateButton = new JButton("月贷款利率查询");
			MonthlyLoanInterestRateButton.setFont(Constants.BASIC_FONT4);
			MonthlyLoanInterestRateButton.setBounds(10, 640, 140, 25);
			MainPanel.add(MonthlyLoanInterestRateButton);
	
			ContractNumberTextField_MonthlyLoanInterestRate = new JTextField();
			ContractNumberTextField_MonthlyLoanInterestRate.setBounds(160, 640, 560, 25);
			ContractNumberTextField_MonthlyLoanInterestRate.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_MonthlyLoanInterestRate.setText("请输入合同号...");
			ContractNumberTextField_MonthlyLoanInterestRate.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_MonthlyLoanInterestRate.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_MonthlyLoanInterestRate);
			
			ContractStateUpdateButton = new JButton("合同状态修改");
			ContractStateUpdateButton.setFont(Constants.BASIC_FONT4);
			ContractStateUpdateButton.setBounds(10, 670, 140, 25);
			MainPanel.add(ContractStateUpdateButton);
	
			ContractNumberTextField_ContractStateUpdate = new JTextField();
			ContractNumberTextField_ContractStateUpdate.setBounds(160, 670, 275, 25);
			ContractNumberTextField_ContractStateUpdate.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_ContractStateUpdate.setText("请输入合同号...");
			ContractNumberTextField_ContractStateUpdate.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_ContractStateUpdate.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_ContractStateUpdate);
			
			ContractStateTextField_ContractStateUpdate = new JTextField();
			ContractStateTextField_ContractStateUpdate.setBounds(445, 670, 275, 25);
			ContractStateTextField_ContractStateUpdate.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractStateTextField_ContractStateUpdate.setText("请输入合同状态...");
			ContractStateTextField_ContractStateUpdate.setFont(Constants.BASIC_FONT4);
			ContractStateTextField_ContractStateUpdate.setForeground(Color.GRAY); 
			MainPanel.add(ContractStateTextField_ContractStateUpdate);
			
			ShortMessageSignatureCodeButton = new JButton("短签章验证码查询");
			ShortMessageSignatureCodeButton.setFont(Constants.BASIC_FONT4);
			ShortMessageSignatureCodeButton.setBounds(10, 700, 140, 25);
			MainPanel.add(ShortMessageSignatureCodeButton);
	
			PhoneNumberTextField_ShortMessageSignature = new JTextField();
			PhoneNumberTextField_ShortMessageSignature.setBounds(160, 700, 180, 25);
			PhoneNumberTextField_ShortMessageSignature.setBorder(Constants.LIGHT_GRAY_BORDER);
			PhoneNumberTextField_ShortMessageSignature.setText("请输入手机号...");
			PhoneNumberTextField_ShortMessageSignature.setFont(Constants.BASIC_FONT4);
			PhoneNumberTextField_ShortMessageSignature.setForeground(Color.GRAY); 
			MainPanel.add(PhoneNumberTextField_ShortMessageSignature);
			
			PDFSigningContractButton = new JButton("PDF签章合同查询");
			PDFSigningContractButton.setFont(Constants.BASIC_FONT4);
			PDFSigningContractButton.setBounds(350, 700, 140, 25);
			MainPanel.add(PDFSigningContractButton);
	
			ContractNumberTextField_PDFSigningContract = new JTextField();
			ContractNumberTextField_PDFSigningContract.setBounds(500, 700, 220, 25);
			ContractNumberTextField_PDFSigningContract.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_PDFSigningContract.setText("请输入合同号...");
			ContractNumberTextField_PDFSigningContract.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_PDFSigningContract.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_PDFSigningContract);
			
			SignatureRecordDeleteButton = new JButton("签章记录删除");
			SignatureRecordDeleteButton.setFont(Constants.BASIC_FONT4);
			SignatureRecordDeleteButton.setBounds(10, 730, 140, 25);
			MainPanel.add(SignatureRecordDeleteButton);
	
			ContractIDTextField_SignatureRecord = new JTextField();
			ContractIDTextField_SignatureRecord.setBounds(160, 730, 275, 25);
			ContractIDTextField_SignatureRecord.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractIDTextField_SignatureRecord.setText("请输入合同ID...");
			ContractIDTextField_SignatureRecord.setFont(Constants.BASIC_FONT4);
			ContractIDTextField_SignatureRecord.setForeground(Color.GRAY); 
			MainPanel.add(ContractIDTextField_SignatureRecord);
			
			ContractNumberTextField_SignatureRecord = new JTextField();
			ContractNumberTextField_SignatureRecord.setBounds(445, 730, 275, 25);
			ContractNumberTextField_SignatureRecord.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_SignatureRecord.setText("请输入合同号...");
			ContractNumberTextField_SignatureRecord.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_SignatureRecord.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_SignatureRecord);
			
			StoredProcedureExecutionButton = new JButton("存储过程执行");
			StoredProcedureExecutionButton.setFont(Constants.BASIC_FONT4);
			StoredProcedureExecutionButton.setBounds(10, 760, 140, 25);
			MainPanel.add(StoredProcedureExecutionButton);
	
			StoredProcedureNameTextField_StoredProcedureExecution = new JTextField();
			StoredProcedureNameTextField_StoredProcedureExecution.setBounds(160, 760, 180, 25);
			StoredProcedureNameTextField_StoredProcedureExecution.setBorder(Constants.LIGHT_GRAY_BORDER);
			StoredProcedureNameTextField_StoredProcedureExecution.setText("请输入存储过程名称...");
			StoredProcedureNameTextField_StoredProcedureExecution.setFont(Constants.BASIC_FONT4);
			StoredProcedureNameTextField_StoredProcedureExecution.setForeground(Color.GRAY); 
			MainPanel.add(StoredProcedureNameTextField_StoredProcedureExecution);
			
			ContractNumberTextField_StoredProcedureExecution = new JTextField();
			ContractNumberTextField_StoredProcedureExecution.setBounds(350, 760, 180, 25);
			ContractNumberTextField_StoredProcedureExecution.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractNumberTextField_StoredProcedureExecution.setText("请输入合同号...");
			ContractNumberTextField_StoredProcedureExecution.setFont(Constants.BASIC_FONT4);
			ContractNumberTextField_StoredProcedureExecution.setForeground(Color.GRAY); 
			MainPanel.add(ContractNumberTextField_StoredProcedureExecution);
			
			ContractIDTextField_StoredProcedureExecution = new JTextField();
			ContractIDTextField_StoredProcedureExecution.setBounds(540, 760, 180, 25);
			ContractIDTextField_StoredProcedureExecution.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractIDTextField_StoredProcedureExecution.setText("请输入合同ID...");
			ContractIDTextField_StoredProcedureExecution.setFont(Constants.BASIC_FONT4);
			ContractIDTextField_StoredProcedureExecution.setForeground(Color.GRAY); 
			MainPanel.add(ContractIDTextField_StoredProcedureExecution);
			
			ReimbursementPlanQueryButton = new JButton("还款计划表查询");
			ReimbursementPlanQueryButton.setFont(Constants.BASIC_FONT4);
			ReimbursementPlanQueryButton.setBounds(10, 790, 140, 25);
			MainPanel.add(ReimbursementPlanQueryButton);
	
			ContractIDTextField_ReimbursementPlan = new JTextField();
			ContractIDTextField_ReimbursementPlan.setBounds(160, 790, 410, 25);
			ContractIDTextField_ReimbursementPlan.setBorder(Constants.LIGHT_GRAY_BORDER);
			ContractIDTextField_ReimbursementPlan.setText("请输入合同ID...");
			ContractIDTextField_ReimbursementPlan.setFont(Constants.BASIC_FONT4);
			ContractIDTextField_ReimbursementPlan.setForeground(Color.GRAY); 
			MainPanel.add(ContractIDTextField_ReimbursementPlan);
			
			ReimbursementPlanDeleteButton = new JButton("还款计划表删除");
			ReimbursementPlanDeleteButton.setFont(Constants.BASIC_FONT4);
			ReimbursementPlanDeleteButton.setBounds(580, 790, 140, 25);
			MainPanel.add(ReimbursementPlanDeleteButton);
			
			contractLabel = new JLabel("合 同 号");
			contractLabel.setFont(Constants.BASIC_FONT);
			contractLabel.setBounds(730, 850, 70, 20);
			MainPanel.add(contractLabel);
			
			contractField = new JTextField();
			contractField.setBounds(800, 845, 240, 28);
			contractField.setBorder(Constants.LIGHT_GRAY_BORDER);
			contractField.setText("请输入合同号...");
			contractField.setFont(Constants.BASIC_FONT4);
			contractField.setForeground(Color.GRAY); 
			MainPanel.add(contractField);
				

			InquiryContractExpensesButton = new JButton("查询合同费用");
			InquiryContractExpensesButton.setFont(Constants.BASIC_FONT4);
			InquiryContractExpensesButton.setBounds(1060, 845, 120, 30);
			MainPanel.add(InquiryContractExpensesButton);
			
			SQLLabel = new JLabel("S  Q  L");
			MainPanel.add(SQLLabel);
			SQLLabel.setFont(Constants.BASIC_FONT);
			SQLLabel.setBounds(730, 920, 70, 20);
	
			SQLScroll = new JScrollPane();
			MainPanel.add(SQLScroll);
			SQLArea = new JTextArea();
			SQLArea.setTabSize(2);//TAB键多少位 
			SQLArea.setLineWrap(true);//激活自动换行功能
			SQLArea.setWrapStyleWord(true);//激活断行不断字功能
			SQLScroll.setBorder(Constants.LIGHT_GRAY_BORDER);
			SQLArea.setText("请输入SQL...");
			SQLArea.setFont(Constants.BASIC_FONT4);
			SQLArea.setForeground(Color.GRAY); 
			SQLScroll.setViewportView(SQLArea);
			SQLScroll.getVerticalScrollBar().setUI(new MyScrollBarUI());
			SQLScroll.setBounds(800, 900, 240, 60);
			
			SQLPromptLabel = new JLabel("查询数据过大时，请务必加入条件rownum<10000");
			MainPanel.add(SQLPromptLabel);
			SQLPromptLabel.setFont(Constants.BASIC_FONT);
			SQLPromptLabel.setBounds(800, 920, 240, 60);
			
			SQLButton = new JButton("查询SQL");
			SQLButton.setFont(Constants.BASIC_FONT4);
			SQLButton.setBounds(1060, 915, 120, 30);
			MainPanel.add(SQLButton);
			
			HangUpProcess = new JButton("挂起进程");
			HangUpProcess.setFont(Constants.BASIC_FONT4);
			HangUpProcess.setBounds(1780, 950, 90, 30);
			MainPanel.add(HangUpProcess);
		
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TODO 这个地方可以考虑，tray就只要一个，在主窗体出来之后换掉其上面的监听
	private void initTrayIcon() {
		if (SystemTray.isSupported()) {
			try {
				tray = SystemTray.getSystemTray();
				icon = new TrayIcon(PictureUtil.getPicture("jyb_icon.png").getImage(), "即有宝");
				icon.setImageAutoSize(true); //自动适应大小
				icon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						if (e.getButton() == MouseEvent.BUTTON1) {
							setVisible(true);
							//获取焦点
							requestFocus();
						}
					}
				});
				
				PopupMenu pm = new PopupMenu();
				MenuItem mit = new MenuItem("Exit");
				mit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						tray.remove(icon);
						System.exit(0);
					}
				});
				pm.add(mit);
				icon.setPopupMenu(pm);
				tray.add(icon);

			} catch (AWTException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void initFocusListener() {
					
		//挂起进程按钮事件
		HangUpProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				HangUpProcess.setBorder(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				HangUpProcess.setBorder(Constants.GRAY_BORDER);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});

		//用户信息查询输入框-焦点事件
		UserInfoTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				UserInfoTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(UserInfoTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					UserInfoTextField.setText("请输入用户ID...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				UserInfoTextField.setBorder(Constants.DARKGRAY_BORDER);
				UserInfoTextField.setText("");
			}	
		});
		
		//用户绑定门店信息查询输入框-焦点事件
		UserBoundStoreTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				UserBoundStoreTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(UserBoundStoreTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					UserBoundStoreTextField.setText("请输入用户ID...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				UserBoundStoreTextField.setBorder(Constants.DARKGRAY_BORDER);
				UserBoundStoreTextField.setText("");
			}	
		});		
		
		//城市绑定合同模式查询输入框-焦点事件
		CityBoundContractModeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CityBoundContractModeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(CityBoundContractModeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					CityBoundContractModeTextField.setText("请输入城市名称...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				CityBoundContractModeTextField.setBorder(Constants.DARKGRAY_BORDER);
				CityBoundContractModeTextField.setText("");
			}	
		});			
		
		//门店绑定商品类型查询输入框-焦点事件
		StoreBoundCommodityTypeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				StoreBoundCommodityTypeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(StoreBoundCommodityTypeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					StoreBoundCommodityTypeTextField.setText("请输入门店代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				StoreBoundCommodityTypeTextField.setBorder(Constants.DARKGRAY_BORDER);
				StoreBoundCommodityTypeTextField.setText("");
			}	
		});			
		
		//门店绑定产品版本查询输入框-焦点事件
		StoreBoundProductVersionTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				StoreBoundProductVersionTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(StoreBoundProductVersionTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					StoreBoundProductVersionTextField.setText("请输入门店代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				StoreBoundProductVersionTextField.setBorder(Constants.DARKGRAY_BORDER);
				StoreBoundProductVersionTextField.setText("");
			}	
		});				
		
		//产品版本代码输入框-焦点事件
		ProductVersionCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductVersionCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductVersionCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductVersionCodeTextField.setText("请输入产品版本代码,多个请以'?','?'隔开...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductVersionCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				ProductVersionCodeTextField.setText("");
			}	
		});			
		
		//产品注册代码输入框-焦点事件
		ProductRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductRegistrationCodeTextField.setText("请输入产品注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				ProductRegistrationCodeTextField.setText("");
			}	
		});			
		
		//合同模式输入框-焦点事件
		ContractModeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractModeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractModeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractModeTextField.setText("请输入合同模式...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractModeTextField.setBorder(Constants.DARKGRAY_BORDER);
				ContractModeTextField.setText("");
			}	
		});			
		
		//商品类型输入框-焦点事件
		CommodityTypeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CommodityTypeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(CommodityTypeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					CommodityTypeTextField.setText("请输入商品类型...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				CommodityTypeTextField.setBorder(Constants.DARKGRAY_BORDER);
				CommodityTypeTextField.setText("");
			}	
		});			
		
		//产品版本输入框-焦点事件
		ProductVersionTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductVersionTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductVersionTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductVersionTextField.setText("请输入产品版本...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductVersionTextField.setBorder(Constants.DARKGRAY_BORDER);
				ProductVersionTextField.setText("");
			}	
		});		
		
		//产品版本输入框-焦点事件
		ProductTypeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductTypeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductTypeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductTypeTextField.setText("请输入产品类型...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductTypeTextField.setBorder(Constants.DARKGRAY_BORDER);
				ProductTypeTextField.setText("");
			}	
		});			
		
		//首付比例输入框-焦点事件
		DownPaymentRatioTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				DownPaymentRatioTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(DownPaymentRatioTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					DownPaymentRatioTextField.setText("请输入首付比例...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				DownPaymentRatioTextField.setBorder(Constants.DARKGRAY_BORDER);
				DownPaymentRatioTextField.setText("");
			}	
		});			
		
		//产品状态输入框-焦点事件
		ProductStatusTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductStatusTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductStatusTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductStatusTextField.setText("请输入产品状态...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductStatusTextField.setBorder(Constants.DARKGRAY_BORDER);
				ProductStatusTextField.setText("");
			}	
		});			
		
		//保险-贷款本金输入框-焦点事件
		LoanPrincipalTextField_Insurance.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				LoanPrincipalTextField_Insurance.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(LoanPrincipalTextField_Insurance.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					LoanPrincipalTextField_Insurance.setText("请输入贷款本金...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				LoanPrincipalTextField_Insurance.setBorder(Constants.DARKGRAY_BORDER);
				LoanPrincipalTextField_Insurance.setText("");
			}	
		});			
		
		//保险费率输入框-焦点事件
		InsuranceRateTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				InsuranceRateTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(InsuranceRateTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					InsuranceRateTextField.setText("请输入保险费率...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				InsuranceRateTextField.setBorder(Constants.DARKGRAY_BORDER);
				InsuranceRateTextField.setText("");
			}	
		});			
		
		//保险-产品代码输入框-焦点事件
		ProductVersionCodeTextField_Insurance.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductVersionCodeTextField_Insurance.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductVersionCodeTextField_Insurance.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductVersionCodeTextField_Insurance.setText("请输入产品代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductVersionCodeTextField_Insurance.setBorder(Constants.DARKGRAY_BORDER);
				ProductVersionCodeTextField_Insurance.setText("");
			}	
		});			
		
		//百宝箱-贷款本金输入框-焦点事件
		LoanPrincipalTextField_TreasureBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				LoanPrincipalTextField_TreasureBox.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(LoanPrincipalTextField_TreasureBox.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					LoanPrincipalTextField_TreasureBox.setText("请输入贷款本金...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				LoanPrincipalTextField_TreasureBox.setBorder(Constants.DARKGRAY_BORDER);
				LoanPrincipalTextField_TreasureBox.setText("");
			}	
		});			
		
		//百宝箱费率输入框-焦点事件
		TreasureBoxRateTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				TreasureBoxRateTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(TreasureBoxRateTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					TreasureBoxRateTextField.setText("请输入百宝箱费率...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				TreasureBoxRateTextField.setBorder(Constants.DARKGRAY_BORDER);
				TreasureBoxRateTextField.setText("");
			}	
		});			
		
		//百宝箱-产品代码输入框-焦点事件
		ProductVersionCodeTextField_TreasureBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductVersionCodeTextField_TreasureBox.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductVersionCodeTextField_TreasureBox.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductVersionCodeTextField_TreasureBox.setText("请输入产品代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductVersionCodeTextField_TreasureBox.setBorder(Constants.DARKGRAY_BORDER);
				ProductVersionCodeTextField_TreasureBox.setText("");
			}	
		});			
		
		//商城赠券-贷款本金输入框-焦点事件
		LoanPrincipalTextField_MallCoupons.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				LoanPrincipalTextField_MallCoupons.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(LoanPrincipalTextField_MallCoupons.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					LoanPrincipalTextField_MallCoupons.setText("请输入贷款本金...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				LoanPrincipalTextField_MallCoupons.setBorder(Constants.DARKGRAY_BORDER);
				LoanPrincipalTextField_MallCoupons.setText("");
			}	
		});			
		
		//商城赠券费率输入框-焦点事件
		MallCouponsRateTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				MallCouponsRateTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(MallCouponsRateTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					MallCouponsRateTextField.setText("请输入商城赠券费率...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				MallCouponsRateTextField.setBorder(Constants.DARKGRAY_BORDER);
				MallCouponsRateTextField.setText("");
			}	
		});			
		
		//商城赠券-产品代码输入框-焦点事件
		ProductVersionCodeTextField_MallCoupons.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductVersionCodeTextField_MallCoupons.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductVersionCodeTextField_MallCoupons.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductVersionCodeTextField_MallCoupons.setText("请输入产品代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductVersionCodeTextField_MallCoupons.setBorder(Constants.DARKGRAY_BORDER);
				ProductVersionCodeTextField_MallCoupons.setText("");
			}	
		});			
		
		//每期应还费用-贷款本金输入框-焦点事件
		LoanPrincipalTextField_EachPeriodShouldBeReturned.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				LoanPrincipalTextField_EachPeriodShouldBeReturned.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(LoanPrincipalTextField_EachPeriodShouldBeReturned.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					LoanPrincipalTextField_EachPeriodShouldBeReturned.setText("请输入贷款本金...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				LoanPrincipalTextField_EachPeriodShouldBeReturned.setBorder(Constants.DARKGRAY_BORDER);
				LoanPrincipalTextField_EachPeriodShouldBeReturned.setText("");
			}	
		});			
		
		//每期应还费用-保险费输入框-焦点事件
		InsuranceFeeTextField_EachPeriodShouldBeReturned.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				InsuranceFeeTextField_EachPeriodShouldBeReturned.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(InsuranceFeeTextField_EachPeriodShouldBeReturned.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					InsuranceFeeTextField_EachPeriodShouldBeReturned.setText("请输入保险费...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				InsuranceFeeTextField_EachPeriodShouldBeReturned.setBorder(Constants.DARKGRAY_BORDER);
				InsuranceFeeTextField_EachPeriodShouldBeReturned.setText("");
			}	
		});			
		
		//每期应还费用-百宝箱费输入框-焦点事件
		TreasureBoxFeeTextField_EachPeriodShouldBeReturned.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(TreasureBoxFeeTextField_EachPeriodShouldBeReturned.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setText("请输入百宝箱费...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setBorder(Constants.DARKGRAY_BORDER);
				TreasureBoxFeeTextField_EachPeriodShouldBeReturned.setText("");
			}	
		});			
		
		//每期应还费用-产品代码费输入框-焦点事件
		ProductVersionCodeTextField_EachPeriodShouldBeReturned.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductVersionCodeTextField_EachPeriodShouldBeReturned.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductVersionCodeTextField_EachPeriodShouldBeReturned.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductVersionCodeTextField_EachPeriodShouldBeReturned.setText("请输入产品代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductVersionCodeTextField_EachPeriodShouldBeReturned.setBorder(Constants.DARKGRAY_BORDER);
				ProductVersionCodeTextField_EachPeriodShouldBeReturned.setText("");
			}	
		});			
		
		//全面保费用-贷款本金输入框-焦点事件
		LoanPrincipalTextField_ComprehensiveInsurance.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				LoanPrincipalTextField_ComprehensiveInsurance.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(LoanPrincipalTextField_ComprehensiveInsurance.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					LoanPrincipalTextField_ComprehensiveInsurance.setText("请输入贷款本金...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				LoanPrincipalTextField_ComprehensiveInsurance.setBorder(Constants.DARKGRAY_BORDER);
				LoanPrincipalTextField_ComprehensiveInsurance.setText("");
			}	
		});			
		
		//教育程度注册代码输入框-焦点事件
		EducationalLevelRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				EducationalLevelRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(EducationalLevelRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					EducationalLevelRegistrationCodeTextField.setText("请输入教育程度注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				EducationalLevelRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				EducationalLevelRegistrationCodeTextField.setText("");
			}	
		});			
		
		//住房情况注册代码输入框-焦点事件
		HousingSituationRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				HousingSituationRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(HousingSituationRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					HousingSituationRegistrationCodeTextField.setText("请输入住房情况注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				HousingSituationRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				HousingSituationRegistrationCodeTextField.setText("");
			}	
		});			
		
		//婚姻状况注册代码输入框-焦点事件
		MaritalStatusRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				MaritalStatusRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(MaritalStatusRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					MaritalStatusRegistrationCodeTextField.setText("请输入婚姻状况注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				MaritalStatusRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				MaritalStatusRegistrationCodeTextField.setText("");
			}	
		});			
		
		//行业类别注册代码输入框-焦点事件
		IndustryCategoryRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				IndustryCategoryRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(IndustryCategoryRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					IndustryCategoryRegistrationCodeTextField.setText("请输入行业类别注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				IndustryCategoryRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				IndustryCategoryRegistrationCodeTextField.setText("");
			}	
		});			
		
		//单位性质注册代码输入框-焦点事件
		UnitPropertiesRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				UnitPropertiesRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(UnitPropertiesRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					UnitPropertiesRegistrationCodeTextField.setText("请输入单位性质注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				UnitPropertiesRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				UnitPropertiesRegistrationCodeTextField.setText("");
			}	
		});			
		
		//职位信息注册代码输入框-焦点事件
		PositionRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				PositionRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(PositionRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					PositionRegistrationCodeTextField.setText("请输入职位信息注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				PositionRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				PositionRegistrationCodeTextField.setText("");
			}	
		});			
		
		//工作年限注册代码输入框-焦点事件
		WorkingLifeRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				WorkingLifeRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(WorkingLifeRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					WorkingLifeRegistrationCodeTextField.setText("请输入工作年限注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				WorkingLifeRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				WorkingLifeRegistrationCodeTextField.setText("");
			}	
		});				
		
		//支持银行注册代码输入框-焦点事件
		SupportBankRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				SupportBankRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(SupportBankRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					SupportBankRegistrationCodeTextField.setText("请输入支持银行注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				SupportBankRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				SupportBankRegistrationCodeTextField.setText("");
			}	
		});			
		
		//评定内部代码注册代码输入框-焦点事件
		EvaluationOfInternalCodeRegistrationCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				EvaluationOfInternalCodeRegistrationCodeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(EvaluationOfInternalCodeRegistrationCodeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					EvaluationOfInternalCodeRegistrationCodeTextField.setText("请输入评定内部注册代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				EvaluationOfInternalCodeRegistrationCodeTextField.setBorder(Constants.DARKGRAY_BORDER);
				EvaluationOfInternalCodeRegistrationCodeTextField.setText("");
			}	
		});		
		
		//短信征信授权验证码-手机号输入框-焦点事件
		PhoneNumberTextField_SMSAuthorizationAuthentication.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				PhoneNumberTextField_SMSAuthorizationAuthentication.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(PhoneNumberTextField_SMSAuthorizationAuthentication.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					PhoneNumberTextField_SMSAuthorizationAuthentication.setText("请输入手机号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				PhoneNumberTextField_SMSAuthorizationAuthentication.setBorder(Constants.DARKGRAY_BORDER);
				PhoneNumberTextField_SMSAuthorizationAuthentication.setText("");
			}	
		});		
		
		//客户合同-销售ID输入框-焦点事件
		SellingIDTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				SellingIDTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(SellingIDTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					SellingIDTextField.setText("请输入销售ID...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				SellingIDTextField.setBorder(Constants.DARKGRAY_BORDER);
				SellingIDTextField.setText("");
			}	
		});			
		
		//每期还款费用-贷款本金输入框-焦点事件
		LoanPrincipalTextField_RepaymentsForEachPeriod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				LoanPrincipalTextField_RepaymentsForEachPeriod.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(LoanPrincipalTextField_RepaymentsForEachPeriod.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					LoanPrincipalTextField_RepaymentsForEachPeriod.setText("请输入贷款本金...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				LoanPrincipalTextField_RepaymentsForEachPeriod.setBorder(Constants.DARKGRAY_BORDER);
				LoanPrincipalTextField_RepaymentsForEachPeriod.setText("");
			}	
		});			
		
		//每期还款费用-保险费输入框-焦点事件
		InsuranceFeeTextField_RepaymentsForEachPeriod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				InsuranceFeeTextField_RepaymentsForEachPeriod.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(InsuranceFeeTextField_RepaymentsForEachPeriod.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					InsuranceFeeTextField_RepaymentsForEachPeriod.setText("请输入保险费...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				InsuranceFeeTextField_RepaymentsForEachPeriod.setBorder(Constants.DARKGRAY_BORDER);
				InsuranceFeeTextField_RepaymentsForEachPeriod.setText("");
			}	
		});			
		
		//每期还款费用-百宝箱费用输入框-焦点事件
		TreasureBoxFeeTextField_RepaymentsForEachPeriod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				TreasureBoxFeeTextField_RepaymentsForEachPeriod.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(TreasureBoxFeeTextField_RepaymentsForEachPeriod.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					TreasureBoxFeeTextField_RepaymentsForEachPeriod.setText("请输入百宝箱费用...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				TreasureBoxFeeTextField_RepaymentsForEachPeriod.setBorder(Constants.DARKGRAY_BORDER);
				TreasureBoxFeeTextField_RepaymentsForEachPeriod.setText("");
			}	
		});		
		
		//每期还款费用-全面保费输入框-焦点事件
		ComprehensiveInsuranceFeeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ComprehensiveInsuranceFeeTextField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ComprehensiveInsuranceFeeTextField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ComprehensiveInsuranceFeeTextField.setText("请输入全面保费用...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ComprehensiveInsuranceFeeTextField.setBorder(Constants.DARKGRAY_BORDER);
				ComprehensiveInsuranceFeeTextField.setText("");
			}	
		});			
		
		//每期还款费用-产品代码输入框-焦点事件
		ProductVersionCodeTextField_RepaymentsForEachPeriod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductVersionCodeTextField_RepaymentsForEachPeriod.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductVersionCodeTextField_RepaymentsForEachPeriod.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductVersionCodeTextField_RepaymentsForEachPeriod.setText("请输入产品代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductVersionCodeTextField_RepaymentsForEachPeriod.setBorder(Constants.DARKGRAY_BORDER);
				ProductVersionCodeTextField_RepaymentsForEachPeriod.setText("");
			}	
		});			
		
		//每月还款额费用-贷款本金输入框-焦点事件
		LoanPrincipalTextField_MonthlyReturn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				LoanPrincipalTextField_MonthlyReturn.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(LoanPrincipalTextField_MonthlyReturn.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					LoanPrincipalTextField_MonthlyReturn.setText("请输入贷款本金...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				LoanPrincipalTextField_MonthlyReturn.setBorder(Constants.DARKGRAY_BORDER);
				LoanPrincipalTextField_MonthlyReturn.setText("");
			}	
		});			
		
		//每月还款额费用-产品代码输入框-焦点事件
		ProductVersionCodeTextField_MonthlyReturn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProductVersionCodeTextField_MonthlyReturn.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ProductVersionCodeTextField_MonthlyReturn.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ProductVersionCodeTextField_MonthlyReturn.setText("请输入产品代码...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ProductVersionCodeTextField_MonthlyReturn.setBorder(Constants.DARKGRAY_BORDER);
				ProductVersionCodeTextField_MonthlyReturn.setText("");
			}	
		});			
		
		//每月应还本息费用-每月应还本息费用输入框-焦点事件
		ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.setText("");
			}	
		});			
		
		//每月应付费用-合同号输入框-焦点事件
		ContractNumberTextField_MonthlyPayable.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_MonthlyPayable.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_MonthlyPayable.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_MonthlyPayable.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_MonthlyPayable.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_MonthlyPayable.setText("");
			}	
		});		
		
		//月咨询费及月咨询费率-合同号输入框-焦点事件
		ContractNumberTextField_MonthlyConsulting.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_MonthlyConsulting.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_MonthlyConsulting.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_MonthlyConsulting.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_MonthlyConsulting.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_MonthlyConsulting.setText("");
			}	
		});			
		
		//月服务费及月服务费率-合同号输入框-焦点事件
		ContractNumberTextField_MonthlyService.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_MonthlyService.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_MonthlyService.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_MonthlyService.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_MonthlyService.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_MonthlyService.setText("");
			}	
		});		
		
		//月贷款利率-合同号输入框-焦点事件
		ContractNumberTextField_MonthlyLoanInterestRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_MonthlyLoanInterestRate.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_MonthlyLoanInterestRate.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_MonthlyLoanInterestRate.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_MonthlyLoanInterestRate.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_MonthlyLoanInterestRate.setText("");
			}	
		});			
		
		//合同状态修改-合同号输入框-焦点事件
		ContractNumberTextField_ContractStateUpdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_ContractStateUpdate.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_ContractStateUpdate.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_ContractStateUpdate.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_ContractStateUpdate.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_ContractStateUpdate.setText("");
			}	
		});			
		
		//合同状态修改-合同状态输入框-焦点事件
		ContractStateTextField_ContractStateUpdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractStateTextField_ContractStateUpdate.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractStateTextField_ContractStateUpdate.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractStateTextField_ContractStateUpdate.setText("请输入合同状态...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractStateTextField_ContractStateUpdate.setBorder(Constants.DARKGRAY_BORDER);
				ContractStateTextField_ContractStateUpdate.setText("");
			}	
		});			
		
		//短信签章验证码-手机号输入框-焦点事件
		PhoneNumberTextField_ShortMessageSignature.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				PhoneNumberTextField_ShortMessageSignature.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(PhoneNumberTextField_ShortMessageSignature.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					PhoneNumberTextField_ShortMessageSignature.setText("请输入手机号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				PhoneNumberTextField_ShortMessageSignature.setBorder(Constants.DARKGRAY_BORDER);
				PhoneNumberTextField_ShortMessageSignature.setText("");
			}	
		});			
		
		//PDF签章合同-合同号输入框-焦点事件
		ContractNumberTextField_PDFSigningContract.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_PDFSigningContract.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_PDFSigningContract.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_PDFSigningContract.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_PDFSigningContract.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_PDFSigningContract.setText("");
			}	
		});			
		
		//签章记录删除-合同ID输入框-焦点事件
		ContractIDTextField_SignatureRecord.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractIDTextField_SignatureRecord.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractIDTextField_SignatureRecord.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractIDTextField_SignatureRecord.setText("请输入合同ID...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractIDTextField_SignatureRecord.setBorder(Constants.DARKGRAY_BORDER);
				ContractIDTextField_SignatureRecord.setText("");
			}	
		});		
		
		//签章记录删除-合同号输入框-焦点事件
		ContractNumberTextField_SignatureRecord.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_SignatureRecord.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_SignatureRecord.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_SignatureRecord.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_SignatureRecord.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_SignatureRecord.setText("");
			}	
		});		
		
		//存储过程名称输入框-焦点事件
		StoredProcedureNameTextField_StoredProcedureExecution.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				StoredProcedureNameTextField_StoredProcedureExecution.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(StoredProcedureNameTextField_StoredProcedureExecution.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					StoredProcedureNameTextField_StoredProcedureExecution.setText("请输入存储过程名称...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				StoredProcedureNameTextField_StoredProcedureExecution.setBorder(Constants.DARKGRAY_BORDER);
				StoredProcedureNameTextField_StoredProcedureExecution.setText("");
			}	
		});		
		
		//存储过程执行-合同号输入框-焦点事件
		ContractNumberTextField_StoredProcedureExecution.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractNumberTextField_StoredProcedureExecution.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractNumberTextField_StoredProcedureExecution.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractNumberTextField_StoredProcedureExecution.setText("请输入合同号...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractNumberTextField_StoredProcedureExecution.setBorder(Constants.DARKGRAY_BORDER);
				ContractNumberTextField_StoredProcedureExecution.setText("");
			}	
		});			
		
		//存储过程执行-合同ID输入框-焦点事件
		ContractIDTextField_StoredProcedureExecution.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractIDTextField_StoredProcedureExecution.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractIDTextField_StoredProcedureExecution.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractIDTextField_StoredProcedureExecution.setText("请输入合同ID...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractIDTextField_StoredProcedureExecution.setBorder(Constants.DARKGRAY_BORDER);
				ContractIDTextField_StoredProcedureExecution.setText("");
			}	
		});
		
		//还款计划表-合同ID输入框-焦点事件
		ContractIDTextField_ReimbursementPlan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ContractIDTextField_ReimbursementPlan.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(ContractIDTextField_ReimbursementPlan.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					ContractIDTextField_ReimbursementPlan.setText("请输入合同ID...");
				}	
			}
			@Override
			public void focusGained(FocusEvent e) {
				ContractIDTextField_ReimbursementPlan.setBorder(Constants.DARKGRAY_BORDER);
				ContractIDTextField_ReimbursementPlan.setText("");
			}	
		});	
		
		//合同号输入框焦点事件
		contractField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				contractField.setBorder(Constants.LIGHT_GRAY_BORDER);
				String contract_no = String.valueOf(contractField.getText());
				if (StringUtil2.isEmpty(contract_no)) {
					contractField.setText("请输入合同号...");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				contractField.setBorder(Constants.DARKGRAY_BORDER);
				contractField.setText("");
			}
		});

		//SQL输入框焦点事件
		SQLArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				SQLArea.setBorder(Constants.LIGHT_GRAY_BORDER);
				String SQL = String.valueOf(SQLArea.getText());
				if (StringUtil2.isEmpty(SQL)) {
					SQLArea.setText("请输入SQL...");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				SQLArea.setBorder(Constants.DARKGRAY_BORDER);
				SQLArea.setText("");
			}
		});		
		
	}
	
	private void initButtonEvent() {  
		
		//用户信息查询按钮-事件
		UserInfoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String User_ID = String.valueOf(UserInfoTextField.getText());

				if("请输入用户ID...".equals(User_ID)){
					JOptionPane.showMessageDialog(null, "请输入查询的用户ID！");
					return;
				}
				if (StringUtil2.UserIDcompare(DataVersion,User_ID)) {
					JOptionPane.showMessageDialog(null,"查询成功！");
					StringUtil2.UserInfoButton(DataVersion,User_ID);
				}
		    }
		});
		
//		//用户绑定门店信息查询输入框-事件
//		UserBoundStoreButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String User_ID = String.valueOf(UserBoundStoreTextField.getText());
//				// 验证
//				if("请输入用户ID...".equals(User_ID)){
//					JOptionPane.showMessageDialog(null, "请输入查询的用户ID！");
//					return;
//				}
//				if (StringUtil2.UserIDcompare(DataVersion,User_ID)) {
//					JOptionPane.showMessageDialog(null,"查询成功！");
//					StringUtil2.UserInfoButton(DataVersion,User_ID);
//				}
//		    }
//		});		
		
		//城市绑定合同模式查询按钮-事件
		CityBoundContractModeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String city = String.valueOf(CityBoundContractModeTextField.getText());

				if("请输入城市名称...".equals(city)){
					JOptionPane.showMessageDialog(null, "请输入城市名称！");
					return;
				}
				StringUtil2.CityBoundContractModeButton(DataVersion,city);
		    }
		});
		
//		//门店绑定商品类型查询按钮-事件
//		StoreBoundCommodityTypeButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String POS_CODE = String.valueOf(StoreBoundCommodityTypeTextField.getText());
//				// 验证
//				if("请输入门店代码...".equals(POS_CODE)){
//					JOptionPane.showMessageDialog(null, "请输入门店代码！");
//					return;
//				}
//				StringUtil2.StoreBoundCommodityTypeButton(DataVersion,POS_CODE);
//		    }
//		});		
		
		//门店绑定产品版本查询按钮-事件
		StoreBoundProductVersionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String POS_CODE = String.valueOf(StoreBoundProductVersionTextField.getText());

				if("请输入门店代码...".equals(POS_CODE)){
					JOptionPane.showMessageDialog(null, "请输入门店代码！");
					return;
				}
				StringUtil2.StoreBoundProductVersionButton(DataVersion,POS_CODE);
		    }
		});			
		
		//产品版本查询按钮-事件
		ProductVersionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String REG_VAL_CODE = String.valueOf(ProductVersionCodeTextField.getText());
				String REG_NUMBER = String.valueOf(ProductRegistrationCodeTextField.getText());

				if("请输入产品版本代码,多个请以'?','?'隔开...".equals(REG_VAL_CODE)){
					JOptionPane.showMessageDialog(null, "请输入产品版本代码！");
					return;
				}
				if("请输入产品注册代码...".equals(REG_NUMBER)){
					JOptionPane.showMessageDialog(null, "请输入产品注册代码！");
					return;
				}
				StringUtil2.ProductVersionButton(DataVersion,REG_VAL_CODE,REG_NUMBER);
		    }
		});			
		
		//产品信息查询按钮-事件
		ProductInformationButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String credit_model = String.valueOf(ContractModeTextField.getText());
				String GOODS_CA_ID = String.valueOf(CommodityTypeTextField.getText());
				String search_type = String.valueOf(ProductVersionTextField.getText());
				String prod_type = String.valueOf(ProductTypeTextField.getText());
				String INIT_PAY = String.valueOf(DownPaymentRatioTextField.getText());
				String STATUS = String.valueOf(ProductStatusTextField.getText());

				if("请输入合同模式..".equals(credit_model)){
					JOptionPane.showMessageDialog(null, "请输入合同模式！");
					return;
				}
				if("请输入商品类型...".equals(GOODS_CA_ID)){
					JOptionPane.showMessageDialog(null, "请输入商品类型！");
					return;
				}
				if("请输入产品版本...".equals(search_type)){
					JOptionPane.showMessageDialog(null, "请输入产品版本！");
					return;
				}
				if("请输入产品类型...".equals(prod_type)){
					JOptionPane.showMessageDialog(null, "请输入产品类型！");
					return;
				}
				if("请输入首付比例...".equals(INIT_PAY)){
					JOptionPane.showMessageDialog(null, "请输入首付比例！");
					return;
				}
				if("请输入产品状态...".equals(STATUS)){
					JOptionPane.showMessageDialog(null, "请输入产品状态！");
					return;
				}
				StringUtil2.ProductInformationButton(DataVersion,credit_model,GOODS_CA_ID,search_type,prod_type,INIT_PAY,STATUS);
		    }
		});			
		
		//保险及保险上限费用查询按钮-事件
		InsuranceFeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String LoanPrincipal = String.valueOf(LoanPrincipalTextField_Insurance.getText());
				String InsuranceRate = String.valueOf(InsuranceRateTextField.getText());
				String ProductVersionCode = String.valueOf(ProductVersionCodeTextField_Insurance.getText());
				
				if("请输入贷款本金...".equals(LoanPrincipal)){
					JOptionPane.showMessageDialog(null, "请输入贷款本金！");
					return;
				}
				if("请输入保险费率...".equals(InsuranceRate)){
					JOptionPane.showMessageDialog(null, "请输入保险费率！");
					return;
				}
				if("请输入产品代码...".equals(ProductVersionCode)){
					JOptionPane.showMessageDialog(null, "请输入产品代码！");
					return;
				}
				StringUtil2.InsuranceFeeButton(DataVersion,LoanPrincipal,InsuranceRate,ProductVersionCode);
		    }
		});		
		
		//百宝箱费用查询按钮-事件
		TreasureBoxFeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String LoanPrincipal = String.valueOf(LoanPrincipalTextField_TreasureBox.getText());
				String TreasureBoxRate = String.valueOf(TreasureBoxRateTextField.getText());
				String ProductVersionCode = String.valueOf(ProductVersionCodeTextField_TreasureBox.getText());
				
				if("请输入贷款本金...".equals(LoanPrincipal)){
					JOptionPane.showMessageDialog(null, "请输入贷款本金！");
					return;
				}
				if("请输入百宝箱费率...".equals(TreasureBoxRate)){
					JOptionPane.showMessageDialog(null, "请输入百宝箱费率！");
					return;
				}
				if("请输入产品代码...".equals(ProductVersionCode)){
					JOptionPane.showMessageDialog(null, "请输入产品代码！");
					return;
				}
				StringUtil2.TreasureBoxFeeButton(DataVersion,LoanPrincipal,TreasureBoxRate,ProductVersionCode);
		    }
		});			
		
		//商城赠券费用查询按钮-事件
		MallCouponsFeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String LoanPrincipal = String.valueOf(LoanPrincipalTextField_MallCoupons.getText());
				String MallCouponsRate = String.valueOf(MallCouponsRateTextField.getText());
				String ProductVersionCode = String.valueOf(ProductVersionCodeTextField_MallCoupons.getText());
				
				if("请输入贷款本金...".equals(LoanPrincipal)){
					JOptionPane.showMessageDialog(null, "请输入贷款本金！");
					return;
				}
				if("请输入商城赠券费率...".equals(MallCouponsRate)){
					JOptionPane.showMessageDialog(null, "请输入商城赠券费率！");
					return;
				}
				if("请输入产品代码...".equals(ProductVersionCode)){
					JOptionPane.showMessageDialog(null, "请输入产品代码！");
					return;
				}
				StringUtil2.MallCouponsFeeButton(DataVersion,LoanPrincipal,MallCouponsRate,ProductVersionCode);
		    }
		});				
		
		//每期应还费用查询按钮-事件
		EachPeriodShouldBeReturnedFeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String LoanPrincipal = String.valueOf(LoanPrincipalTextField_EachPeriodShouldBeReturned.getText());
				String InsuranceFee = String.valueOf(InsuranceFeeTextField_EachPeriodShouldBeReturned.getText());
				String TreasureBoxFee = String.valueOf(TreasureBoxFeeTextField_EachPeriodShouldBeReturned.getText());
				String ProductVersionCode = String.valueOf(ProductVersionCodeTextField_EachPeriodShouldBeReturned.getText());
				
				if("请输入贷款本金...".equals(LoanPrincipal)){
					JOptionPane.showMessageDialog(null, "请输入贷款本金！");
					return;
				}
				if("请输入保险费...".equals(InsuranceFee)){
					JOptionPane.showMessageDialog(null, "请输入保险费！");
					return;
				}
				if("请输入百宝箱费...".equals(ProductVersionCode)){
					JOptionPane.showMessageDialog(null, "请输入百宝箱费！");
					return;
				}
				if("请输入产品代码...".equals(ProductVersionCode)){
					JOptionPane.showMessageDialog(null, "请输入产品代码！");
					return;
				}
				StringUtil2.EachPeriodShouldBeReturnedFeeButton(DataVersion,LoanPrincipal,InsuranceFee,TreasureBoxFee,ProductVersionCode);
		    }
		});			
		
//		//全面保费用查询按钮-事件
//		EachPeriodShouldBeReturnedFeeButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String LoanPrincipal = String.valueOf(LoanPrincipalTextField_EachPeriodShouldBeReturned.getText());
//				String InsuranceFee = String.valueOf(InsuranceFeeTextField_EachPeriodShouldBeReturned.getText());
//				String TreasureBoxFee = String.valueOf(TreasureBoxFeeTextField_EachPeriodShouldBeReturned.getText());
//				String ProductVersionCode = String.valueOf(ProductVersionCodeTextField_EachPeriodShouldBeReturned.getText());
//				
//				if("请输入贷款本金...".equals(LoanPrincipal)){
//					JOptionPane.showMessageDialog(null, "请输入贷款本金！");
//					return;
//				}
//				if("请输入保险费...".equals(InsuranceFee)){
//					JOptionPane.showMessageDialog(null, "请输入保险费！");
//					return;
//				}
//				if("请输入百宝箱费...".equals(ProductVersionCode)){
//					JOptionPane.showMessageDialog(null, "请输入百宝箱费！");
//					return;
//				}
//				if("请输入产品代码...".equals(ProductVersionCode)){
//					JOptionPane.showMessageDialog(null, "请输入产品代码！");
//					return;
//				}
//				StringUtil2.EachPeriodShouldBeReturnedFeeButton(DataVersion,LoanPrincipal,InsuranceFee,TreasureBoxFee,ProductVersionCode);
//		    }
//		});			
		
		//教育程度查询按钮-事件
		EducationalLevelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String reg_number = String.valueOf(EducationalLevelRegistrationCodeTextField.getText());
//				
//				if("请输入教育程度注册代码...".equals(reg_number)){
//					JOptionPane.showMessageDialog(null, "请输入教育程度注册代码！");
//					return;
//				}
				StringUtil2.EducationalLevelButton(DataVersion,null);
		    }
		});		
		
		//住房情况查询按钮-事件
		HousingSituationButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String reg_number = String.valueOf(HousingSituationRegistrationCodeTextField.getText());
//				
//				if("请输入住房情况注册代码...".equals(reg_number)){
//					JOptionPane.showMessageDialog(null, "请输入住房情况注册代码！");
//					return;
//				}
				StringUtil2.HousingSituationButton(DataVersion,null);
		    }
		});			
		
		//婚姻状况查询按钮-事件
		MaritalStatusButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String reg_number = String.valueOf(MaritalStatusRegistrationCodeTextField.getText());
//				
//				if("请输入婚姻状况注册代码...".equals(reg_number)){
//					JOptionPane.showMessageDialog(null, "请输入婚姻状况注册代码！");
//					return;
//				}
				StringUtil2.MaritalStatusButton(DataVersion,null);
		    }
		});			
		
		//行业类别查询按钮-事件
		IndustryCategoryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String reg_number = String.valueOf(IndustryCategoryRegistrationCodeTextField.getText());
//				
//				if("请输入行业类别注册代码...".equals(reg_number)){
//					JOptionPane.showMessageDialog(null, "请输入行业类别注册代码！");
//					return;
//				}
				StringUtil2.IndustryCategoryButton(DataVersion,null);
		    }
		});		
		
		//单位性质查询按钮-事件
		UnitPropertiesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String reg_number = String.valueOf(UnitPropertiesRegistrationCodeTextField.getText());
//				
//				if("请输入单位性质注册代码...".equals(reg_number)){
//					JOptionPane.showMessageDialog(null, "请输入单位性质注册代码！");
//					return;
//				}
				StringUtil2.UnitPropertiesButton(DataVersion,null);
		    }
		});			
		
		//职位查询按钮-事件
		PositionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String reg_number = String.valueOf(PositionRegistrationCodeTextField.getText());
//				
//				if("请输入职位注册代码...".equals(reg_number)){
//					JOptionPane.showMessageDialog(null, "请输入职位注册代码！");
//					return;
//				}
				StringUtil2.PositionButton(DataVersion,null);
		    }
		});		
		
		//工作年限查询按钮-事件
		WorkingLifeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
//				String reg_number = String.valueOf(WorkingLifeRegistrationCodeTextField.getText());
//				
//				if("请输入工作年限注册代码...".equals(reg_number)){
//					JOptionPane.showMessageDialog(null, "请输入工作年限注册代码！");
//					return;
//				}
				StringUtil2.WorkingLifeButton(DataVersion,null);
		    }
		});			
		
//		//支持银行查询按钮-事件
//		SupportBankButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
////				String reg_number = String.valueOf(SupportBankRegistrationCodeTextField.getText());
////				
////				if("请输入支持银行注册代码...".equals(reg_number)){
////					JOptionPane.showMessageDialog(null, "请输入支持银行注册代码！");
////					return;
////				}
//				StringUtil2.SupportBankButton(DataVersion,null);
//		    }
//		});			
		
//		//评定内部代码查询按钮-事件
//		EvaluationOfInternalCodeButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
////				String reg_number = String.valueOf(EvaluationOfInternalCodeRegistrationCodeTextField.getText());
////				
////				if("请输入评定内部注册代码...".equals(reg_number)){
////					JOptionPane.showMessageDialog(null, "请输入评定内部注册代码！");
////					return;
////				}
//				StringUtil2.EvaluationOfInternalCodeButton(DataVersion,null);
//		    }
//		});			
		
		//短信征信授权验证码查询按钮-事件
		SMSAuthorizationAuthenticationCodeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String mobile = String.valueOf(PhoneNumberTextField_SMSAuthorizationAuthentication.getText());
				
				if("请输入手机号...".equals(mobile)){
					JOptionPane.showMessageDialog(null, "请输入手机号！");
					return;
				}
				StringUtil2.SMSAuthorizationAuthenticationCodeButton(DataVersion,mobile);
		    }
		});		
		
		//客户合同查询按钮-事件
		CustomerContractButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ID_SA = String.valueOf(SellingIDTextField.getText());
				
				if("请输入销售ID...".equals(ID_SA)){
					JOptionPane.showMessageDialog(null, "请输入销售ID！");
					return;
				}
				StringUtil2.CustomerContractButton(DataVersion,ID_SA);
		    }
		});			
		
		//每期还款费用查询按钮-事件
		RepaymentsForEachPeriodFeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String LoanPrincipal = String.valueOf(LoanPrincipalTextField_RepaymentsForEachPeriod.getText());
				String InsuranceFee = String.valueOf(InsuranceFeeTextField_RepaymentsForEachPeriod.getText());
				String TreasureBoxFee = String.valueOf(TreasureBoxFeeTextField_RepaymentsForEachPeriod.getText());
				String ComprehensiveInsuranceFee = String.valueOf(ComprehensiveInsuranceFeeTextField.getText());
				String ProductVersionCode = String.valueOf(ProductVersionCodeTextField_RepaymentsForEachPeriod.getText());
				
				if("请输入贷款本金...".equals(LoanPrincipal)){
					JOptionPane.showMessageDialog(null, "请输入贷款本金！");
					return;
				}
				if("请输入保险费...".equals(InsuranceFee)){
					JOptionPane.showMessageDialog(null, "请输入保险费！");
					return;
				}
				if("请输入百宝箱费用...".equals(TreasureBoxFee)){
					JOptionPane.showMessageDialog(null, "请输入百宝箱费用！");
					return;
				}
				if("请输入全面保费用...".equals(ComprehensiveInsuranceFee)){
					JOptionPane.showMessageDialog(null, "请输入全面保费用！");
					return;
				}
				if("请输入产品代码...".equals(ProductVersionCode)){
					JOptionPane.showMessageDialog(null, "请输入产品代码！");
					return;
				}
				StringUtil2.RepaymentsForEachPeriodFeeButton(DataVersion,LoanPrincipal,InsuranceFee,TreasureBoxFee,ComprehensiveInsuranceFee,ProductVersionCode);
		    }
		});			
		
		//每月还款金额查询按钮-事件
		MonthlyReturnFeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String LoanPrincipal = String.valueOf(LoanPrincipalTextField_MonthlyReturn.getText());
				String ProductVersionCode = String.valueOf(ProductVersionCodeTextField_MonthlyReturn.getText());
				
				if("请输入贷款本金...".equals(LoanPrincipal)){
					JOptionPane.showMessageDialog(null, "请输入贷款本金！");
					return;
				}
				if("请输入产品代码...".equals(ProductVersionCode)){
					JOptionPane.showMessageDialog(null, "请输入产品代码！");
					return;
				}
				StringUtil2.MonthlyReturnFeeButton(DataVersion,LoanPrincipal,ProductVersionCode);
		    }
		});			
		
		//每月应还本息费用查询按钮-事件
		MonthlyWeShouldAlsoPrincipalFeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractNumber = String.valueOf(ContractNumberTextField_MonthlyWeShouldAlsoPrincipal.getText());
				
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				StringUtil2.MonthlyWeShouldAlsoPrincipalFeeButton(DataVersion,ContractNumber);
		    }
		});		
		
		//每月应付费用查询按钮-事件
		MonthlyPayableFeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractNumber = String.valueOf(ContractNumberTextField_MonthlyPayable.getText());
				
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				StringUtil2.MonthlyPayableFeeButton(DataVersion,ContractNumber);
		    }
		});		
		
		//月咨询费及月咨询费率查询按钮-事件
		MonthlyConsultingFeeAndRateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractNumber = String.valueOf(ContractNumberTextField_MonthlyConsulting.getText());
				
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				StringUtil2.MonthlyConsultingFeeAndRateButton(DataVersion,ContractNumber);
		    }
		});		
		
		//月服务费及月服务费率查询按钮-事件
		MonthlyServiceFeeAndRateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractNumber = String.valueOf(ContractNumberTextField_MonthlyService.getText());
				
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				StringUtil2.MonthlyServiceFeeAndRateButton(DataVersion,ContractNumber);
		    }
		});			
		
		//月贷款利率查询按钮-事件
		MonthlyLoanInterestRateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractNumber = String.valueOf(ContractNumberTextField_MonthlyLoanInterestRate.getText());
				
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				StringUtil2.MonthlyLoanInterestRateButton(DataVersion,ContractNumber);
		    }
		});		
		
		//合同状态修改按钮-事件
		ContractStateUpdateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractNumber = String.valueOf(ContractNumberTextField_ContractStateUpdate.getText());
				String ContractState = String.valueOf(ContractStateTextField_ContractStateUpdate.getText());
				
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				if("请输入合同状态...".equals(ContractState)){
					JOptionPane.showMessageDialog(null, "请输入合同状态！");
					return;
				}
				StringUtil2.ContractStateUpdateButton(DataVersion,ContractNumber,ContractState);
		    }
		});		
		
		//短信签章验证码查询按钮-事件
		ShortMessageSignatureCodeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String mobile = String.valueOf(PhoneNumberTextField_ShortMessageSignature.getText());
				
				if("请输入手机号...".equals(mobile)){
					JOptionPane.showMessageDialog(null, "请输入手机号！");
					return;
				}
				StringUtil2.ShortMessageSignatureCodeButton(DataVersion,mobile);
		    }
		});		
		
		//PDF签章合同查询按钮-事件
		PDFSigningContractButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractNumber = String.valueOf(ContractNumberTextField_PDFSigningContract.getText());
				
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				StringUtil2.PDFSigningContractButton(DataVersion,ContractNumber);
		    }
		});		
		
		//签章记录删除按钮-事件
		SignatureRecordDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractID = String.valueOf(ContractIDTextField_SignatureRecord.getText());
				String ContractNumber = String.valueOf(ContractNumberTextField_SignatureRecord.getText());
				
				if("请输入合同ID...".equals(ContractID)){
					JOptionPane.showMessageDialog(null, "请输入合同ID！");
					return;
				}
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				try {
					StringUtil2.SignatureRecordDeleteButton(DataVersion,ContractID,ContractNumber);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }
		});			
		
		//存储过程执行按钮-事件
		StoredProcedureExecutionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String StoredProcedureName = String.valueOf(StoredProcedureNameTextField_StoredProcedureExecution.getText());
				String ContractNumber = String.valueOf(ContractNumberTextField_StoredProcedureExecution.getText());
				String ContractID = String.valueOf(ContractIDTextField_StoredProcedureExecution.getText());
				
				if("请输入存储过程名称...".equals(StoredProcedureName)){
					JOptionPane.showMessageDialog(null, "请输入存储过程名称！");
					return;
				}
				if("请输入合同号...".equals(ContractNumber)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				if("请输入合同ID...".equals(ContractID)){
					JOptionPane.showMessageDialog(null, "请输入合同ID！");
					return;
				}
				StringUtil2.StoredProcedureExecutionButton(DataVersion,StoredProcedureName,ContractNumber,ContractID);
		    }
		});			
		
		//还款计划表查询按钮-事件
		ReimbursementPlanQueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractID = String.valueOf(ContractIDTextField_ReimbursementPlan.getText());

				if("请输入合同ID...".equals(ContractID)){
					JOptionPane.showMessageDialog(null, "请输入合同ID！");
					return;
				}
				StringUtil2.ReimbursementPlanQueryButton(DataVersion,ContractID);
		    }
		});			
		
		//还款计划表删除按钮-事件
		ReimbursementPlanDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String ContractID = String.valueOf(ContractIDTextField_ReimbursementPlan.getText());

				if("请输入合同ID...".equals(ContractID)){
					JOptionPane.showMessageDialog(null, "请输入合同ID！");
					return;
				}
				try {
					StringUtil2.ReimbursementPlanDeleteButton(DataVersion,ContractID);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    }
		});	
		
		//查询合同费用详情按钮-事件
		InquiryContractExpensesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String contract_no = String.valueOf(contractField.getText());
				
				if("请输入合同号...".equals(contract_no)){
					JOptionPane.showMessageDialog(null, "请输入合同号！");
					return;
				}
				if (StringUtil2.contractcompare(DataVersion,contract_no)) {
					JOptionPane.showMessageDialog(null,"查询成功！");
				}
				StringUtil2.InquiryContractExpensesButton(DataVersion,contract_no);
		    }
		});	

		//查询SQL详情按钮-事件
		SQLButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String DataVersion = databasetools.ui.frame.LoginWindow.DataVersionBox.getSelectedItem().toString();
				String Sql = String.valueOf(SQLArea.getText());
				
				if("请输入SQL...".equals(Sql)){
					JOptionPane.showMessageDialog(null, "请输入SQL！");
					return;
				}
				if (StringUtil2.isEmpty1(Sql)) {
					JOptionPane.showMessageDialog(null,"查询成功！");
				}
		        StringUtil2.SQLButton(DataVersion,Sql);
		    }
		});			
	}	
}
