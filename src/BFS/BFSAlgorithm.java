package BFS;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;


public class BFSAlgorithm {

    static final int MAX = 100;

    int G[][] = new int[MAX][MAX];/* ma trận kề*/

    boolean chuaxet[] = new boolean[MAX];/*mảng đánh dấu đỉnh đã được thăm.*/

    int QUEUE[] = new int[MAX]; /*hàng đợi*/

    int n;

    // Đoc du lieu trong file
    void init() {

        File file = new File(getClass().getResource("BFS.IN.txt").getPath());

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(file));

            n = Integer.parseInt(reader.readLine());

            for (int i = 1; i <= n; i++) {

                String[] aLineOfMatrix = reader.readLine().split("\\s+");

                for (int j = 1; j <= n; j++) {

                    G[i][j] = Integer.parseInt(aLineOfMatrix[j - 1]);/*index của J bắt đầu từ 0*/

                }

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (reader != null)

                try {

                    reader.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

        }

    }


    void BFS(int v) {

        int u, dauQ, cuoiQ, j;

        dauQ = 1; // dia chỉ của đầu hàng đợi

        cuoiQ = 1;// địa chi cuối

        QUEUE[cuoiQ] = v; // thêm nút vào hàng đợi

        chuaxet[v] = false;// đánh dấu node đó đã đánh dấu

        /* thiết lập hàng đợi với đỉnh đầu là i */

        while (dauQ <= cuoiQ) {

            u = QUEUE[dauQ]; //Lấy gia tri đầu tiền của queue

            System.out.print(u + " "); // In giá trị

            dauQ = dauQ + 1; /* duyệt đỉnh đầu hàng đợi */

            for (j = 1; j <= n; j++) {

                if (G[u][j] == 1 && chuaxet[j]) {// kiểm tra đỉnh kề và nó kiểm tra đỉnh có đánh dấu kiểm tra rồi hay chưa

                    cuoiQ = cuoiQ + 1;// Tăng giá trị của queue

                    QUEUE[cuoiQ] = j;// Them vao hàng đợi

                    chuaxet[j] = false;// Đánh dấu node đã xét rồi

                }

            }

        }

    }


    public BFSAlgorithm() {

        init();
        // Đầu tiên đánh dấu tất cả các node chưa dyệt
        for (int i = 1; i <= n; i++) {

            chuaxet[i] = true;

        }

        System.out.print("\n");
        // Khi xet tất cả, kiểm tra còn node nào chưa xét
        for (int i = 1; i <= n; i++)

            if (chuaxet[i]) {

                BFS(i);

            }

    }


    public static void main(String[] args) {

        new BFSAlgorithm();

    }

}
