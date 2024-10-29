
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Scratch {
    public static void main(String[] args) throws ParseException {
        String maskValue="poorani";
        DateTimeFormatter USER_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateTimeFormatter USER_DATE_FORMAT3 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter USER_DATE_FORMAT2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");


        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = sdf3.parse("2016-11-14T16:04:47Z");
// Mon May 14 12:34:56 UTC 2018
        System.out.println(date);

        //       System.out.println(StringUtils(maskValue) && StringUtils.isNotBlank("4") ?maskValue.trim().replaceAll("\\w(?=\\w{"+"4"+"})", "*"):maskValue);

        String a21= LocalDateTime.parse("2016-11-14T16:04:47Z",USER_DATE_FORMAT).format(USER_DATE_FORMAT2);
       System.out.println( LocalDateTime.parse("14-Nov-2016 16:04:47", USER_DATE_FORMAT2));
        //
//        LocalDateTime alo = LocalDateTime.parse("2016-11-14T16:04:47",USER_DATE_FORMAT2).toLocalDate();
       // LocalDateTime today = LocalDateTime.parse(a21).format(USER_DATE_FORMAT2);
      //  System.out.println(today);

        System.out.println(a21+" poorani ");
        String inputReqDate1 = "2020-03-01T08:00:00Z";
        String inputReqDate ="2015-01-12T10:02:00.000Z";
        String d ="01/01/2017";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

//       sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//        Date d=sdf.parse(inputReqDate);
//        System.out.println(d);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    //   String formatter = new SimpleDateFormat("dd/MM/yyyy").format(sdf);
     //   formatter.setTimeZone(TimeZone.getTimeZone("PST"));
//        Date inputReqFormattedDate;
//        String disputeDate = null;
        Date formatDate=formatter.parse(d);
      System.out.println(formatDate);

        Date inputReqFormattedDate= formatDate;

        if (inputReqFormattedDate != null) {
            Calendar calToday = Calendar.getInstance();
            calToday.setTimeZone(TimeZone.getTimeZone("UTC"));
            calToday.setTime(inputReqFormattedDate);
            calToday.set(Calendar.HOUR_OF_DAY, 0);
            calToday.set(Calendar.MINUTE, 0);
            calToday.set(Calendar.SECOND, 0);
            calToday.set(Calendar.MILLISECOND, 0);
            String disputeDate = sdf.format(calToday.getTime()).toString();
          System.out.println("Start date :" + disputeDate);
        }
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS'Z'").format(inputReqFormattedDate));
     //   System.out.println(formatter);
        convertDateFrom(sdf1,formatter,inputReqDate1);

StringBuilder s= new StringBuilder();
s.append("poorani");
s.append("venkat");
s.append("Raghul");
s.append("\n");
        s.append("Raghul23");
System.out.println(s.toString());

String s1="pdfd";
s1="ragdf";
System.out.println(s1);

        BigDecimal a= new BigDecimal("2");
        if(a!=null){
            System.out.println("poori");
        }

        List<String> tenantIdList = new ArrayList<>();
            tenantIdList.add("1");
        tenantIdList.add("poorani");
        tenantIdList.add("venkat");
        String allTenantId= String.join(",",tenantIdList);
        System.out.println(allTenantId);

        Map<String, String> OtherIdDecryptedMap = new HashMap<>();
        OtherIdDecryptedMap.put("poo","232");
        System.out.println(OtherIdDecryptedMap.get("poo1"));

    }

    public static String convertDateFrom(SimpleDateFormat sourceFormat, SimpleDateFormat destFormat, String sourceDateString) throws ParseException {
        Date sourceDate = sourceFormat.parse(sourceDateString);
        String destDateString = destFormat.format(sourceDate);
        System.out.println(destDateString);
        return destDateString;
    }
}