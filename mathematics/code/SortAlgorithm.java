package sort;

import java.util.Arrays;

/**
 * 排序算法整理
 *      - [?] 冒泡排序
 *              - 5 种写法
 *              - 排序优化（添加标志位）
 *      - [?] 选择排序
 *              - 1 种写法
 *              - 排序优化（双游标移动）
 *      - [?] 插入排序
 *              - 2 种写法
 *              - 二分插入排序
 *              - 希尔插入排序
 *      - [ ] 希尔排序
 *      - [ ] 快速排序
 *      - [ ] 归并排序
 *      - [ ] 堆排序
 *
 * 创建日期：2018.03.01
 * 最后更新：
 *
 * @author Suvan
 */
public class SortAlgorithm {

    /**
     * 主函数
     */
    public static void main(String [] args) {
        SortAlgorithm sa = new SortAlgorithm();

        int[] arr = {192, 8, 64, 73, 92, 210, 2, 64, 85, 79, 21};

        //冒泡排序
        //sa.bubbleSort(arr);
        //sa.bubbleSortOptimization(arr);

        //选择排序
        //sa.selectSort(arr);
        //sa.selectSortOptimization(arr);

        //插入排序
        //sa.insertSort(arr);
        //sa.binaryInsertSort(arr);

        //希尔排序
        sa.shellInsertSort(arr);
    }

    /*
     * ***********************************************
     * 私有函数
     * ***********************************************
     */

    /**
     * 交换函数
     *
     * @param arr 整型数组
     * @param aIndex a 数组下标
     * @param bIndex b 数组下标
     */
    private void swap(int[] arr, int aIndex, int bIndex) {
        arr[aIndex] ^= arr[bIndex];
        arr[bIndex] ^= arr[aIndex];
        arr[aIndex] ^= arr[bIndex];
    }

    /**
     * 检测不能为空
     *
     * @param arr 整型数组
     */
    private void checkNotNull(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("array is null!");
        }
    }


    /*
     * ***********************************************
     * 冒泡排序
     *      - 平均时间复杂度 O(n^2)
     * ***********************************************
     */

    /**
     * 冒牌排序
     *      - method 1: 倒序冒泡
     *      - method 2; 顺序冒泡
     *      - method 3: 倒序冒泡，位运算交换元素
     *      - method 4: 顺序冒牌，加减法交换元素
     *      - method 5: 倒序冒泡，乘除法交换元素
     *
     * @param arr 整型数组
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
      * 冒泡排序优化
      *     - 加入标识位，若某次遍历数组未发生交换，则表示已排序成功，退出外循环
      *
      * @param arr 整形数组
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
      * 选择排序
      *     - 平均时间复杂度 O(n^2)
      * ***********************************************
      */

    /**
     * 选择排序
     *      - 每次选择最小的，放在数组起始位置（交换元素）
     *
     * @param arr 整型数组
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
     * 选择排序优化
     *      - 每次遍历寻找最大值和最小值
     *          - 双游标（前后指针）
     *          - 每次遍历记录最小值 index 和最大值 index
     *
     * @param arr 整型数组
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
     * 插入排序
     *      - 平均时间复杂度为O（n^2）
     * ***********************************************
     */

    /**
     * 插入排序
     *      - 从第 2 个元素开始遍历，循环点左边元素都是已排好序
     *      - 循环点的元素存入临时变量 tmp
     *      - 循环点前面的元素进行比较，若大于 tmp（循环点元素），则向后移动，且指针 j 前移
     *      - 满足结束条件，指针 + 1 位置赋值 tmp
     *
     *      //method 1: for + while （效率会更高些，将变量赋值尽可能移出内循环）
     *      //method 2: for + for
     *
     * @param arr 整型数组
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
     * 二分插入排序
     *      - 对已排序的部分进行二分查找
     *
     * @param arr 整型数组
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
     * 希尔插入排序
     *      - 不稳定的排序算法
     *
     * @param arr 整型数组
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
