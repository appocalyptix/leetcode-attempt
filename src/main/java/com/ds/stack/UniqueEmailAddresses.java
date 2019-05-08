package com.ds.stack;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 *
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * <p>
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * <p>
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * <p>
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without
 * dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not
 * apply for domain names.)
 * <p>
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example
 * m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 * <p>
 * It is possible to use both of these rules at the same time.
 * <p>
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        if (emails.length <= 1) {
            return emails.length;
        }

        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String local = email.substring(0, email.indexOf("@")).replaceAll("\\.", "");
            String domain = email.substring(email.indexOf("@"));
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            set.add(local + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses ue = new UniqueEmailAddresses();
        String[] ss = {"testema.il@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"};
        ue.numUniqueEmails(ss);
    }
}
