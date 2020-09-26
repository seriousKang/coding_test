package programmers.lv2.basic;

public class MatrixMultiplication {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowLen = arr1.length;
        int colLen = arr2[0].length;

        int[][] transposeArr2 = transpose(arr2);

        int[][] result = new int[rowLen][colLen];
        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++) {
                // System.out.printf("arr1:%s, transposeArr2:%s, mul:%d\n",
                //                   Arrays.toString(arr1[i]), Arrays.toString(transposeArr2[j]), arrMultiplication(arr1[i], transposeArr2[j]));
                result[i][j] = arrMultiplication(arr1[i], transposeArr2[j]);
            }
        }

        return result;
    }

    public int arrMultiplication(int[] arr1, int[] arr2) {
        int sum=0;

        for(int i=0; i<arr1.length; i++) {
            sum += (arr1[i] * arr2[i]);
        }

        return sum;
    }

    public int[][] transpose(int[][] arr) {
        int rowLen = arr.length;
        int colLen = arr[0].length;
        int[][] targetArr = new int[colLen][rowLen];

        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++) {
                targetArr[j][i] = arr[i][j];
            }
        }

        return targetArr;
    }
}
