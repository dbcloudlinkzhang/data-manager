package com.boot.security.server.controller;

import com.boot.security.server.annotation.LogAnnotation;
import com.boot.security.server.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"excel下载"})
@RestController
@RequestMapping({"/excels"})
public class ExcelController
{
  private static final Logger log = LoggerFactory.getLogger("adminLogger");
  @Autowired
  private JdbcTemplate jdbcTemplate;
  public static void main(String[] args) {
	  String zf = "正厅";
	  if(zf !=null && (zf.contains("正厅")|| zf.contains("副厅")))
	  {
		  System.out.println("我就是这么厉害");
	  }
	System.out.println("正厅".contains("正厅"));
	
	
}
  @ApiOperation("校验sql，并返回sql返回的数量")
  @PostMapping({"/sql-count"})
  public Integer checkSql(String startTime, String endTime)
  {
    String sql = getAndCheckSql(startTime, endTime);
    Integer count = Integer.valueOf(0);
    try
    {
      count = (Integer)this.jdbcTemplate.queryForObject("select count(1) from (" + sql + ") t", Integer.class);
    }
    catch (Exception e)
    {
      log.error(e.getMessage());
      throw new IllegalArgumentException(e.getMessage());
    }
    return count;
  }
  
  private String getAndCheckSql(String startTime, String endTime)
  {
    String sql = "SELECT id,datetime,league,homename,awayname ,'' as times,finshscore,finshgoal,halfscore,halfgoal,doubletime,doublescore,doublegoal\n,doubletype,CONCAT('预计全场进球【',castscore,'】或以上') as casescore,smallrate,position,bigrate\nFROM playdata.T008_REALTIME_BETSAPI  where datetime >='" + 
    
      startTime + "'\n" + 
      " and datetime <='" + endTime + "'" + 
      "order by datetime desc";
    return sql;
  }
  /**
   * 红卡导出标题
  * @Title: getHeaderRed 
  * @Description: TODO(这里用一句话描述这个方法的作用) 
  * @param @return    设定文件 
  * @return List<String>    返回类型 
  * @throws
   */
  private static List<String> getHeaderRed()
	{
		List<String> headers = new ArrayList<String>();
		headers.add("联赛");
		headers.add("主队");
		headers.add("客队");
		headers.add("比赛时间");
		headers.add("半场比分");
		headers.add("全场比分");
		headers.add("大球");
		headers.add("盘口");
		headers.add("小球");
		headers.add("红卡");
		headers.add("红卡比分");
		headers.add("红开后进球");
		headers.add("红卡时间");
		headers.add("进球时间");
		headers.add("主角球");
		headers.add("客角球");
		headers.add("主进攻");
		headers.add("客进攻");
		headers.add("主危险进攻");
		headers.add("客危险进攻");
		headers.add("主射正球门");
		headers.add("客射正球门");
		headers.add("主射偏球们");
		headers.add("客射偏球们");
		headers.add("主球权");
		headers.add("客球权");
		return headers;
		
	}
  private static List<String> getHeader()
  {
    List<String> headers = new ArrayList();
    headers.add("比赛时间");
    headers.add("联赛");
    headers.add("主队");
    headers.add("客队");
    headers.add("主队必发");
    headers.add("平必发");
    headers.add("客队必发");
    headers.add("主队成交");
    headers.add("平成交");
    headers.add("客队成交");
    headers.add("主队比例");
    headers.add("平比例");
    headers.add("客队比例");
    headers.add("主队盈亏");
    headers.add("平盈亏");
    headers.add("客队盈亏");
    headers.add("主队价位");
    headers.add("平价位");
    headers.add("客价位");
    
    headers.add("大球成交");
    headers.add("小球成交");
    headers.add("大球比例");
    headers.add("小球比例");
    headers.add("大球价位");
    headers.add("小球价位");
    headers.add("大球必发");
    headers.add("小球必发");
    
    headers.add("亚盘");
    headers.add("亚盘指数");
    
    headers.add("标盘总成交");
    headers.add("大小球总成交");
    headers.add("EVENTID");
    headers.add("现场-主队必发");
    headers.add("现场-平必发");
    headers.add("现场-客队必发");
    headers.add("现场-主队成交");
    headers.add("现场-平成交");
    headers.add("现场-客队成交");
    headers.add("现场-主队比例");
    headers.add("现场-平比例");
    headers.add("现场-客队比例");
    headers.add("现场-主队盈亏");
    headers.add("现场-平盈亏");
    headers.add("现场-客队盈亏");
    headers.add("现场-主队价位");
    headers.add("现场-平价位");
    headers.add("现场-客价位");
    
    headers.add("现场-大球成交");
    headers.add("现场-小球成交");
    headers.add("现场-大球比例");
    headers.add("现场-小球比例");
    headers.add("现场-大球价位");
    headers.add("现场-小球价位");
    headers.add("现场-大球必发");
    headers.add("现场-小球必发");
    
    headers.add("现场-亚盘");
    headers.add("现场-现场-亚盘指数");
    headers.add("现场-表盘总成交");
    headers.add("现场-大小球总成交");
    headers.add("主队进球");
    headers.add("客队进球");
    headers.add("标盘超限");
    headers.add("大小球超限");
    
    headers.add("标盘大注");
    headers.add("方向1");
    headers.add("总金额1");
    headers.add("单价1");
    headers.add("属性1");
    headers.add("交易占比1");
    headers.add("发生时间1");
    headers.add("方向2");
    headers.add("总金额2");
    headers.add("单价2");
    headers.add("属性2");
    headers.add("交易占比2");
    headers.add("发生时间2");
    headers.add("方向3");
    headers.add("总金额3");
    headers.add("单价3");
    headers.add("属性3");
    headers.add("交易占比3");
    headers.add("发生时间3");
    
    headers.add("大小球大注");
    headers.add("方向1");
    headers.add("总金额1");
    headers.add("单价1");
    headers.add("属性1");
    headers.add("交易占比1");
    headers.add("发生时间1");
    headers.add("方向2");
    headers.add("总金额2");
    headers.add("单价2");
    headers.add("属性2");
    headers.add("交易占比2");
    headers.add("发生时间2");
    headers.add("方向3");
    headers.add("总金额3");
    headers.add("单价3");
    headers.add("属性3");
    headers.add("交易占比3");
    headers.add("发生时间3");
    return headers;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  private String xcAndCheckSql(String startTime, String endTime)
  {
    String sql = "        SELECT DATE_TIME,LAUGE,HOMENAME,AWAYNAME  ,B.BfIndexHome,B.BfIndexDraw,B.BfIndexAway ,B.BfAmountHome,B.BfAmountDraw,B.BfAmountAway ,B.BfPerHome,B.BfPerDraw,B.BfPerAway ,B.BfPayoutHome,B.BfPayoutDraw,B.BfPayoutAway ,B.BfOddsHome,B.BfOddsDraw,B.BfOddsAway ,B.UoAmountOver,B.UoAmountUnder ,B.UoPerOver,B.UoPerUnder ,B.UoOddsOver,B.UoOddsUnder ,B.UoIndexOver,B.UoIndexUnder ,B.AsianAvrLet,B.AsianIndex ,B.BfAmountHome+B.BfAmountDraw+B.BfAmountAway  ,B.UoAmountOver+ UoAmountUnder,T.*,E.*,F.* FROM playdata.T001_N_TIPSINPLAY H LEFT JOIN playdata.T001_NB_TIPSINPLAY_DATA  B on B.EventId = H.EVENTID LEFT JOIN (select  X.EVENTID eventid10,X.BfIndexHome a ,X.BfIndexDraw b  ,X.BfIndexAway c ,X.BfAmountHome d ,X.BfAmountDraw e ,X.BfAmountAway f ,X.BfPerHome g ,X.BfPerDraw z,X.BfPerAway x ,X.BfPayoutHome m,X.BfPayoutDraw n,X.BfPayoutAway v ,X.BfOddsHome q ,X.BfOddsDraw w ,X.BfOddsAway r ,X.UoAmountOver t ,X.UoAmountUnder y ,X.UoPerOver u,X.UoPerUnder i ,X.UoOddsOver o ,X.UoOddsUnder p ,X.UoIndexOver s,X.UoIndexUnder h ,X.AsianAvrLet j ,X.AsianIndex k ,X.BfAmountRunning l ,X.UoAmountRunning l1,X.HomeScore,X.AwayScore ,X.FlagTimeOdds,X.FlagTimeOu  FROM playdata.T001_NR_TIPSINPLAY_DATA X ) T on B.EventId = T.eventid10 LEFT JOIN ( SELECT  eventid eventid12, Selection ,Amount ,Price ,Attr ,Per ,UpdateTime ,Selection2 ,Amount2 ,Price2 ,Attr2 ,Per2 ,UpdateTime2 ,Selection3 ,Amount3 ,Price3 ,Attr3 ,Per3 ,UpdateTime3 FROM playdata.T001_N_TIPSINPLAY_TOP WHERE type = 'Top3' and oddsType='odds' ) E ON H.EVENTID = E.eventid12 LEFT JOIN ( SELECT  eventid eventid11,Selection Selection1 ,Amount Amount1 ,Price Price1 ,Attr Attr1 ,Per Per1 ,UpdateTime UpdateTime1 ,Selection2 Selection21 ,Amount2 Amount21 ,Price2 Price21 ,Attr2 Attr21 ,Per2 Per22 ,UpdateTime2 UpdateTime23 ,Selection3 Selection34 ,Amount3 Amount35 ,Price3 Price36 ,Attr3 Attr37 ,Per3 Per38 ,UpdateTime3 UpdateTime39 FROM playdata.T001_N_TIPSINPLAY_TOP WHERE type = 'Top3' and oddsType='uo' ) F ON H.EVENTID = F.eventid11  where DATE_TIME >='" + 
    
      startTime + "'\n" + 
      " and DATE_TIME <='" + endTime + "'" + 
      "order by DATE_TIME desc";
    return sql;
  }
  
  @LogAnnotation
  @ApiOperation("根据sql导出excel")
  @PostMapping
  @PreAuthorize("hasAuthority('excel:down')")
  public void downloadExcel(String startTime, String endTime, String type, HttpServletResponse response)
  {
    String sql = "";
    if ("1".equals(type)) {
      sql = getAndCheckSql(startTime, endTime);
    } else if("2".equals(type)) {
      sql = xcAndCheckSql(startTime, endTime);
    }else
    {
    	 sql = hkAndCheckSql(startTime, endTime);
    }
    List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql);
    if (!CollectionUtils.isEmpty(list))
    {
      Map<String, Object> map = (Map)list.get(0);
      
      String[] headers = new String[map.size()];
      int i = 0;
      for (String key : map.keySet()) {
        headers[(i++)] = key;
      }
      List<Object[]> datas = new ArrayList(list.size());
      for (Object m : list)
      {
        Object[] objects = new Object[headers.length];
        for (int j = 0; j < headers.length; j++) {
          objects[j] = ((Map)m).get(headers[j]);
        }
        datas.add(objects);
      }
      if ("1".equals(type))
      {
        String sqlh = "select field_name from playdata.T003_HEADER_DETAILS where type =4";
        Object listheader = this.jdbcTemplate.queryForList(sqlh);
        
        String[] hheaders = new String[((List)listheader).size()];
        for (int j = 0; j < ((List)listheader).size(); j++) {
          hheaders[j] = String.valueOf(((Map)((List)listheader).get(j)).get("field_name"));
        }
        ExcelUtil.excelExport(
          startTime + "~" + endTime, 
          hheaders, 
          datas, response);
      }
      if ("2".equals(type)) 
      {
        String[] hheaders = new String[getHeader().size()];
        for (int j = 0; j < getHeader().size(); j++) {
          hheaders[j] = String.valueOf(getHeader().get(j));
        }
        ExcelUtil.excelExport(
          startTime + "~" + endTime+"XC", 
          hheaders, 
          datas, response);
      }
      else
      { 
    	  String[] hheaders = new String[getHeaderRed().size()];
        for (int j = 0; j < getHeaderRed().size(); j++) {
          hheaders[j] = String.valueOf(getHeaderRed().get(j));
        }
        ExcelUtil.excelExport(
          startTime + "~" + endTime+"-Red", 
          hheaders, 
          datas, response);
    	  
    	  
      }
    }
  }
  
  private static String hkAndCheckSql(String startTime, String endTime) {
	
	  String sql="select \n" + 
	  		" league,\n" + 
	  		" homename,\n" + 
	  		" awayname,comtime,halfscore,finshscore,under_od,basepk,handicap,red,redscore,redfnum,redtimes,goaltimes,\n" + 
	  		" SUBSTRING_INDEX(corners,'-',1) mcorners,SUBSTRING(corners,INSTR(corners,'-')+1) kcorners,\n" + 
	  		" SUBSTRING_INDEX(attacks,'-',1) mcattacks,SUBSTRING(attacks,INSTR(attacks,'-')+1) kattacks,\n" + 
	  		" SUBSTRING_INDEX(dangerous_attacks,'-',1) mdangerous_attacks,SUBSTRING(dangerous_attacks,INSTR(dangerous_attacks,'-')+1) kdangerous_attacks,\n" + 
	  		" SUBSTRING_INDEX(on_target,'-',1) mon_target,SUBSTRING(on_target,INSTR(on_target,'-')+1) kon_target,\n" + 
	  		" SUBSTRING_INDEX(off_target,'-',1) moff_target,SUBSTRING(off_target,INSTR(off_target,'-')+1) koff_target,\n" + 
	  		" SUBSTRING_INDEX(possession_rt,'-',1) mpossession_rt,SUBSTRING(possession_rt,INSTR(possession_rt,'-')+1) kpossession_rt\n" + 
	  		" from (\n" + 
	  		" select \n" + 
	  		" league,\n" + 
	  		" homename,\n" + 
	  		" awayname,comtime,halfscore,finshscore,under_od,basepk,handicap,red,redscore,redfnum,redtimes,goaltimes,\n" + 
	  		" replace(replace(replace(replace(corners,'[',''),']',''),'\"',''),',','-') corners,\n" + 
	  		" replace(replace(replace(replace(attacks,'[',''),']',''),'\"',''),',','-') attacks,\n" + 
	  		" replace(replace(replace(replace(dangerous_attacks,'[',''),']',''),'\"',''),',','-') dangerous_attacks ,\n" + 
	  		" replace(replace(replace(replace(on_target,'[',''),']',''),'\"',''),',','-') on_target,\n" + 
	  		" replace(replace(replace(replace(off_target,'[',''),']',''),'\"',''),',','-') off_target,\n" + 
	  		" replace(replace(replace(replace(possession_rt,'[',''),']',''),'\"',''),',','-') possession_rt\n" + 
	  		" from \n" + 
	  		" playdata.T008_REALTIME_RED_HIS \n" + 
	  		" ) a ";
	   sql += "  where a.comtime >='" + 
			    
      startTime + "'\n" + 
      " and a.comtime <='" + endTime + "'" + 
      "order by a.comtime desc";
    return sql;
	  
}

@LogAnnotation
  @ApiOperation("根据sql在页面显示结果")
  @PostMapping({"/show-datas"})
  @PreAuthorize("hasAuthority('excel:show:datas')")
  public List<Object[]> showData(String startTime, String endTime)
  {
    String sql = getAndCheckSql(startTime, endTime);
    List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql);
    if (!CollectionUtils.isEmpty(list))
    {
      Map<String, Object> map = (Map)list.get(0);
      
      String[] headers = new String[map.size()];
      int i = 0;
      for (String key : map.keySet()) {
        headers[(i++)] = key;
      }
      List<Object[]> datas = new ArrayList(list.size());
      String sqlh = "select field_name from playdata.T003_HEADER_DETAILS where type =4";
      List<Map<String, Object>> listheader = this.jdbcTemplate.queryForList(sqlh);
      
      String[] hheaders = new String[listheader.size()];
      for (int j = 0; j < listheader.size(); j++) {
        hheaders[j] = String.valueOf(((Map)listheader.get(j)).get("field_name"));
      }
      datas.add(hheaders);
      for (Map<String, Object> m : list)
      {
        Object[] objects = new Object[headers.length];
        for (int j = 0; j < headers.length; j++) {
          objects[j] = m.get(headers[j]);
        }
        datas.add(objects);
      }
      return datas;
    }
    return Collections.emptyList();
  }
}
