package com.ds.array;

public class ValidIPAddress {
    public String validIPAddress(String ip) {
        if (ip.length() < 7) {
            return "Neither";
        }

        ip = ip.toLowerCase();

        if (isValidIPv4(ip)) {
            return "IPv4";
        } else if(isValidIPv6(ip)) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isValidIPv4(String ip) {
        //Check if it has IPv6 format
        if(ip.indexOf(":") >= 0) {
            return false;
        }

        //If IP address starts with .
        if (ip.startsWith(".")) {
            return false;
        }

        String[] elements = ip.split("\\.");
        if (elements.length != 4) {
            return false;
        }

        for(String e : elements) {
            if(e.length() == 0 || e.length() > 3) {
                return false;
            }

            try{
                if(Integer.valueOf(e) > 255) {
                    return false;
                }
            } catch(NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String ip) {
        //Check if it has IPv6 format
        if(ip.contains(".")) {
            return false;
        }

        //If IP address starts with .
        if (ip.startsWith(":")) {
            return false;
        }

        String[] elements = ip.split("\\:");
        if (elements.length != 8) {
            return false;
        }

        for(String e : elements) {
            if(e.length() == 0 || e.length() > 4) {
                return false;
            }

            for (char c : e.toCharArray()) {
                boolean isNumeric = c - '0' >= 0 && c - '0' <= 9;
                boolean    isChar = c - 'a' >= 0 && c - 'a' <= 4;
                if (!(c - '0' >= 0 && c - '0' <= 9) && !(c - 'a' >= 0 && c - 'a' <= 4)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidIPAddress ai = new ValidIPAddress();
        System.out.println(ai.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
