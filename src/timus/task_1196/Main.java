package timus.task_1196;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Set<Integer> teacherDates = new HashSet<>(n);

        for (int i = 0; i < n; i++) {
            teacherDates.add(Integer.parseInt(reader.readLine()));
        }

        int m = Integer.parseInt(reader.readLine());
        int count = 0;

        for (int i = 0; i < m; i++) {
            int date = Integer.parseInt(reader.readLine());
            if (teacherDates.contains(date)) {
                count++;
            }
        }

        System.out.println(count);
    }
}