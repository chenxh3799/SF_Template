package cn.org.sino_life.generator;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author sino-life
 */

public class GeneratorMain {
	
	/**
	 * 通过数据库表生成文件,sf_new_20110928为模板的根目录
	 * 
	 * @throws Exception
	 */
	public static void generateByTable(GeneratorFacade g, String template)
			throws Exception {
		for (String string : initList()) {
			g.generateByTable(string, template); // 通过数据库表生成文件,template为模板的根目录

		}
	}
	
	public static void generateByProcedure(GeneratorFacade g,String procedureName,String template) throws Exception{
		g.generateByProcedure(procedureName, template);//通过存储过程生成文件
	}

	
	/**
	 * 需要生成的表加如list中,可以批量生成，也可以单表生成
	 * 
	 * @return
	 */
	public static List<String> initList(){
		List<String> list = new ArrayList<String>();
		//list.add("bid_project");
//		list.add("BID_PROJECT_TYPE");
//		list.add("BID_PROJECT_STATUS");
//		list.add("BID_FILE_TYPE");
//		list.add("BID_DING_WAY");
//		list.add("BID_VAL_METHODS");
//		list.add("BID_TENDEREE_STATUS");
//		list.add("BID_BIDDER_STATUS");
//		list.add("BID_JUDGE_STATUS");
//		list.add("BID_QUA_GRADE");
//		list.add("BID_MAIL_TYPE");
//		list.add("BID_PROJECT");
//		list.add("BID_TENDEREE_DEPT");
//		list.add("BID_TENDEREE");
//		list.add("BID_TENDEREE_LIBRARY");
//		list.add("BID_BIDDER");
//		list.add("BID_EVALUATION_GROUP");
//		list.add("BID_EXPERT_SCORE");
//		list.add("BID_SUPPLIER");
//		list.add("BID_SUPPLIER_CONTACT");
//		list.add("BID_SUPPLIER_PROJECTTYPE");
//		list.add("BID_EXPERT");
//		list.add("BID_EXPERT_FIELD");
//		list.add("BID_ANS_QUE");
//		list.add("BID_ATTACH_BATCH");
//		list.add("BID_ATTACH_DETAIL");
//		list.add("BID_ATTACH_DOWNLOAD");
//		list.add("BID_CONFIG");
//		list.add("BID_MSG_TEMPLATE");
		list.add("PPSP_ASYNCHRONOUS_TASK");
		//list.add("ORDER_PREM");
//		
		
//		list.add("BID_APPROVE_LOG");
//		list.add("BID_LOGIN_LOG");
//		list.add("BID_PROJECT_TMP");
//		list.add("BID_TENDEREE_DEPT_TMP");
//		list.add("BID_BIDDER_TMP");

//        list.add("CF_CALLBACK_STATUS");
//        list.add("CF_CALLBACK_TYPE");
//        list.add("CF_CALL_WAY");
//        list.add("CF_CASE_TYPE");
//        list.add("CF_CHECKER_IND");
//        list.add("CF_CLAIM_STATUS");
//        list.add("CF_CLIENT_TYPE");
//        list.add("CF_CONTACT_TYPE");
//        list.add("CF_DAMAGE_AREA_CODE");
//        list.add("CF_DAMAGE_CODE");
//        list.add("CF_DELEGATE_IND");
//        list.add("CF_DELEGATE_STATUS");
//        list.add("CF_DELEGATE_TYPE");
//        list.add("CF_DISPATCH_STATUS");
//        list.add("CF_EDUCATION");
//        list.add("CF_ENSURE_DEFAULT_LINK");
//        list.add("CF_FUNCTION_TYPE");
//        list.add("CF_IDENTIFY_TYPE_CORPORATE");
//        list.add("CF_IDENTIFY_TYPE_PERSONA");
//        list.add("CF_INDEMNITY_DUTY");
//        list.add("CF_INJURED_IND");
//        list.add("CF_LINDICATOR");
//        list.add("CF_LOSS_ADDRESS_TYPE");
//        list.add("CF_LOSS_ITEM_TYPES");
//        list.add("CF_LOSS_PAGE_TYPE");
//        list.add("CF_LOSS_TYPE");
//        list.add("CF_OBJECT_TYPE");
//        list.add("CF_PAYMENT_MODE");
//        list.add("CF_QUESTIONNAIRE_TYPE");
//        list.add("CF_REGISTER_STATUS");
//        list.add("CF_REGISTER_TYPE");
//        list.add("CF_REPORT_TYPE");
//        list.add("CF_SERVICE_SCORE");
//        list.add("CF_SMS_MARK_IND");
//        list.add("CF_SMS_TYPE");
//        list.add("CF_SRESCUE_TYPE_CODE");
//        list.add("CF_SUBJECT_TYPE");
//        list.add("CF_SYSTEM_CODE");
		
//      list.add("CG_ICCONFIG");
//      list.add("CG_ICUSERCODE");
//      list.add("CG_AGENTSATION");
//      list.add("CG_AREA_DEFINE");
//      list.add("CG_CITY");
//      list.add("CG_COUNTRY");
//      list.add("CG_PROVINCE");
//      list.add("CG_CHECKERAREA");
//      list.add("CG_CHECKERRISK");
//      list.add("CG_CHECKERSKILL");
//      list.add("CG_KEYWORD");
//      list.add("CG_KEYWORDCONFIG");
//      list.add("CG_POLICYINFO");
		
      //list.add("cg_keyword");
//		list.add("MQ_MAIN");
//		list.add("MQ_MOTOR");
//		list.add("MQ_RISK");
//		list.add("MQ_RISKKIND");
//		list.add("MQ_TAX");
//		list.add("MP_MAIN");
//		list.add("MP_MOTOR");
//		list.add("MP_RISK");
//		list.add("MP_RISKKIND");
//		list.add("MP_TAX");
//		list.add("MP_PROPOSAL_ACCOUNT");
//		list.add("MP_IMAGES");
//		list.add("Mq_Main");
//		list.add("Mq_Risk");
//		list.add("Mq_Motor");
//		list.add("Mq_RiskKind");
//		list.add("Mq_Tax");
//		list.add("Mp_Main");
//		list.add("Mp_Risk");
//		list.add("Mp_Motor");
//		list.add("Mp_RiskKind");
//		list.add("Mp_Tax");

		
//      问卷话术维护Cb_QuestionnaireMain、Cb_QuestionnaireDetail
//      问卷话术关系维护（机构、险种）Cg_QuestTemplateRelation
//      关键字定义Cg_Keyword
//      关键字关联Cg_KeywordConfig
//   2、查勘员管理
//      查勘员维护Cd_Checker 
//      查勘员区域关系Cg_CheckerArea
//      查勘员险种关系Cg_CheckerRisk
//      查勘员技能关系Cg_CheckerSkill
//   3、客户信息维护Cm_Client
//   4、IC管理
//      IC员工关系Cg_Icusercode
//      分机号存储Cg_agentSation
//   5、救援单位表Cg_RescueCompany

		return list;
	}
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * 有三点需要引起特别的注意 
		 * (1)数据库连接等一些配置在generator.xml中进行配置
		 * (2)表无主键，无法生成 
		 * (3)外键关联的表无读权限，无法生成
		 */
		GeneratorFacade g = new GeneratorFacade();
		generateByTable(g, "sf_new_20110928");// 新框架下的模板sf_new_20110928
		//打开文件夹
		Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
