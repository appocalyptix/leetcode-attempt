package com.ds.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 609. Find Duplicate File in System
 * <p>
 * Given a list of directory info including directory path, and all the files with contents in this directory, you need to
 * find out all the groups of duplicate files in the file system in terms of their paths.
 * <p>
 * A group of duplicate files consists of at least two files that have exactly the same content.
 * <p>
 * A single directory info string in the input list has the following format:
 * <p>
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * <p>
 * It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively)
 * in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
 * <p>
 * The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that
 * have the same content. A file path is a string that has the following format:
 * <p>
 * "directory_path/file_name.txt"
 */
public class DuplicateFile {
    public List<List<String>> findDuplicate(String[] paths) {
        if (paths.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : paths) {
            String files = str.substring(str.indexOf(" ") + 1);
            String path = str.substring(0, str.indexOf(" "));

            String[] file = files.split(" ");
            for (String s : file) {
                String content = s.substring(s.indexOf("("));
                String p = path.concat("/").concat(s.substring(0, s.indexOf("(")));
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(p);
                map.put(content, list);
            }
        }
        List<List<String>> res = new ArrayList<>();

        Iterator<List<String>> itr = map.values().iterator();
        while (itr.hasNext()) {
            List<String> l = itr.next();
            if (l.size() > 1) {
                res.add(l);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        DuplicateFile df = new DuplicateFile();
        String[] s1 = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> ll = df.findDuplicate(s1);
        for (List<String> l : ll) {
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println("---------");
        }
    }
}
