import java.io.*;
import java.util.*;

public class MultiwayMergeSort {
    public static void main(String[] args) {
        final int NUM_RECORDS = 200000;
        final String FILE_NAME = "data.dat";
        final String MERGE_FILE_NAME = "mergedData.dat";
        final int BLOCK_SIZE = 10000;

        // 生成记录并存储到外存文件
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            DataOutputStream dos = new DataOutputStream(fos);
            Random rand = new Random();
            Set<Integer> usedNums = new HashSet<>();
            for (int i = 0; i < NUM_RECORDS; i++) {
                int num = rand.nextInt(NUM_RECORDS);
                while (usedNums.contains(num)) {
                    num = rand.nextInt(NUM_RECORDS);
                }
                usedNums.add(num);
                String str = "Record " + num;
                dos.writeInt(num);
                dos.writeUTF(str);
            }
            dos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 多路归并排序
        long startTime = System.currentTimeMillis();
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            DataInputStream dis = new DataInputStream(fis);
            List<File> sortedRuns = new ArrayList<>();
            int j = 0;
            while (dis.available() > 0) {
                List<Record> block = new ArrayList<>();
                for (int i = 0; i < BLOCK_SIZE && dis.available() > 0; i++) {
                    int num = dis.readInt();
                    String str = dis.readUTF();
                    Record record = new Record(num, str, j);
                    block.add(record);
                }
                j++;
                Collections.sort(block);
                File sortedRun = saveSortedRun(block);
                sortedRuns.add(sortedRun);
            }
            dis.close();
            fis.close();
            mergeSortedRuns(sortedRuns, MERGE_FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Sorting took " + (endTime - startTime) + " milliseconds");
    }

    private static class Record implements Comparable<Record> {
        int num;
        String str;
        int syn;

        public Record(int num, String str, int syn) {
            this.num = num;
            this.str = str;
            this.syn = syn;
        }

        @Override
        public int compareTo(Record o) {
            return Integer.compare(num, o.num);
        }
    }

    private static File saveSortedRun(List<Record> block) throws IOException {
        File file = File.createTempFile("sorted_run_", ".dat");
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dos = new DataOutputStream(fos);
        for (Record record : block) {
            dos.writeInt(record.num);
            dos.writeUTF(record.str);
            dos.writeInt(record.syn);
        }
        dos.close();
        fos.close();
        return file;
    }

    private static void mergeSortedRuns(List<File> sortedRuns, String outputFileName) throws IOException {
        List<DataInputStream> streams = new ArrayList<>();
        for (File file : sortedRuns) {
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            streams.add(dis);
        }
        FileOutputStream fos = new FileOutputStream(outputFileName);
        DataOutputStream dos = new DataOutputStream(fos);
        PriorityQueue<Record> pq = new PriorityQueue<>();
        for (DataInputStream dis : streams) {
            int num = dis.readInt();
            String str = dis.readUTF();
            int syn = dis.readInt();
            Record record = new Record(num, str, syn);
            pq.add(record);
        }
        while (!pq.isEmpty()) {
            Record minRecord = pq.poll();
            dos.writeInt(minRecord.num);
            dos.writeUTF(minRecord.str);
            DataInputStream dis = streams.get(minRecord.syn);
            if (dis.available() > 0) {
                int num = dis.readInt();
                String str = dis.readUTF();
                int syn = dis.readInt();
                Record record = new Record(num, str, syn);
                pq.add(record);
            }

        }
        for (DataInputStream dis : streams) {
            dis.close();
        }
        dos.close();
        fos.close();
    }
}