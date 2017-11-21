package com.xwsxjt.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author xiaoshijie
 * @ClassName GetStandardSqlUtils
 * @Description 获得标准数据库查询语句的工具类
 * @date 2017/9/4
 */
public class GetStandardSqlUtils {
    /**
     * @Title: getIdUpdateSql
     * @Description: 获得根据id更新的数据库语句，需要id和更新的字段值
     * @author xiaoshijie
     * @date 2017-09-04
     * @param obj 实体类对象
     * @return String
     */
    public static String getIdUpdateSql(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //如果对象为空
        if (obj == null){
            System.out.println("getIdUpdateSql:对象为空");
            return null;
        }
        //获得Class对象
        Class objClass = obj.getClass();

        //获得getId方法
        Method method = objClass.getMethod("getId");
        //如果id为空
        if (method.invoke(obj) == null){
            System.out.println("getIdUpdateSql:id为空");
            return null;
        }
        //获得id的值
        long id = Long.parseLong(method.invoke(obj).toString());

        //初始化sql语句，如:"update table "
        String sql="update "+getStandardDbsDataName(objClass.getSimpleName())+" set ";

        //通过反射获得类中所有属性
        Field[] fields = objClass.getDeclaredFields();
        //判断除了id外其他属性是否具有值,false:表示无，true:表示有
        boolean flag = false;
        //循环所有属性
        for (Field field:fields){
            //如果属性名不是id
            if (!field.getName().equals("id")){
                //获得属性类型
                String filedType = field.getType().getTypeName();
                //如果属性类型不是List或Set集合
                if (!filedType.equals("java.util.List") && !filedType.equals("java.util.Set")){
                    //如果属性值不为空
                    if (getter(obj, field.getName()) != null){
                        //将判断是否有属性具有值设为true（有）
                        flag = true;
                        //如果属性类型为Boolean
                        if(filedType.equals("java.lang.Boolean")){
                            //向sql字符串增加内容，如:"update table set filed1 = true, "
                            //getStandardDbsDataName获得标准的数据库数据名称，如实体类中的stringTest对应的数据库字段为string_test
                            //getter:获得对应属性的值
                            sql = sql + getStandardDbsDataName(field.getName()) + " = "+getter(obj, field.getName())+", ";
                        }else {
                            //如果属性是Date
                            if (filedType.equals("java.util.Date")){
                                //创建SimpleDateFormat对象
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatUtils.YEAR_MONTH_DAY_HOU_MIN_SEC);
                                //通过反射获得属性的值即时间，并将其转化为标准格式"yyyy-MM-dd HH:mm:ss"
                                String date = simpleDateFormat.format(getter(obj, field.getName()));
                                try {
                                    //将Date格式时间转化为数据库能识别的Timestamp类型的时间
                                    sql = sql + getStandardDbsDataName(field.getName()) + " = '"+new Timestamp(DateFormatUtils.getDateByString(date,DateFormatUtils.YEAR_MONTH_DAY_HOU_MIN_SEC).getTime())+"', ";
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                //如果是对象中的属性是实体类对象
                                if (!filedType.contains("java.lang") && !filedType.equals("java.util.Date") &&
                                        !filedType.equals("java.sql.Timestamp")){
                                    //获得该实体类对象
                                    Object object = getter(obj, field.getName());
                                    //获得实体类对象的getId方法
                                    Method methodOfGetId = object.getClass().getMethod("getId");
                                    //获得getId方法返回的值
                                    Object objectId = methodOfGetId.invoke(object);
                                    if (objectId != null){
                                        //向sql字符串增加内容，如:"update table set filed1 = true, field2_id = '2', "
                                        sql = sql + getStandardDbsDataName(field.getName()) +"_id" + " = '"+objectId+"', ";
                                    }
                                }else {
                                    //向sql字符串增加内容，如:"update table set filed1 = true, field2 = 'value', "
                                    sql = sql + getStandardDbsDataName(field.getName()) + " = '"+getter(obj, field.getName())+"', ";
                                }
                            }
                        }
                    }
                }
            }
        }
        //如果flag是false表示除了id外其余的属性均为空，返回空
        if (!flag){
            return null;
        }

        //去除字符串后的", "，并增加" where id = value";
        //如"update table set filed1 = true, field2 = 'value' where id = value1"
        sql = sql.substring(0, sql.length()-2)+" where id = "+id;

        System.out.println(sql);
        return sql;
    }

    /**
     * @Title: getInsertSql
     * @Description: 获得插入数据库数据的语句
     * @author xiaoshijie
     * @date 2017-09-05
     * @param obj 实体类对象
     * @return String
     */
//    public static String getInsertSql(Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        //如果对象为空
//        if (obj == null){
//            System.out.println("getInsertSql:对象为空");
//            return null;
//        }
//        //获得Class对象
//        Class objClass = obj.getClass();
//        //insert into educational_experience(
//        // id, name
//        // ) values(
//        // '1', '历史');
//        //初始化beginSql语句，如:"insert into educational_experience( "
//        String beginSql="insert into "+getStandardDbsDataName(objClass.getSimpleName())+"(";
//        //初始化endSql语句，如:") values( "
//        String endSql = ") values(";
//
//        //通过反射获得类中所有属性
//        Field[] fields = objClass.getDeclaredFields();
//        //循环所有属性
//        for (Field field:fields){
////            System.out.println(field);
//            //如果属性名不是id
//            if (!field.getName().equals("id")){
//                //获得属性类型
//                String filedType = field.getType().getTypeName(); //java.util.Date
////                System.out.println(field.getType());educationalExperience - personalInformation
//                field.setAccessible(true);
//                System.out.println(field.get(obj));
//                //如果属性类型不是List或Set集合
//                if (!filedType.equals("java.util.List") && !filedType.equals("java.util.Set")){
//                    //如果属性值不为空
//                    if (getter(obj, field.getName()) != null){
//                        //如果是对象中的属性是不是引用对象和时间类型；判断实体对象
//                        if (!filedType.contains("java.lang") && !filedType.equals("java.util.Date") &&
//                                !filedType.equals("java.sql.Timestamp")){
//
//                            //java.lang:Long,String,Integer,Byte,Double,Float,
//                            //获得该实体类对象
//                            Object object = getter(obj, field.getName());
//                            field.get(obj);
//                            //获得实体类对象的getId方法
//                            Method methodOfGetId = object.getClass().getMethod("getId");
//                            //获得getId方法返回的值
//                            Object objectId = methodOfGetId.invoke(object);
//                            if (objectId != null){
//                                //personalInformation
//                                //向beginSql字符串增加内容，如:"insert into table(field_id, "
//                                //insert into educational_experience(personal_information_id,
//                                beginSql = beginSql + getStandardDbsDataName(field.getName()) + "_id, ";
//                                //向endSql字符串增加内容，如:") values('1', "
//                                endSql = endSql + "'"+ objectId + "', ";
//                            }
//                        }else{
//                            //向beginSql字符串增加内容，如:"insert into table(field1, fud, dfd, "
//                            //endSql ) values('1', 'df', true,
//                            beginSql = beginSql + getStandardDbsDataName(field.getName()) + ", ";
//                            //如果属性类型为Boolean
//                            if(filedType.equals("java.lang.Boolean")){
//                                //向endSql字符串增加内容，如:") values(true, "
//                                endSql = endSql + getter(obj, field.getName()) + ", ";
//                            }else {
//                                //如果属性是Date或者Timestamp
//                                if (filedType.equals("java.util.Date") || filedType.equals("java.sql.Timestamp")) {
//                                    //创建SimpleDateFormat对象
//                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatUtils.YEAR_MONTH_DAY_HOU_MIN_SEC);
//                                    //通过反射获得属性的值即时间，并将其转化为标准格式"yyyy-MM-dd HH:mm:ss"
//                                    String date = simpleDateFormat.format(getter(obj, field.getName()));
//                                    try {
//                                        //将Date格式时间转化为数据库能识别的Timestamp类型的时间
//                                        endSql = endSql + "'" + new Timestamp(DateFormatUtils.getDateByString(date).getTime()) + "', ";
//                                    } catch (ParseException e) {
//                                        e.printStackTrace();
//                                    }
//                                } else {
//                                    //向endSql字符串增加内容，如:") values('value', "
//                                    endSql = endSql + "'" + getter(obj, field.getName()) + "', ";
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        //去除字符串后的", "
//        //insert into educational_experience(id, name, personal_information_id,
//        //如beginSql:insert into educational_experience(id, name, personal_information_id") values('1', 'sd', '1'");
//        beginSql = beginSql.substring(0, beginSql.length()-2);
//        //如endSql:") values('1', 'sd', '1', "  ;  ") values('1', 'sd', '1'"
//        endSql = endSql.substring(0, endSql.length()-2);
//        //如："insert into table(field1) values('value'"
//        String sql = beginSql + endSql + ")";
//
//        System.out.println(sql);
//        return sql;
//    }

    /**
     * @Title: getInsertSql
     * @Description: 获得插入数据库数据的语句
     * @author xiaoshijie
     * @date 2017-09-05
     * @param obj 实体类对象
     * @return String
     */
    public static String getInsertSql(Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //如果对象为空
        if (obj == null){
            System.out.println("getInsertSql:对象为空");
            return null;
        }
        //获得Class对象
        Class objClass = obj.getClass();
        //初始化beginSql语句，如:"insert into educational_experience( "
        String beginSql="insert into "+getStandardDbsDataName(objClass.getSimpleName())+"(";
        //初始化endSql语句，如:") values( "
        String endSql = ") values(";

        //通过反射获得类中所有属性
        Field[] fields = objClass.getDeclaredFields();
        //循环所有属性
        for (Field field:fields) {
            if (!field.getName().equals("id")) {
                //获得属性类型
                Class<?> fieldType = field.getType();
                //如果属性类型不是List或Set集合
                if (fieldType != List.class && fieldType != Set.class) {
                    //设置属性可访问
                    field.setAccessible(true);
                    //获得属性对应的值
                    Object filedValue = field.get(obj);
                    if (filedValue != null) {
                        //如果是对象中的属性是不是引用对象和时间类型；则判断为实体对象
                        //java.lang:Long,String,Integer,Byte,Double,Float
                        if (!fieldType.getName().contains("java.lang") && fieldType != Date.class
                                && fieldType != Timestamp.class) {
                            //获得实体类对象的getId方法
                            Method methodOfGetId = filedValue.getClass().getMethod("getId");
                            //获得getId方法返回的值
                            Object objectId = methodOfGetId.invoke(filedValue);
                            if (objectId != null) {
                                //personalInformation
                                //向beginSql字符串增加内容，如:"insert into table(field_id, "
                                beginSql = beginSql + getStandardDbsDataName(field.getName()) + "_id, ";
                                //向endSql字符串增加内容，如:") values('1', "
                                endSql = endSql + "'" + objectId + "', ";
                            }
                        } else {
                            //向beginSql字符串增加内容，如:"insert into table(field1, fud, dfd, "
                            beginSql = beginSql + getStandardDbsDataName(field.getName()) + ", ";
                            //如果属性类型为Boolean
                            if (fieldType == Boolean.class) {
                                //向endSql字符串增加内容，如:") values(true, "
                                endSql = endSql + filedValue + ", ";
                            } else {
                                //如果属性是Date或者Timestamp
                                if (fieldType == Date.class || fieldType == Timestamp.class) {
                                    //创建SimpleDateFormat对象
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatUtils.YEAR_MONTH_DAY_HOU_MIN_SEC);
                                    //通过反射获得属性的值即时间，并将其转化为标准格式"yyyy-MM-dd HH:mm:ss"
                                    String date = simpleDateFormat.format(filedValue);
                                    try {
                                        //将Date格式时间转化为数据库能识别的Timestamp类型的时间
                                        endSql = endSql + "'" + new Timestamp(DateFormatUtils.getDateByString(date, DateFormatUtils.YEAR_MONTH_DAY_HOU_MIN_SEC).getTime()) + "', ";
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    //向endSql字符串增加内容，如:") values('value', "
                                    endSql = endSql + "'" + getter(obj, field.getName()) + "', ";
                                }
                            }
                        }
                    }
                }
            }
        }

        //去除字符串后的", "
        //insert into educational_experience(id, name, personal_information_id,
        //如beginSql:insert into educational_experience(id, name, personal_information_id") values('1', 'sd', '1'");
        beginSql = beginSql.substring(0, beginSql.length()-2);
        //如endSql:") values('1', 'sd', '1', "  ;  ") values('1', 'sd', '1'"
        endSql = endSql.substring(0, endSql.length()-2);
        //如："insert into table(field1) values('value'"
        String sql = beginSql + endSql + ")";

        System.out.println(sql);
        return sql;
    }

    /**
     * @Title: getDeleteSql
     * @Description: 获得数据库删除语句
     * @author xiaoshijie
     * @date 2017-09-06
     * @param obj 实体对象
     * @return String
     */
    public static String getDeleteSql(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //如果对象为空EducationalExperience
        if (obj == null){
            System.out.println("getDeleteSql:对象为空");
            return null;
        }
        //获得Class对象
        Class objClass = obj.getClass();

        //获得getId方法
        Method method = objClass.getMethod("getId");
        //如果id为空
        if (method.invoke(obj) == null){
            System.out.println("getDeleteSql:id为空");
            return null;
        }
        //获得id的值
        long id = Long.parseLong(method.invoke(obj).toString());

        //初始化sql语句，如:"delete educational_experience where id = 1" EducationalExperience
        System.out.println(objClass.getSimpleName()+objClass.getName());
        String sql="delete from "+getStandardDbsDataName(objClass.getSimpleName())+" where id = '"+ id +"'";

        System.out.println(sql);
        return sql;
    }

    /**
     * @Title: getter
     * @Description: 获得对应方法的值
     * @author xiaoshijie
     * @date 2017-09-05
     * @param obj 实例对象
     * @param attr 属性名
     * @return Object 对应属性的值
     */
    public static Object getter(Object obj, String attr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getMethod("get"+initStr(attr));
        return method.invoke(obj);
    }

    /**
     * @Title: initStr
     * @Description: 将首字母大写
     * @author xiaoshijie
     * @date 2017-09-05
     * @param old 需转化的字符串
     * @return String
     */
    public static String initStr(String old){
        String str = old.substring(0,1).toUpperCase()+old.substring(1);
        return str;
    }

    /**
     * @Title: getStandardDbsDataName
     * @Description: 获得标准的数据库表名和字段名EducationalExperience
     * @author xiaoshijie
     * @date 2017-09-05
     * @param old 实体类名或属性名
     * @return String
     */
    public static String getStandardDbsDataName(String old){
        //遍历字符串中所有字符 EducationalExperience:_educational_experience
        for (int i=0; i < old.length(); i++){
            //获得i所对应的字符E
            char c = old.charAt(i);
            //如果该字符不是小写
            if (!Character.isLowerCase(c)){
                //如字符串为testString,第4个为'S'大写
                //old.substring(0,i)截取(0,4)的字符串为"test",并增加"_"，最后为:"test_"
                //old.substring(i,i+1)截取(4,5)的字符位"S",并使用toLowerCase将其转化为小写，并将其加入字符串为:"test_s"
                //old.substring(i+1)截取(5)之后的字符串，为"tring"并将其加入字符串，为:"test_string";
                //_EducationalExperience
                //E:0,d:1
                //old.substring(0,12) : _educational
                //old.substring(12,13).toLowerCase() E--e
                //old.substring(13) : xperience
                //_educational_experience
                old = old.substring(0,i)+"_"+old.substring(i,i+1).toLowerCase()+old.substring(i+1);
            }
        }

        //经转化后的字符串可能出现"_test_string"和"test_string"的情况，所以需判断具体为哪种情况，按情况返值
        return old.substring(0,1).equals("_")?old.substring(1):old;
    }
}
