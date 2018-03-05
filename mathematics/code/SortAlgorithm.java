package sort;

import java.util.Arrays;

/**
 * �����㷨����
 *      - [?] ð������
 *              - 5 ��д��
 *              - �����Ż�����ӱ�־λ��
 *      - [?] ѡ������
 *              - 1 ��д��
 *              - �����Ż���˫�α��ƶ���
 *      - [?] ��������
 *              - 2 ��д��
 *              - ���ֲ�������
 *              - ϣ����������
 *      - [?] ��������
 *      - [?] �鲢����
 *      - [?] ������
 *
 * �������ڣ�2018.03.01
 * �����£�2018.03.05
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
        //sa.shellInsertSort(arr);

        //��������
        //sa.quickSort(arr, 0, arr.length - 1);
        //sa.quickSortOptimization(arr, 0, arr.length - 1);
        //System.out.println(Arrays.toString(arr));

        //�鲢����
        //int [] result = new int[arr.length];
        //sa.mergeSortByRecursive(arr, result, 0, arr.length - 1);
        //sa.mergeSortByForeach(arr);
        //System.out.println(Arrays.toString(arr));

        //������
        sa.heapSort(arr);
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
        for (; gap > 0; gap /= 3) {
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

    /*
     * ***********************************************
     * �������� method
     * ***********************************************
     */

    /**
     * ��������
     *      - ��õ���� O(n log n)�������� O(n^2)
     *      - ��Ҫ�Ƿ��η���һ�����зֳ���������
     *          1. �һ�׼
     *          2. ����������С�ķ��û�׼ǰ����ķ��û�׼��
     *          3. �ݹ��С�ڻ�׼ֵ�� �������С� �ʹ��ڻ�׼ֵԪ�ص� �������С� ����
     *
     * @param arr ��������
     * @param head ͷָ�루��
     * @param tail βָ�루�ң�
     */
    private void quickSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }

        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i ++;
            }

            while (arr[j] > pivot) {
                j --;
            }

            if (i < j) {
                this.swap(arr, i, j);

                i ++;
                j --;
            } else if (i == j) {
                i ++;
            }
        }

        this.quickSort(arr, 0, j);
        this.quickSort(arr, i, tail);
    }

    /**
     * �����Ż�
     *   - ԭ�أ�in-place�������İ汾
     *   - ƽ�����Դﵽ O(\log n) �ռ��ʹ�ø��Ӷ�
     *   - �ݹ鵽������г���Ϊ 1 | 0����ʾ�Ѿ��������
     *
     * @param arr ��
     * @param head ͷָ�루��
     * @param tail βָ�루�ң�
     */
    private void quickSortOptimization(int[] arr, int head, int tail) {
        if (head < tail) {
            int pivot = (head + tail) / 2 + 1;
            int pivotIndex = this.partition(arr, head, tail, pivot);
            this.quickSort(arr, head, pivotIndex - 1);
            this.quickSort(arr, pivotIndex + 1, tail);
        }
    }

    /**
     * ԭ�ط����㷨
     *      - ���ڿ��������Ż�
     *      - �������˱�ʾΪ"��ߣ�left��"��"�ұߣ�right��"�����в��֣�
     *         �����ƶ�С��a[pivotIndex]������Ԫ�ص������еĿ�ͷ���������д��ڻ���ڵ�Ԫ�ؽ������Ǻ��档
     *      - ˼·
     *          1. �����м�ֵ��Ȼ���м�ֵ������ĩβ
     *          2. ������ʱָ�루��ʼֵΪͷָ�룩�� ���� head -> right - 1����С���м�ֵ������������ͷָ�룬������
     *          3. ��������������С���м�ֵ��������ǰ�ˣ����򣩣���Ľ��ں��棨���򣩣�������м�ֵ
     *          4. ��ʱָ�루����ĵ�һ����ģ�����ĩβֵ�������õ�����ʱָ��-�м�ֵ
     *          5. �����м�ֵ��ָ��
     *      - ��ע�⡿һ��Ԫ���ڵ����������λ��ǰ�����ܻᱻ�����ܶ��
     *
     * @param arr ����
     * @param left ��ָ��
     * @param right ��ָ��
     * @param pivotIndex ��ָ�루�м�ֵ��
     * @return int ��ʱָ��
     */
    private int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];

        //pivot move to last
        this.swap(arr, pivotIndex, right);

        int tmpIndex = left;
        for (int i = left; i < right - 1; i ++) {
            if (arr[i] <= pivotValue) {
                this.swap(arr, tmpIndex, i);
                tmpIndex ++;
            }
        }

        //pivot move to it last
        this.swap(arr, right, tmpIndex);
        return tmpIndex;
    }

    /*
     * ***********************************************
     * �鲢����
     *      - �鲢����������������������кϳ�һ�����еĲ�����
     *      - ������
     *      - �ݹ鷨
     * ***********************************************
     */

    /**
     * �鲢���򣨵ݹ�棩
     *      - Ч��Ϊ O(n log n)
     *
     * @param arr ��������
     * @param result ������飨������ռ�, ���鳤���� arr ��ȣ�
     * @param start ǰָ��
     * @param end ��ָ��
     */
    private void mergeSortByRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }

        int len = end - start, mid = (len >> 2) + start;
        int head1 = start, tail1 = mid;
        int head2 = mid + 1, tail2 = end;
        this.mergeSortByRecursive(arr, result, head1, tail1);
        this.mergeSortByRecursive(arr, result, head2, tail2);

        int k = start;
        while (head1 <= tail1 && head2 <= tail2) {
            result[k++] = arr[head1] < arr[head2] ? arr[head1++] : arr[head2++];
        }

        while (head1 <= tail1) {
            result[k++] = arr[head1++];
        }

        while (head2 <= tail2) {
            result[k++] = arr[head2++];
        }

        //filling
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }


    /**
     * �鲢���򣨵�������
     *
     * @param arr ��������
     */
    private void mergeSortByForeach(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }

        int len = arr.length;
        int [] result = new int[len];
        int block, start;
        int low, mid, high;
        int head1, tail1;
        int head2, tail2;
        int [] tmp;

        for (block = 1; block < len; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                low = start;
                mid = (start + block) < len ? (start + block) : len;
                high = (start + 2 * block) < len ? (start + 2 * block) : len;

                head1 = low; tail1 = mid;
                head2 = mid; tail2 = high;

                //two block to merge sort
                while (head1 < tail1 && head2 < tail2) {
                    result[low ++] = arr[head1] < arr[head2] ? arr[head1 ++] : arr[head2 ++];
                }

                while (head1 < tail1) {
                    result[low ++] = arr[head1 ++];
                }

                while (head2 < tail2) {
                    result[low ++] = arr[head2 ++];
                }
            }

            tmp = result;
            result = arr;
            arr = tmp;
        }

        result = arr;
    }

    /*
     * ***********************************************
     * ������
     *      - ���ö��������ݽṹ��Ƶ�һ�������㷨
     *      - �ѻ���һ�ֽ��� '��ȫ������' �Ľṹ
     *          - ͬʱ����ѻ������ʣ� �ӽ��ļ�ֵ | ��������С�ڣ�or ���ڣ� ���ĸ��ڵ�
     * ***********************************************
     */

    /**
     * ������
     *      - ƽ��ʱ�临�Ӷȣ�O(n log n)
     *      - ����
     *          1. ����ѻ�
     *          2. �Զѻ���������
     *
     * @param arr ��������
     */
    private void heapSort(int [] arr) {
        //array -> heap
        int len = arr.length - 1;
        int beginIndex = (len - 1) / 2;
        for (int i = beginIndex; i >= 0; i --) {
            this.maxHeap(arr, i, len);
        }

        //sort -> heap type 'array'
        for (int i = len; i > 0; i --) {
            this.swap(arr, 0, i);
            this.maxHeap(arr, 0, i - 1);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * ���ѵݹ�
     *      - ��������Ϊ index �������ݣ�ʹ����϶ѵ�����
     *
     * @param arr ��������
     * @param index ��Ҫ�ѻ��������ݵ�����
     * @param len δ����Ķѣ����飩�ĳ���
     */
    private void maxHeap(int [] arr, int index, int len) {
        int leftIndex = (index * 2) + 1;
        int rightIndex = leftIndex + 1;
        int childMaxIndex = leftIndex;

        if (leftIndex > len) {
            return;
        }

        if (rightIndex <= len && arr[leftIndex] < arr[rightIndex]) {
            childMaxIndex = rightIndex;
        }

        if (arr[childMaxIndex] > arr[index]) {
            this.swap(arr, childMaxIndex, index);
            this.maxHeap(arr, childMaxIndex, len);
        }
    }
}
