package com.el.ecom.common;

public final class CommonAttributes {

   /** 日期格式配比 */
   public static final String[] DATE_PATTERNS          = new String[] { "yyyy",
      "yyyy-MM",
      "yyyyMM",
      "yyyy/MM",
      "yyyy-MM-dd",
      "yyyyMMdd",
      "yyyy/MM/dd",
      "yyyy-MM-dd HH:mm:ss",
      "yyyyMMddHHmmss",
      "yyyy/MM/dd HH:mm:ss"                           };

   /** ecom.xml文件路径 */
   public static final String   ECOM_XML_PATH        = "/ecom.xml";

   /** ecom.properties文件路径 */
   public static final String   ECOM_PROPERTIES_PATH = "/ecom.properties";

   /**
    * 不可实例化
    */
   private CommonAttributes() {}
}