package com.example.springbootwithpostgressql.common;

import com.google.common.base.Strings;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {

    static final String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    static String regexURL = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public static String parseString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            try {
                return String.valueOf(obj);
            } catch (Exception var2) {
                return "";
            }
        }
    }

    public static long parseLong(Object o) {
        if (o == null) {
            return 0L;
        } else if (o instanceof Double) {
            return ((Double) o).longValue();
        } else if (o instanceof Float) {
            return ((Float) o).longValue();
        } else {
            try {
                return Long.parseLong(String.valueOf(o));
            } catch (Exception var2) {
                return 0L;
            }
        }
    }

    public static int parseInt(Object o) {
        if (o == null) {
            return 0;
        } else if (o instanceof Double) {
            return ((Double) o).intValue();
        } else if (o instanceof Float) {
            return ((Float) o).intValue();
        } else {
            try {
                return Integer.parseInt(String.valueOf(o));
            } catch (Exception var2) {
                return 0;
            }
        }
    }

    public static double parseDouble(Object o) {
        if (o == null) {
            return 0.0D;
        } else {
            try {
                return Double.parseDouble(String.valueOf(o));
            } catch (Exception var2) {
                return 0.0D;
            }
        }
    }

    public static Boolean parseBoolean(Object o){
        if (o == null) {
            return false;
        } else {
            try {
                return parseString(o).equals("true");
            } catch (Exception ex) {
                return false;
            }
        }
    }

    // mã hóa chuỗi sang md5
    public static String MD5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString(b & 255 | 256), 1, 3);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException var8) {
            return "";
        }
    }

    public static boolean validateEmail(String email) {
        if (Strings.isNullOrEmpty(email)) {
            return false;
        } else {

            Pattern pattern = Pattern.compile("^(?=.{1,64}@)[()\\[\\]#*/A-Za-z0-9_-]+(\\.[()\\[\\]#*/A-Za-z0-9_-]+)*" +
                    "@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
    }

    public static boolean validatePhone(String phone) {
        String regex = "(0)[0-9]{9}";
        return !Strings.isNullOrEmpty(phone) && phone.matches(regex);
    }

    public static boolean validateUrl(String url) {
        if (Strings.isNullOrEmpty(url)) {
            return false;
        } else {
            Pattern pattern = Pattern.compile(regexURL);
            Matcher matcher = pattern.matcher(url);
            return matcher.matches();
        }
    }

    public static boolean validatePassword(String password){
        if (Strings.isNullOrEmpty(password)) {
            return false;
        } else {
            String regexPattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }
    }
}
