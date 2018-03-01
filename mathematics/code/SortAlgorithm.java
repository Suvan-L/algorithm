package sort;

import java.util.Arrays;

/**
 * �����㷨����
 *      - [?] ð������
 *              - 5 ��д��
 *              - �����Ż������ӱ�־λ��
 *      - [?] ѡ������
 *              - 1 ��д��
 *              - �����Ż���˫�α��ƶ���
 *      - [?] ��������
 *              - 2 ��д��
 *              - ���ֲ�������
 *              - ϣ����������
 *      - [ ] ϣ������
 *      - [ ] ��������
 *      - [ ] �鲢����
 *      - [ ] ������
 *
 * �������ڣ�2018.03.01
 * �����£�
 *
 * @author Suvan
 */
public class SortAlgorithm {

    /**
     * ������
     */
    public static void main(String [] args) {
        SortAlgorithm sa = new SortAlgorithm();

        int[] arr = {192, 8, 64, 73, 92, 210, 2, 64, 85, 79, 21};

        //ð������
        //sa.bubbleSort(arr);
        //sa.bubbleSortOptimization(arr);

        //ѡ������
        //sa.selectSort(arr);
        //sa.selectSortOptimization(arr);

        //��������
        //sa.insertSort(arr);
        //sa.binaryInsertSort(arr);

        //ϣ������
        sa.shellInsertSort(arr);
    }

    /*
     * ***********************************************
     * ˽�к���
     * ***********************************************
     */

    /**
     * ��������
     *
     * @param arr ��������
     * @param aIndex a �����±�
     * @param bIndex b �����±�
     */
    private void swap(int[] arr, int aIndex, int bIndex) {
        arr[aIndex] ^= arr[bIndex];
        arr[bIndex] ^= arr[aIndex];
        arr[aIndex] ^= arr[bIndex];
    }

    /**
     * ��ⲻ��Ϊ��
     *
     * @param arr ��������
     */
    private void checkNotNull(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("array is null!");
        }
    }


    /*
     * ***********************************************
     * ð������
     *      - ƽ��ʱ�临�Ӷ� O(n^2)
     * ***********************************************
     */

    /**
     * ð������
     *      - method 1: ����ð��
     *      - method 2; ˳��ð��
     *      - method 3: ����ð�ݣ�λ���㽻��Ԫ��
     *      - method 4: ˳��ð�ƣ��Ӽ�������Ԫ��
     *      - method 5: ����ð�ݣ��˳�������Ԫ��
     *
     * @param arr ��������
     */
     private void bubbleSort(int [] arr) {
         this.checkNotNull(arr);
         if (arr.length == 0 || arr.length == 1) {
             return;
         }

         //method 1
         //for (int i = 0, len = arr.length; i < len - 1; i ++) {
         //    for (int j = len - 1; j > i; j --) {
         //        if(arr[j - 1] > arr[j]) {
         //            int tmp = arr[j];
         //            arr[j] = arr[j - 1];
         //            arr[j - 1] = tmp;
         //        }
         //    }
         //}

         //method 2
         //for (int i = 0, len = arr.length; i < len - 1; i ++) {
         //    for (int j = i; j < len - 1 - i; j ++) {
         //        if (arr[j] > arr[j + 1]) {
         //            int tmp = arr[j];
         //            arr[j] = arr[j + 1];
         //            arr[j + 1] = tmp;
         //        }
         //    }
         //}

         //method 3
         //for (int i = 0, len = arr.length; i < len - 1; i ++) {
         //    for (int j = len - 1; j > i; j --) {
         //        if (arr[j - 1] > arr[j]) {
         //            arr[j] ^= arr[j - 1];
         //            arr[j - 1] ^= arr[j];
         //            arr[j] ^= arr[j - 1];
         //        }
         //    }
         //}

         //method 4
         //for (int i = 0, len = arr.length; i < len - 1; i ++) {
         //    for (int j = 0; j < len - 1 - i; j ++) {
         //        if (arr[j] > arr[j + 1]) {
         //            arr[j] = arr[j] + arr[j + 1];
         //            arr[j + 1] = arr[j] - arr[j + 1];
         //            arr[j] = arr[j] - arr[j + 1];
         //        }
         //    }
         //}

         //method 5
         for (int i = 0, len = arr.length; i < len - 1; i ++) {
             for (int j = len - 1; j > i; j --) {
                 if (arr[j - 1] > arr[j]) {
                     arr[j] *= arr[j - 1];
                     arr[j - 1] = arr[j] / arr[j - 1];
                     arr[j] = arr[j] / arr[j - 1];
                 }
             }
         }

         System.out.println(Arrays.toString(arr));
     }

     /**
      * ð�������Ż�
      *     - �����ʶλ����ĳ�α�������δ�������������ʾ������ɹ����˳���ѭ��
      *
      * @param arr ��������
      */
     private void bubbleSortOptimization(int [] arr) {
         this.checkNotNull(arr);
         if (arr.length == 0 || arr.length == 1) {
             return;
         }

         int len = arr.length;
         boolean flag = true;
         for (int i = 0; i < len - 1 && flag; i ++) {
             flag = false;

             for (int j = len - 1; j > i; j --) {
                 if (arr[j - 1] > arr[j]) {
                     arr[j] ^= arr[j - 1];
                     arr[j - 1] ^= arr[j];
                     arr[j] ^= arr[j - 1];
                     flag = true;
                 }
             }
         }

         System.out.println(Arrays.toString(arr));
     }


     /*
      * ***********************************************
      * ѡ������
      *     - ƽ��ʱ�临�Ӷ� O(n^2)
      * ***********************************************
      */

    /**
     * ѡ������
     *      - ÿ��ѡ����С�ģ�����������ʼλ�ã�����Ԫ�أ�
     *
     * @param arr ��������
     */
    private void selectSort(int [] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int min, minIndex;
        for (int i = 0, len = arr.length; i < len - 1; i ++) {
            min = arr[i];
             minIndex = i;
            for (int j = i + 1; j < len; j ++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        System.out.println(Arrays.toString(arr));
     }

    /**
     * ѡ�������Ż�
     *      - ÿ�α���Ѱ�����ֵ����Сֵ
     *          - ˫�α꣨ǰ��ָ�룩
     *          - ÿ�α�����¼��Сֵ index �����ֵ index
     *
     * @param arr ��������
     */
    private void selectSortOptimization(int[] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int minIndex, maxIndex;
        int firstPointer = 0, lastPointer = arr.length - 1;

        while (firstPointer < lastPointer) {
            minIndex = firstPointer;
            maxIndex = lastPointer;

            for (int i = firstPointer; i <= lastPointer; i ++) {
                if(arr[i] < arr[minIndex]) {
                    minIndex = i;
                } else if (arr[maxIndex] < arr[i]) {
                    maxIndex = i;
                }
            }

            if (minIndex != firstPointer) {
                swap(arr, firstPointer, minIndex);
            }
            if (maxIndex != lastPointer) {
                swap(arr, lastPointer, maxIndex);
            }

            firstPointer ++;
            lastPointer --;
        }

        System.out.println(Arrays.toString(arr));
    }


    /*
     * ***********************************************
     * ��������
     *      - ƽ��ʱ�临�Ӷ�ΪO��n^2��
     * ***********************************************
     */

    /**
     * ��������
     *      - �ӵ� 2 ��Ԫ�ؿ�ʼ������ѭ�������Ԫ�ض������ź���
     *      - ѭ�����Ԫ�ش�����ʱ���� tmp
     *      - ѭ����ǰ���Ԫ�ؽ��бȽϣ������� tmp��ѭ����Ԫ�أ���������ƶ�����ָ�� j ǰ��
     *      - �������������ָ�� + 1 λ�ø�ֵ tmp
     *
     *      //method 1: for + while ��Ч�ʻ����Щ����������ֵ�������Ƴ���ѭ����
     *      //method 2: for + for
     *
     * @param arr ��������
     */
    private void insertSort(int[] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        //method 1
        //int tmp, j;
        //for (int i = 1, len = arr.length; i < len; i ++) {
        //    tmp = arr[i];
        //
        //    j = i - 1;
        //    while (j >= 0 && arr[j] > tmp) {
        //        arr[j + 1] = arr[j];
        //        j --;
        //    }
        //
        //    arr[j + 1] = tmp;
        //}

        //method 2
        for (int i = 1, len = arr.length; i < len; i ++) {
            int tmp = arr[i];
            int pointer = i - 1;

            for (int j = i - 1; j >= 0; j --) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                    pointer --;
                } else {
                    break;
                }
            }

            if (pointer < i - 1) {
                arr[pointer + 1] = tmp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    /**
     * ���ֲ�������
     *      - ��������Ĳ��ֽ��ж��ֲ���
     *
     * @param arr ��������
     */
    private void binaryInsertSort(int[] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int tmp;
        int start, mid, end;
        int j;
        for (int i = 1, len = arr.length; i < len; i ++) {
            tmp = arr[i];

            //find
            start = 0;
            end = i - 1;
            while (start <= end) {
                mid = (start + end) / 2;

                if (arr[mid] <= tmp) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            //move
            for (j = i - 1; j >= start; j --) {
                arr[j + 1] = arr[j];
            }

            //while() finished, now start = end + 1
            arr[start] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * ϣ����������
     *      - ���ȶ��������㷨
     *
     * @param arr ��������
     */
    private void shellInsertSort(int[] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int gap = 1;
        int len = arr.length;
        int i, j;
        int temp;

        //set init gap capacity (: 1, 4, 13, 40, 121, ...)
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }

        //narrow down for-each, gap ----> / 3
        for(; gap > 0; gap /= 3) {
            for (i = gap; i < len; i ++) {
                temp = arr[i];

                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }

                arr[j + gap] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}