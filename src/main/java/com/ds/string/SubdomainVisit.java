package com.ds.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SubdomainVisit {
    public List<String> subdomainVisits(String[] cpdomains) {

        if (cpdomains.length == 0) {
            return Collections.emptyList();
        }

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String s : cpdomains) {
            int count = Integer.parseInt(s.substring(0, s.indexOf(" ")));
            String domain = s.substring(s.indexOf(" ") + 1);
            map.put(domain, map.getOrDefault(domain, 0) + count);

            while (domain.contains(".")) {
                domain = domain.substring(domain.indexOf(".") + 1);
                map.put(domain, map.getOrDefault(domain, 0) + count);
            }
        }

        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            list.add(map.get(key) + " " + key);
        }

        return list;
    }

    public static void main(String[] args) {
        SubdomainVisit sv = new SubdomainVisit();

        List<String> l = sv.subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});

        for (String s : l) {
            System.out.println(s);
        }
    }
}
