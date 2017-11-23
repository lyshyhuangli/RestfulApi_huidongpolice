package com.api.service.impl;

import com.api.common.StaticNumber;
import com.api.entity.AnQingRecord;
import com.api.entity.JingQingInfoRecord;
import com.api.mapper.JingqingMapper;
import com.api.service.JingqingService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.*;

@Service
@Transactional
public class JingqingServiceImpl implements JingqingService
{
    @Autowired
    private JingqingMapper jingqingMapper;

    /**
     * 获取最新五条警情
     *
     * @return
     */
    public List<JingQingInfoRecord> getLastSevenNumberJingQing()
    {
        List<JingQingInfoRecord> infoList = jingqingMapper.getLastFiveNumberJingQing();
        for (JingQingInfoRecord j : infoList)
        {
            String briefly = j.getBriefly().trim();
            if (StringUtils.isNotBlank(briefly))
            {
                j.setBriefly(briefly.replaceAll("\r\n", ""));
            }
            if (StringUtils.isNotBlank(j.getAlarmCompany()))
            {
                String alarmCompanys = j.getAlarmCompany().replaceAll("惠东县公安局", "");
                j.setAlarmCompany(alarmCompanys);
            }
        }

        return infoList;
    }

    public JingQingInfoRecord getJingQingInfoById(String id)
    {

        return jingqingMapper.getJingQingInfoById(id);
    }

    /**
     * 滑动获取数据
     *
     * @param count
     * @return
     */
    public List<JingQingInfoRecord> getJingQingMoreInfoByCount(
            int count, String startTime, String endTime, String briefly, String conformJingqingXingzhi, String alarmCompany, String chooseIdNo, String informantPhoneChoose
    )
    {
        count = count * StaticNumber.TWENTY.getCode();

        if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime))
        {

            startTime = startTime + " 00:00";
            endTime = endTime + " 23:59";
        }

        List<String> brieflyss = null;
        if (StringUtils.isNotBlank(briefly))
        {
            brieflyss = new ArrayList<String>();
            String[] strs = briefly.split(" ");
            for (String s : strs)
            {
                if (StringUtils.isNotBlank(s))
                {
                    brieflyss.add(s);
                }
            }
        }


        List<String> conformJingqingXingzhis = null;
        if (StringUtils.isNotBlank(conformJingqingXingzhi))
        {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(conformJingqingXingzhi.replaceAll(",", "','"));
            sb.append("'");
            String[] st = sb.toString().split(",");
            conformJingqingXingzhis = Arrays.asList(st);
        }

        List<String> alarmCompanys = null;
        if (StringUtils.isNotBlank(alarmCompany))
        {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(alarmCompany.replaceAll(",", "','"));
            sb.append("'");
            String[] st = sb.toString().split(",");
            alarmCompanys = Arrays.asList(st);
        }

        List<JingQingInfoRecord> infoLists = jingqingMapper.getJingQingMoreInfoByCount(count, startTime, endTime, brieflyss, conformJingqingXingzhis, alarmCompanys, chooseIdNo, informantPhoneChoose);

        for (JingQingInfoRecord j : infoLists)
        {


            String brieflys = j.getBriefly().trim();
            brieflys =brieflys.replaceAll("\r\n", "");
            if (StringUtils.isNotBlank(brieflys))
            {
                if (brieflyss != null)
                {
                    int size = 0;
                    for (String a : brieflyss)
                    {
                        if (brieflys.contains(a))
                        {
                            size += 1;
                        }
                    }

                    int length = 34/size;

                    StringBuilder st = new StringBuilder();
                    for (String s : brieflyss)
                    {

                        if (brieflys.contains(s))
                        {


                            int start = 0;
                            int end = 0;

                            int index = brieflys.indexOf(s);
                            if(index < length)
                            {
                                start = 0;
                            }
                            else
                            {
                                start = index - length;
                                st.append("...");
                            }

                            index = brieflys.length() - brieflys.indexOf(s);
                            if(index < length)
                            {
                                end = brieflys.indexOf(s) + index;
                            }
                            else
                            {
                                end = brieflys.indexOf(s) + length + s.length();

                                if(end >= brieflys.length())
                                {
                                    end = brieflys.length();
                                }
                            }

                            String temp = brieflys.substring(start,end);
                            st.append(temp);
                            st.append("...");
                        }
                    }

                    j.setBriefly(st.toString());
                }
                else
                {
                    j.setBriefly(brieflys);
                }

            }


            if (StringUtils.isNotBlank(j.getAlarmCompany()))
            {
                String alarmCompanydb = j.getAlarmCompany().replaceAll("惠东县公安局", "");
                j.setAlarmCompany(alarmCompanydb);
            }
        }

        return infoLists;
    }

    /**
     * 获取所有的确认警情性质
     *
     * @return
     */
    public List<String> getAllConformJingqingXingzhi()
    {
        List<String> infoLists = jingqingMapper.getAllConformJingqingXingzhi();

        for (Iterator iter = infoLists.iterator(); iter.hasNext(); )
        {
            String str = (String) iter.next();
            if (str.contains("删除") || StringUtils.isBlank(str))
            {
                iter.remove();
            }
        }

        return infoLists;
    }

    /**
     * 获取所有的  派出所
     *
     * @return
     */
    public List<String> getAllAlarmCompany()
    {
        List<String> infoLists = jingqingMapper.getAllAlarmCompany();

        for (Iterator iter = infoLists.iterator(); iter.hasNext(); )
        {
            String str = (String) iter.next();
            if (str.contains("已撤销") || StringUtils.isBlank(str))
            {
                iter.remove();
            }
        }

        return infoLists;
    }

    /**
     * 一周警情统计
     *
     * @return
     */
    public List<List<AnQingRecord>> getWeekAlarmStatic()
    {
        List<List<AnQingRecord>> infoList = new ArrayList<List<AnQingRecord>>();
        List<AnQingRecord> companyList1 = new ArrayList<AnQingRecord>();
        List<AnQingRecord> companyList2 = new ArrayList<AnQingRecord>();
        List<AnQingRecord> companyList3 = new ArrayList<AnQingRecord>();

        String type1 = "城南派出所，城西派出所，南湖派出所，蕉田派出所，大岭派出所，吉隆派出所，黄埠派出所";
        List<String> type1List = new ArrayList<String>();
        type1List.add("城南派出所");
        type1List.add("城西派出所");
        type1List.add("南湖派出所");
        type1List.add("蕉田派出所");
        type1List.add("大岭派出所");
        type1List.add("吉隆派出所");
        type1List.add("黄埠派出所");

        String type2 = "白花派出所，太阳坳派出所，稔山派出所,亚婆角派出所，平海派出所，" +
                "港口派出所，巽寮派出所，梁化派出所，多祝派出所，铁涌派出所";
        List<String> type2List = new ArrayList<String>();
        type2List.add("白花派出所");
        type2List.add("太阳坳派出所");
        type2List.add("稔山派出所");
        type2List.add("亚婆角派出所");
        type2List.add("平海派出所");
        type2List.add("港口派出所");
        type2List.add("巽寮派出所");
        type2List.add("梁化派出所");
        type2List.add("多祝派出所");
        type2List.add("铁涌派出所");

        String type3 = "增光派出所，白盆朱派出所，新庵派出所，安墩派出所，宝口派出所，" +
                "高潭派出所，港口边防派出所，平海边防派出所，范和边防派出所，" +
                "盐洲边防派出所，黄埠边防派出所，巽寮边防派出所，三角洲边防派出所，亚婆边防派出所";
        List<String> type3List = new ArrayList<String>();
        type3List.add("增光派出所");
        type3List.add("白盆朱派出所");
        type3List.add("新庵派出所");
        type3List.add("安墩派出所");
        type3List.add("宝口派出所");
        type3List.add("高潭派出所");
        type3List.add("港口边防派出所");
        type3List.add("平海边防派出所");
        type3List.add("范和边防派出所");
        type3List.add("盐洲边防派出所");
        type3List.add("黄埠边防派出所");
        type3List.add("巽寮边防派出所");
        type3List.add("三角洲边防派出所");
        type3List.add("亚婆边防派出所");


        List<AnQingRecord> infoLists = jingqingMapper.getWeekAlarmStatic();

        for (Iterator iter = infoLists.iterator(); iter.hasNext(); )
        {
            AnQingRecord str = (AnQingRecord) iter.next();

            String alarmCompany = str.getAlarm_Company();
            if (alarmCompany.contains("已撤销"))
            {
                continue;
            }

            String temp1 = alarmCompany.replace("惠东县公安局", "");
            String temp2 = temp1.replace("白花分局", "");
            String temp = temp2.replace("惠东县边防大队", "");
            int number = str.getNumber();

            AnQingRecord r = new AnQingRecord();
            r.setAlarm_Company(temp);
            r.setNumber(number);

            if (type1List.contains(temp))
            {
                companyList1.add(r);
            }
            else if (type2List.contains(temp))
            {
                companyList2.add(r);
            }
            else if(type3List.contains(temp))
            {
                companyList3.add(r);
            }
            else
            {

            }
        }

        for(String s:type1List)
        {
            boolean isExist = false;
            for(AnQingRecord ss:companyList1)
            {
                if(ss.getAlarm_Company().equalsIgnoreCase(s))
                {
                    isExist = true;
                    break;
                }
            }

            if(!isExist)
            {
                AnQingRecord a = new AnQingRecord();
                a.setAlarm_Company(s);
                a.setNumber(0);
                companyList1.add(a);
            }
        }

        for(String s:type2List)
        {
            boolean isExist = false;
            for(AnQingRecord ss:companyList2)
            {
                if(ss.getAlarm_Company().equalsIgnoreCase(s))
                {
                    isExist = true;
                    break;
                }
            }

            if(!isExist)
            {
                AnQingRecord a = new AnQingRecord();
                a.setAlarm_Company(s);
                a.setNumber(0);
                companyList2.add(a);
            }
        }

        for(String s:type3List)
        {
            boolean isExist = false;
            for(AnQingRecord ss:companyList3)
            {
                if(ss.getAlarm_Company().equalsIgnoreCase(s))
                {
                    isExist = true;
                    break;
                }
            }

            if(!isExist)
            {
                AnQingRecord a = new AnQingRecord();
                a.setAlarm_Company(s);
                a.setNumber(0);
                companyList3.add(a);
            }
        }

        infoList.add(companyList1);
        infoList.add(companyList2);
        infoList.add(companyList3);

        return infoList;
    }
}
